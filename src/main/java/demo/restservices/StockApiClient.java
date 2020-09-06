package demo.restservices;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class StockApiClient {
    private String token = "add token here"; // TODO probably change to an environment variable
    private String baseAddress = "https://finnhub.io/api/v1/quote"; // TODO move to application.properties

    public double getDayReturn(String ticker) {
        RestTemplate template = new RestTemplate();
        String url = baseAddress + "?symbol=" + ticker.toUpperCase() + "&token=" + token;
        System.out.println(url);
        template.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
        Quote result = template.getForObject(url, Quote.class);
        return result.getDayReturn();
    }
}