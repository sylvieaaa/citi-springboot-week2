package demo.restservices.mongodb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepo;

    @InjectMocks
    private UserService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser(){
        User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");
        when(mockUserRepo.save(user)).thenReturn(user);
    }

    @Test
    public void testGetUser(){
        User user = new User("Hell0", "Bryan", "Bryan@hotmail.com");
        when(mockUserRepo.getUsersByEmailAddress(anyString())).thenReturn(user);
    }
    
    @Test
    public void testDeleteUser(){
        doNothing().when(mockUserRepo).deleteById(anyString());
        // when(service.deleteUser(anyString())).thenReturn(true);
    }
}
