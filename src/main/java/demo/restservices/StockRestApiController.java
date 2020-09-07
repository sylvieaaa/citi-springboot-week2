package demo.restservices;

import demo.restservices.mongodb.User;
import demo.restservices.mongodb.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StockRestApiController {

    @Autowired
    UserService userService;

    @Autowired
    StockApiService stockApiService;

    @GetMapping(value="/stock/{ticker}", produces={"application/json","application/xml"})
    public ResponseEntity<Double> dayReturn(@PathVariable String ticker,
                                    @RequestParam(value="email") String email) {
        User user = userService.getUser(email);
        if (user != null) {
            Double dayReturn = stockApiService.getDayReturn(ticker);
            return ResponseEntity.ok().body(dayReturn);
        }
        else return ResponseEntity.status(403).build();
    }

}