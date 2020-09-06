package demo.restservices;
import demo.restservices.mongodb.User;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
// @WebMvcTest(MyFullController.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyFullControllerTest {
    // @Autowired
    // MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetUser() {
        ResponseEntity<User> responseEntity = restTemplate.exchange( "/api/user/bryan@gmail.com", HttpMethod.GET,
                                            null, new ParameterizedTypeReference<User>() {});
        User responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseBody.toString());
    }
/*
    @Test
    public void testCreateUser() {
        ResponseEntity<User> responseEntity = restTemplate.exchange( "/api/user", HttpMethod.POST,
                null, new ParameterizedTypeReference<User>() {});
        User responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseBody.toString());
    }

 */

    @Test
    public void testCreateUser() {

        //setting up the request body
        User user = new User();

        user.setUserId("0101");
        user.setEmailAddress("bryan1@gmail.com");
        user.setName("Bryan");
        user.setPassword("pass123");

        //request entity is created with request body and headers
        HttpEntity<User> requestEntity = new HttpEntity<>(user);
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                "/api/user",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<User>() {});
        User responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseBody.toString());

    }

    @Test
    public void testUpdateEmail() {

        //setting up the request body
        User user = new User();

        user.setUserId("0101");
        user.setEmailAddress("bryan1@gmail.com");
        user.setName("Bryan");
        user.setPassword("pass123");

        //request entity is created with request body and headers
        HttpEntity<User> requestEntity = new HttpEntity<>(user);
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                "/api/user",
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<User>() {});
        User responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseBody.toString());

    }

}
