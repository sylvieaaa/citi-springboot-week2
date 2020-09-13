package demo.restservices;

import demo.restservices.mongodb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MyFullController {

	@Autowired
	private ItemService service;

	// Get users by email
	@GetMapping(value="/user/{email}", produces={"application/json","application/xml"})
	public ResponseEntity<User> getUser(@PathVariable String email) {
		User result = service.getUser(email);
		System.out.println(result);
		if (result == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(result);
		}
	}

	// Insert a new item.
	@PostMapping(value = "/user",
				consumes={"application/json","application/xml"},
				produces={"application/json","application/xml"})
	public ResponseEntity createUser(@RequestBody User user) {
		User newUser = service.createUser(user.getPassword(), user.getName(), user.getEmailAddress());
		URI uri = URI.create("/user");
		if (newUser == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate email");
		}
		return ResponseEntity.created(uri).body(newUser);
	}
/*
	@PostMapping(value="/createUser",
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public ResponseEntity<CatalogItem> addItem(@RequestBody User user) {
		service.insert(user);
		URI uri = URI.create("/item/" + item.getId());
		return ResponseEntity.created(uri).body(item);
		
 */

	// Update an existing item.
	 @PutMapping(value="/user", consumes={"application/json","application/xml"})
	 public ResponseEntity updateEmail(@RequestBody User user) {
	 	try {
			if (service.getUser(user.getEmailAddress()) == null) {
				User resultingUser = service.updateEmailAddress(user.getPassword(), user.getName(), user.getEmailAddress(), user.getUserId());
				return ResponseEntity.ok().body(resultingUser);
			} else {
				return ResponseEntity.badRequest().body("Bad Request");
			}
		} catch (IncorrectResultSizeDataAccessException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate email");
		}
	 }

	// Delete an existing item.
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUser(@PathVariable String id) {
		service.deleteUser(id);
		return ResponseEntity.ok().body("Successfully deleted");
	}
}
