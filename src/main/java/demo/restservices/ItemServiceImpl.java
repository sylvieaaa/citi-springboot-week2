package demo.restservices;
import demo.restservices.mongodb.Stock;

import demo.restservices.mongodb.StockService;
import demo.restservices.mongodb.User;
import demo.restservices.mongodb.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemServiceImpl implements ItemService {

	// private static Map<Integer, Stock> items = new HashMap<Integer, CatalogItem>();
	// private int nextId = 1;

	@Autowired
	private UserRepository user;

	@Override
	public boolean createUser(String userId, String password, String name, String emailAddress) {
		if(user.getUserByEmail(emailAddress) != null){
			return user.createUser(userId, password, name, emailAddress);
		}
		return false;
	}

	@Override
	public User getUserByEmail(String emailAddress) {
		return user.getUserByEmail(emailAddress);
	}

	@Override
	public boolean deleteUser(String userId) {
		return user.deleteUser(userId);
	}

	@Override
	public User updateEmailAddress(String userId, String emailAddress) {
		return user.updateEmailAddress(userId, emailAddress);
	}
}
