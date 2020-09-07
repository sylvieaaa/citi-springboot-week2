package demo.restservices;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockApiClientTest {
    @Autowired StockApiClient client;

    @Test
    public void testGetQuote() {
        Quote quote = client.getQuote("AAPL");
        assertNotEquals(quote.getCurrent(), 0.0);
        assertNotEquals(quote.getHigh(), 0.0);
        assertNotEquals(quote.getLow(), 0.0);
        assertNotEquals(quote.getOpen(), 0.0);
        assertNotEquals(quote.getPreviousClose(), 0.0);
        assertNotEquals(quote.getTime(), 0);
    }
}