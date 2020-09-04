package demo.restservices;
import demo.restservices.mongodb.Stock;

import demo.restservices.mongodb.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemServiceImpl implements ItemService {

	// private static Map<Integer, Stock> items = new HashMap<Integer, CatalogItem>();
	// private int nextId = 1;

	@Autowired
	private StockService stock;

	public Collection<Stock> getStocks(String ticker, String date) {
		System.out.println("ItemServiceImpl: " + stock.getStocks(ticker, date));
		return stock.getStocks(ticker, date);
	}

/*
	@Override
	public long getItem(String ) {
		return items.getStockId();
	}

	@Override
	public String getItems() {
		return items.toString();
	}

	@Override
	public void insert(Stock item) {
		item.setStockId(item.getStockId());
		items.put(item.getStockId());
	}


	// update date
	@Override
	public void update(Stock item, String date ) {
		long id = item.getStockId();
		if (item.getStockId() != -1) {
			items.setDate(date);
		}
	}

	// update volume
	@Override
	public void update(Stock item, int volume ) {
		long id = item.getStockId();
		if (item.getStockId() != -1) {
			items.setVolume(volume);
		}
	}

	@Override
	public void delete(long id) {
		Stock item = items.getStockId(id);
		if (item != null) {
			items.remove(id);
		}
	}*/
}
