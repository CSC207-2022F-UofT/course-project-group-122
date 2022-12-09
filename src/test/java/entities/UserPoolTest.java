package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class UserPoolTest {
    private User testParticipant1;
    private Map<String, User> testUsers1;
    private UserPool testUserPool1;

    @BeforeEach
    void setUp() {
        testParticipant1 = new Participant(1, "a", "b");
        testUsers1 = new HashMap<>();
        testUsers1.put(testParticipant1.getUsername(), testParticipant1);
        testUserPool1 = new UserPool(testUsers1);

    }

    @Test
    void getUser() {
        String expectString = testParticipant1.getUsername();
        assertEquals(testParticipant1, testUserPool1.getUser(expectString));

    }

    @Test
    void getUserById() {
        int expectNum = testParticipant1.getId();
        assertEquals(testParticipant1, testUserPool1.getUserById(expectNum));
    }

    @Test
    void checkUserType() {
        String expectString = "Participant";
        assertEquals(expectString, testUserPool1.checkUserType(testParticipant1.getUsername()));

    }

    @Test
    void userExists() {
        String expectString = testParticipant1.getUsername();
        assertTrue(testUserPool1.userExists(expectString));

    }

    @Test
    void addUser() {
        testUserPool1.addUser(testParticipant1);
        String expectString = testParticipant1.getUsername();
        assertEquals(testParticipant1, testUserPool1.getUser(expectString));
    }

    @Test
    void removeUser() {
        testUserPool1.addUser(testParticipant1);
        testUserPool1.removeUser(testParticipant1);
        String expectString = testParticipant1.getUsername();
        assertFalse(testUserPool1.userExists(expectString));
    }

    @Test
    void testRemoveUser() {
        testUserPool1.addUser(testParticipant1);
        String expectString = testParticipant1.getUsername();
        testUserPool1.removeUser(expectString);
        assertFalse(testUserPool1.userExists(expectString));
    }

    @Test
    void getUsers() {
        assertEquals(testUsers1, testUserPool1.getUsers());
    }
}