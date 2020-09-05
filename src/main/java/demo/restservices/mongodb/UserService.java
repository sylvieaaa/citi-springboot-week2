package demo.restservices.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean createUser(String password, String name, String emailAddress) {
        User user = new User(password, name, emailAddress);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public User getUser(String email) {
        return userRepository.getUserByEmail(email);
    }

    public boolean deleteUser(String userId) {
        try {
            userRepository.deleteUser(userId);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /*
        1. If the entity with the given id is not available in collection in Mongo database, then save() will work same as insert method of MongoRepository and inserts the entity.
        2. If the entity with the given id is already there in collection in Mongo database, then save() method will update the entity.
        https://www.concretepage.com/spring-5/spring-data-mongorepository-update
    */
    public User updateEmailAddress(String userId, String emailAddress) {
        User user = new User(userId, emailAddress);
        userRepository.save(user);
        return userRepository.getUserByEmail(emailAddress);
    }
}
