package demo.restservices;

import demo.restservices.mongodb.*;
import java.util.Collection;


public interface ItemService {

	boolean createUser(String userId, String password, String name, String emailAddress);
	User getUserByEmail(String emailAddress);
	boolean deleteUser(String userId);
	User updateEmailAddress(String userId, String emailAddress);
}
