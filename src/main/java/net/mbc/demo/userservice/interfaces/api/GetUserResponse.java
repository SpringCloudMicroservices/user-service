package net.mbc.demo.userservice.interfaces.api;

/**
 * Created by tri.bui on 1/12/17.
 */
public class GetUserResponse {
    public String username;

    public GetUserResponse(String id) {
        this.username = "user" + id;
    }
}
