package demo.restservices.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocks(String ticker, String date) {
        System.out.println("stockService: " + stockRepository.findStockClosePriceByDate(ticker, date));
       return stockRepository.findStockClosePriceByDate(ticker, date);
    }
}
