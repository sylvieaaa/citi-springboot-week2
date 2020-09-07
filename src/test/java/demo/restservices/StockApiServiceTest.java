package demo.restservices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class StockApiServiceTest {

    @MockBean
    private StockApiClient mockClient;

    @Autowired StockApiService service;

    @Test
    void testGetDayReturn() {
        Quote mockQuote = new Quote();
        mockQuote.setCurrent(1.0);
        mockQuote.setOpen(0.5);
        when(mockClient.getQuote(anyString())).thenReturn(mockQuote);
        assertEquals(service.getDayReturn("HELLOWORLD"), 1.0);
    }
}