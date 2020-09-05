package demo.restservices.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {
    // Create user
    // boolean createUserById(String userId, String password, String name, String emailAddress);

    // Get user by email
    @Query("{ emailAddresss: ?0 }")
    User getUsersByEmailAddress(String emailAddress);
    // Delete user
    boolean deleteUserByUserId(String userId);

    // Update email
    // User updateUserByEmailAddress(String userId, String emailAddress);
}
