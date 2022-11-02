package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

class UserFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() throws Exception {
        UserFactory userFactory = new UserFactory();
        User newUser = userFactory.create("Participant", "annarxy", "anna");
        assertTrue(newUser.getClass().equals(Participant.class));
    }
}