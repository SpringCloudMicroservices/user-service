package movies.userservice.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import movies.userservice.exception.UserNotFoundException;
import movies.userservice.model.User;
import movies.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by tri.bui on 8/10/16.
 */
@RestController
@Configuration
public class UsersController {
    @Value("${jwt.secret.key}")
    String jwtSecretKey;

    @Inject
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest request) throws UserNotFoundException {
        if (request.username == null) {
            throw new UserNotFoundException();
        }

        User user = userService.getUserByUsernameAndPassword(request.username, request.password);
        return new LoginResponse(Jwts.builder().setSubject(user.getId())
                .claim("userId", user.getId()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, jwtSecretKey).compact());
    }

    @RequestMapping(value = "/api/users/{userId}")
    public User getUser(@PathVariable("userId") String userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    private static class LoginRequest {
        public String username;
        public String password;
    }

    private static class LoginResponse {
        public String token;

        public LoginResponse(String token) {
            this.token = token;
        }
    }
}
