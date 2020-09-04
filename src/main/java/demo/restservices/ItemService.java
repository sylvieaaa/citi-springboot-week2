package demo.restservices;

import demo.restservices.mongodb.Stock;

import java.util.Collection;


public interface ItemService {

	 Collection<Stock> getStocks(String ticker, String date);
	//String getItems();

	//void insert(Stock item);
	// void update(Stock item);
	// void delete(long id);
}
