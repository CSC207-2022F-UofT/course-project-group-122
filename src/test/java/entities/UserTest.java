package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UserTest {

    @BeforeEach
    public void setUp() throws Exception {
    }


    @AfterEach
    public void tearDown() throws Exception {
    }

    User user = new User(1, "username", "name");
    User user2 = new User(2, "username2", "name2");
    User user3 = new User(3, "username3", "name3");
    User user4 = new User(4, "username4", "name4");
    User user5 = new User(5, "", "name");
    User user6 = new User(6, "username", "");
    User user7 = new User(7, "", "");

    @Test
    public void getId() {
        // We do not directly instantiate User, but instead instantiate a subclass of User
        // Here we instantiate a user to force it to test the automatic ID generation

        int currID = user.getId();

        assertEquals(currID + 1, user2.getId());
        assertEquals(currID + 2, user3.getId());
        assertEquals(currID + 3, user4.getId());
        assertEquals(currID + 4, user5.getId());
        assertEquals(currID + 5, user6.getId());
        assertEquals(currID + 6, user7.getId());
    }


    @Test
    public void getUsername() {
        assertEquals("username", user.getUsername());
    }


    @Test
    public void getUsername2() {

        assertEquals("", user5.getUsername());
    }


    @Test
    public void getName() {
        User user = new User(8, "username", "name");
        assertEquals("name", user.getName());
    }


    @Test
    public void getName2() {

        assertEquals("", user6.getName());
    }


    @Test
    public void emptyInput() {

        assertEquals("", user7.getUsername());
        assertEquals("", user7.getName());
    }
}