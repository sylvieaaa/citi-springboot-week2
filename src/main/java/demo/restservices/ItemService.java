package demo.restservices;

import demo.restservices.mongodb.Stock;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {

	 List<Stock> getStocks(String ticker, String date);
	//String getItems();

	//void insert(Stock item);
	// void update(Stock item);
	// void delete(long id);
}
