package demo.restservices;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
public class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl service;



    @Test
    public void testCreateUser(){
        assertEquals(service.createUser("Hell0", "Bryan",
                "Bryan1@hotmail.com").getName(), "Bryan");
        assertEquals(service.createUser("Hell0", "Bryan",
                "Bryan2@hotmail.com").getPassword(), "Hell0");
        assertEquals(service.createUser("Hell0", "Bryan",
                "Bryan3@hotmail.com").getEmailAddress(), "Bryan3@hotmail.com");
    }

    @Test
    public void testGetUser(){
        Assert.assertNotNull(service.getUser("beiyi@gmail.com"));
    }



    @Test
    public void testUpdateEmailAddress(){
        assertEquals(service.updateEmailAddress("0002", "bryan",
                "newbryan@gmail.com", "0002").getEmailAddress(),"newbryan@gmail.com");
    }

    @Test
    public void testDeleteUser(){
        service.deleteUser("0002");
        assertNull(service.getUser("bryan@gmail.com"));
    }

}
