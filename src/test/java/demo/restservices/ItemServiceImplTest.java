package demo.restservices;

import demo.restservices.mongodb.User;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

public class ItemServiceImplTest {

    private ItemServiceImpl service = new ItemServiceImpl();
    User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");

    @Test
    public void testCreateUser(){
       // User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");
        when(service.createUser("Hell0","Bryan","Bryan@hotmail.com")).thenReturn(user);
    }

    @Test
    public void testGetUser(){
        //User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");
        when(service.getUser(anyString())).thenReturn(user);
        when(service.getUser("Bryan@hotmail.com")).thenReturn(user);
    }

    @Test
    public void testUpdateEmailAddress(){
       // User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");
        when(service.updateEmailAddress(anyString(),
                anyString(),anyString(),anyString())).thenReturn(user);

        assertEquals(service.updateEmailAddress("Hell0", "Bryan",
                "NewBryan@hotmail.com","001"),"NewBryan@hotmail.com");
    }

    @Test
    public void testDeleteUser(){
        when(service.deleteUser(anyString())).thenReturn(true);
    }

}
