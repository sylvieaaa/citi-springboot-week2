package demo.restservices;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

	private static Map<Integer, CatalogItem> items = new HashMap<Integer, CatalogItem>();
	private int nextId = 1;
	
	// Populate collection with some simple Items, to get the ball rolling.
	{
		insert(new CatalogItem("Andy", "Swans jersey"));
		insert(new CatalogItem("Jayne", "Scarf"));
		insert(new CatalogItem("Emily", "Violin"));
		insert(new CatalogItem("Tom", "Saxophone"));
	}

	@Override
	public CatalogItem getItem(int id) {
		return items.get(id);
	}

	@Override
	public Collection<CatalogItem> getItems() {
		return items.values();
	}

	@Override
	public void insert(CatalogItem item) {
		item.setId(nextId++);
		items.put(item.getId(), item);
	}

	@Override
	public void update(CatalogItem item) {
		int id = item.getId();
		if (items.containsKey(id)) {
			items.put(id, item);
		}
	}

	@Override
	public void delete(int id) {
		CatalogItem item = items.get(id);
		if (item != null) {
			items.remove(id);
		}
	}
}
