package demo.restservices.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String password, String name, String emailAddress) {
        try {
            User existingUser = this.getUser(emailAddress);
            if (existingUser == null) {
                User user = new User(password, name, emailAddress);
                userRepository.save(user);
                return user;
            } else {
                return null;
            }
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public User getUser(String email) {
        return userRepository.getUsersByEmailAddress(email);
    }

    // return true if successfully deleted, otherwise return false if not found
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    /*
        1. If the entity with the given id is not available in collection in Mongo database, then save() will work same as insert method of MongoRepository and inserts the entity.
        2. If the entity with the given id is already there in collection in Mongo database, then save() method will update the entity.
        https://www.concretepage.com/spring-5/spring-data-mongorepository-update
     */
    public User updateEmailAddress(String password, String name, String emailAddress, String userId) {
        User user = new User(userId, password, name, emailAddress);
        userRepository.save(user);
        return userRepository.getUserById(userId);
    }


}
