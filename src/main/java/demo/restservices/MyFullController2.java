package demo.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@Controller
@RequestMapping(value="/itemManager2")
@CrossOrigin
public class MyFullController2 {

	@Autowired
	private ItemService service;

	// Get all items.
	@GetMapping(value="/items", produces={"application/json","application/xml"})
	public ResponseEntity<Collection<CatalogItem>> getItems() {
		Collection<CatalogItem> result = service.getItems();
		return ResponseEntity.ok().body(result);
	}

	// Get a specific item.
	@GetMapping(value="/item/{id}", produces={"application/json","application/xml"})
	public ResponseEntity<CatalogItem> getItem(@PathVariable int id) {
		CatalogItem result = service.getItem(id);
		if (service.getItem(id) == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(result);
	}

	// Insert a new item.
	@PostMapping(value="/item",
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public ResponseEntity<CatalogItem> addItem(@RequestBody CatalogItem item) {
		service.insert(item);
		URI uri = URI.create("/item/" + item.getId());
		return ResponseEntity.created(uri).body(item);
	}

	// Update an existing item.
	@PutMapping(value="/item/{id}", consumes={"application/json","application/xml"})
	public ResponseEntity modifyItem(@PathVariable int id, @RequestBody CatalogItem item) {
		if (service.getItem(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.update(item);
			return ResponseEntity.ok().build();
		}
	}

	// Delete an existing item.
	@DeleteMapping("/item/{id}")
	public ResponseEntity deleteItem(@PathVariable int id) {
		if (service.getItem(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
