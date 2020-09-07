package demo.restservices;

import demo.restservices.mongodb.*;


public interface ItemService {

	public User createUser(String password, String name, String emailAddress);
	public User getUser(String email);
	public User updateEmailAddress(String password, String name, String emailAddress, String userId);
	public void deleteUser(String userId);
}
