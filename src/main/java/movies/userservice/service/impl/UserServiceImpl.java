package movies.userservice.service.impl;

import movies.userservice.exception.UserNotFoundException;
import movies.userservice.model.User;
import movies.userservice.repository.UserRepository;
import movies.userservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by tri.bui on 8/3/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        User user = userRepository.findFirstByUsernameAndPassword(username, password);
        if (user  == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public User getUser(String userId) throws UserNotFoundException {
        User user = userRepository.findOne(userId);
        if (user  == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
