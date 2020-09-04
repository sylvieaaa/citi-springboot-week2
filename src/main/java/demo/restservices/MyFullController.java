package demo.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/itemManager")
@CrossOrigin
public class MyFullController {

	@Autowired
	private ItemService service;

	// Get all items.
	@GetMapping(value="/items", produces={"application/json","application/xml"})
	public Collection<CatalogItem> getItems() {
		return service.getItems();
	}

	// Get a specific item.
	@GetMapping(value="/item/{id}", produces={"application/json","application/xml"})
	public CatalogItem getItem(@PathVariable int id) {
		return service.getItem(id);
	}

	// Insert a new item.
	@PostMapping(value="/item",
			     consumes={"application/json","application/xml"},
			     produces={"application/json","application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public CatalogItem addItem(@RequestBody CatalogItem item) {
		service.insert(item);
		return item;
	}

	// Update an existing item.
	@PutMapping(value="/item/{id}", consumes={"application/json","application/xml"})
	public void modifyItem(@PathVariable int id, @RequestBody CatalogItem item) {
		System.out.println("Modifying item to " + item);
		service.update(item);
	}

	// Delete an existing item.
	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable int id) {
		service.delete(id);
	}
}
