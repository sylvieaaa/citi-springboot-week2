package demo.restservices.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository {
    // Create user
    boolean createUser(String userId, String password, String name, String emailAddress);

    // Get user by email
    @Query("{ emailAddresss: ?0 }")
    User getUserByEmail(String emailAddress);

    // Delete user
    boolean deleteUser(String userId);

    // Update email
    User updateEmailAddress(String userId, String emailAddress);
}
