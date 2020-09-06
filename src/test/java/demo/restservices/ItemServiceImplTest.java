package demo.restservices;

import demo.restservices.mongodb.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl service;

    User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");

    @Test
    public void testCreateUser(){
        // unable to use assertEquals when user returns userId which hard to be verified.
        // Hence have to check the value one by one
        assertEquals(service.createUser("Hell0", "Bryan",
                "Bryan@hotmail.com").getName(), user.getName());
        assertEquals(service.createUser("Hell0", "Bryan",
                "Bryan@hotmail.com").getPassword(), user.getPassword());
        assertEquals(service.createUser("Hell0", "Bryan",
                "Bryan@hotmail.com").getEmailAddress(), user.getEmailAddress());
    }

    @Test
    public void testGetUser(){
        // List<User> expResult = new ArrayList<>();
        // User user1 = service.createUser("Hell01", "Bryan1","Bryan1@hotmail.com");
        // User user2 = service.createUser("Hell02", "Bryan2", "Bryan1@hotmail.com");
        // User user3 = service.createUser("Hell03", "Bryan3", "Bryan1@hotmail.com");
        // expResult.add(user1);
        // expResult.add(user2);
        // expResult.add(user3);
        Assert.assertNotNull(service.getUser(anyString()));

       //  assertEquals(expResult, result);
    }



    @Test
    public void testUpdateEmailAddress(){
        assertEquals(service.updateEmailAddress("Hell0", "Bryan",
                "NewBryan@hotmail.com","001").getEmailAddress(),"NewBryan@hotmail.com");
    }

    @Test
    public void testDeleteUser(){
        assertEquals(service.deleteUser(anyString()),true);
    }

}
