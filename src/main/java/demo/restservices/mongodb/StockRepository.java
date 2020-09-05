package demo.restservices.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Collection;

public interface StockRepository extends MongoRepository<Stock, String> {
    // date must be in YYYY-MM-DD
    @Query(value="{'Name': ?0, 'date': ?1}")
    Collection<Stock> findStockInfoByDate(String Name, String date);
}
