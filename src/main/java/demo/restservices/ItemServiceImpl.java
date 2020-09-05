package demo.restservices;
import demo.restservices.mongodb.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private UserService user;

	@Override
	public boolean createUser(String password, String name, String emailAddress){
		return user.createUser(password, name, emailAddress);
	}

	@Override
	public User getUser(String email) {
		return user.getUser(email);
	}
/*
	@Override
	public User updateEmailAddress(String userId, String name, String emailAddress) {
		return user.updateEmailAddress(userId, name, emailAddress);
	}
	
 */

	@Override
	public boolean deleteUser(String userId) {
		return user.deleteUser(userId);
	}
}
