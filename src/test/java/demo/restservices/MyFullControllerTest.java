package demo.restservices;

import demo.restservices.mongodb.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyFullControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateUser() {

        //setting up the request body
        User user = new User();

        user.setUserId("0101");
        user.setEmailAddress("bryan_yijie@gmail.com");
        user.setName("Bryan_yijie");
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
    public void testGetUser() {
        ResponseEntity<User> responseEntity = restTemplate.exchange( "/api/user/yijie@gmail.com", HttpMethod.GET,
                null, new ParameterizedTypeReference<User>() {});
        User responseBody = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseBody.toString());
    }

    @Test
    public void testUpdateEmail() {

        //setting up the request body
        User user = new User();

        user.setUserId("0002");
        user.setEmailAddress("bryan1@gmail.com");
        user.setName("bryan");
        user.setPassword("0002");

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
