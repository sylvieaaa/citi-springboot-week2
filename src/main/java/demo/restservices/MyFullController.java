package demo.restservices;

import demo.restservices.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/userManager")
@CrossOrigin
public class MyFullController {

	@Autowired
	private ItemService service;

	// Get users by email
	@GetMapping(value="/User/{email}", produces={"application/json","application/xml"})
	public ResponseEntity<User> getItems(@PathVariable String email) {
		User result = service.getUser(email);
		return ResponseEntity.ok().body(result);
	}

	// Insert a new item.
	@PostMapping(value = "/User",
				consumes={"application/json","application/xml"},
				produces={"application/json","application/xml"})
	public ResponseEntity<User> createUser( @RequestParam("name") String name,
											@RequestParam("email") String email,
											@RequestParam("password") String password,
						   					@RequestBody User user) {
		service.createUser(password,name,email);
		URI uri = URI.create("/User/" + user.getEmailAddress());
		return ResponseEntity.created(uri).body(user);
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
	// @PutMapping(value="/updateUser", consumes={"application/json","application/xml"})
	// public void updateEmail(@RequestParam("id") String id,
	//					   @RequestParam("email") String email,
	//					   @RequestBody User user) {
	//	service.updateEmailAddress(id, email);
	//}

	// Delete an existing item.
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable String id) {
		if (service.deleteUser(id)){
			return ResponseEntity.ok().build();
		}
		else{
			return ResponseEntity.notFound().build();
		}
	}
}
