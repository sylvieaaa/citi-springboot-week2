package demo.restservices.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    // Create user
//     boolean createUser(String password, String name, String emailAddress);

    // Get user by email
    @Query("{ emailAddress: ?0 }")
    User getUsersByEmailAddress(String emailAddress);

    @Query("{ _id: ?0 }")
    User getUserById(String userId);

    // Update email
    // User updateUserByEmailAddress(String userId, String emailAddress);
}
