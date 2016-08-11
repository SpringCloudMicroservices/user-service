package movies.userservice.service;


import movies.userservice.exception.UserNotFoundException;
import movies.userservice.model.User;

/**
 * Created by tri.bui on 8/9/16.
 */
public interface UserService {
    User getUser(String userId) throws UserNotFoundException;
    User getUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;
}
