package demo.restservices;

import demo.restservices.mongodb.User;
import demo.restservices.mongodb.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private UserService userService;

	@Override
	public User createUser(String password, String name, String emailAddress){
		return userService.createUser(password, name, emailAddress);
	}

	@Override
	public User getUser(String email) {
		return userService.getUser(email);
	}

	@Override
	public User updateEmailAddress(String password, String name, String emailAddress, String userId) {
		return userService.updateEmailAddress(password, name, emailAddress, userId);
	}

	@Override
	public void deleteUser(String userId) {
		userService.deleteUser(userId);
	}
}
