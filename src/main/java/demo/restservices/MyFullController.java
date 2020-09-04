package demo.restservices;

import demo.restservices.mongodb.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/stockManager")
@CrossOrigin
public class MyFullController {

	@Autowired
	private ItemService service;

	// Get all items.
	@GetMapping(value="/stocks/{ticker}/{date}", produces={"application/json","application/xml"})
	public List<Stock> getItems(@PathVariable String ticker,
								@PathVariable String date) {
		System.out.println("Controller: " + service.getStocks(ticker, date));
		return service.getStocks(ticker, date);
	}
/*
	// Get a specific item.
	@GetMapping(value="/stocks/{ticker, date}", produces={"application/json","application/xml"})
	public Stock getItem(@PathVariable String id) {
		return service.getItem(id);
	}

	// Insert a new item.
	@PostMapping(value="/stock",
			     consumes={"application/json","application/xml"},
			     produces={"application/json","application/xml"})
	@ResponseStatus(HttpStatus.CREATED)
	public Stock addItem(@RequestBody Stock item) {
		service.insert(item);
		return item;
	}

	// Update an existing item.
	// @PutMapping(value="/Stock/{id}", consumes={"application/json","application/xml"})
	// public void modifyItem(@PathVariable long id, @RequestBody Stock item) {
	//	System.out.println("Modifying item to " + item);
	//	service.update(item);
	//}

	// Delete an existing item.
	// @DeleteMapping("/Stock/{id}")
	// public void deleteItem(@PathVariable long id) {
	//	service.delete(id);
	//}*/
}
