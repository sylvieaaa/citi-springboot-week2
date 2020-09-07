package demo.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockApiService {

    @Autowired StockApiClient client;

    public double getDayReturn(String ticker) {
        Quote quote = client.getQuote(ticker);
        double current = quote.getCurrent();
        double open = quote.getOpen();
        return (current - open) / open;
    }
}
