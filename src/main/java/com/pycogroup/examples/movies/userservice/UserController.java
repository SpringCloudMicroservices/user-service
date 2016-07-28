package com.pycogroup.examples.movies.userservice;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by tri.bui on 7/20/16.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    final Map<String, User> userStore = ImmutableMap.of(
            "kid", new User("kid", 5),
            "adult", new User("adult", 30)
    );

    @RequestMapping("/{user}")
    public @ResponseBody User getUser(@PathVariable(value="user")String user) {
        return userStore.get(user);
    }
}

@Data
@AllArgsConstructor
class User {
    String name;
    int age;
}
