package demo.restservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class StockApiClient {
    @Value("${spring.datasource.token}")
    private String token;
    @Value("${spring.datasource.baseurl}")
    private String baseAddress;

    public double getDayReturn(String ticker) {
        System.out.println(token);
        System.out.println(baseAddress);
        RestTemplate template = new RestTemplate();
        String url = baseAddress + "?symbol=" + ticker.toUpperCase() + "&token=" + token;
        System.out.println(url);
        template.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
        Quote result = template.getForObject(url, Quote.class);
        return result.getDayReturn();
    }
}