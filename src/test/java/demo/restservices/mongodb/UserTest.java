package demo.restservices.mongodb;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {

    private User testUser = new User("Hell0","Bryan","Bryani@gmail.com", "010203");

    @Test
    public void user_getName_correct(){
        assertEquals(testUser.getName(), "Bryan");
    }

    @Test
    public void user_getEmailAddress_correct(){
        assertEquals(testUser.getEmailAddress(), "Bryani@gmail.com");
    }

    @Test
    public void user_getUserId_correct(){
        assertEquals(testUser.getUserId(), "010203");
    }

    @Test
    public void user_getUserPassword_correct(){
        assertEquals(testUser.getPassword(),"Hell0");
    }

    @Test
    public void user_setName_correct(){
        testUser.setName("Yi Jie");
        assertEquals(testUser.getName(), "Yi Jie");
    }

    @Test
    public void user_setEmailAddress_correct(){
        testUser.setEmailAddress("yijie@gmail.com");
        assertEquals(testUser.getEmailAddress(), "yijie@gmail.com");
    }

    @Test
    public void user_setPassword_correct(){
        testUser.setPassword("NewHell0");
        assertEquals(testUser.getPassword(),"NewHell0");
    }

    @Test
    public void user_setUserId_correct(){
        testUser.setUserId("thisIsAUserId");
        assertEquals(testUser.getUserId(),"thisIsAUserId");
    }


}
