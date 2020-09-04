package demo.restservices.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Page<Stock> getStocks(String ticker, String date) {
       return stockRepository.findStockClosePriceByDate(ticker, date);
    }
}
