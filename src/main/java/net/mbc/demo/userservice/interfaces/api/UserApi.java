package net.mbc.demo.userservice.interfaces.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tri.bui on 1/12/17.
 */
@RestController
public class UserApi {
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public @ResponseBody GetUserResponse getUser(String id) {
        return new GetUserResponse(id);
    }
}
