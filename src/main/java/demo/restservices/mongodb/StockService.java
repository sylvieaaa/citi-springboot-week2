package demo.restservices.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Collection<Stock> getStocks(String ticker, String date) {
        return stockRepository.findStockInfoByDate(ticker, date);
    }
}
