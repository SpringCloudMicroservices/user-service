package movies.userservice.repository;

import movies.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tri.bui on 8/2/16.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findFirstByUsernameAndPassword(String username, String password);
}
