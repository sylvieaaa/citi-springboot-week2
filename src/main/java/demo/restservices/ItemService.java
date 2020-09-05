package demo.restservices;

import demo.restservices.mongodb.*;


public interface ItemService {

	public boolean createUser(String password, String name, String emailAddress);
	public User getUser(String email);
	// public User updateEmailAddress(String userId, String emailAddress);
	public boolean deleteUser(String userId);
}
