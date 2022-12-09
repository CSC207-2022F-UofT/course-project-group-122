package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class UserPoolTest {
    private User testUser1;
    private Map<String, User> testUsers1;
    private UserPool testUserPool1;

    @BeforeEach
    void setUp() {
        testUser1 = new Participant(1, "a", "b");
        testUsers1 = new HashMap<>();
        testUsers1.put(testUser1.getUsername(), testUser1);
        testUserPool1 = new UserPool(testUsers1);

    }

    @Test
    void getUser() {
        assertNull(testUserPool1.getUsers());

    }

    @Test
    void getUserById() {
    }

    @Test
    void checkUserType() {
    }

    @Test
    void userExists() {
    }

    @Test
    void addUser() {
        testUserPool1.addUser(testUser1);
        String expectString = testUser1.getUsername();
        assertEquals(testUser1, testUserPool1.getUser(expectString));
    }

    @Test
    void removeUser() {
    }

    @Test
    void testRemoveUser() {
    }

    @Test
    void getUsers() {
    }
}