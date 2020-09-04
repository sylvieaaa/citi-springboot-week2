package demo.restservices.mongodb;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockRepository extends MongoRepository<Stock, Long> {
    // date must be in YYYY-MM-DD
    @Query("{'Name': ?0, 'date': ?1}")
    Page<Stock> findStockClosePriceByDate(String ticker, String date);
}
