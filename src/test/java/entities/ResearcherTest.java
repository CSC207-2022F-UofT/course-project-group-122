package entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ResearcherTest extends UserTest {

    Researcher researcher1 = new Researcher(1, "username", "name");
    Researcher researcher2 = new Researcher(2, "", "name");
    Researcher researcher3 = new Researcher(3, "username", "");
    Researcher researcher4 = new Researcher(4, "", "");
    Participant participant1 = new Participant(5, "username", "name");
    Researcher researcher5 = new Researcher(6, "username", "name");

    @Test
    @Override
    public void getId() {
        super.getId();
        int currID = researcher1.getId();
        assertEquals(currID + 1, researcher2.getId());
        assertEquals(currID + 2, researcher3.getId());
        assertEquals(currID + 3, researcher4.getId());
        assertEquals(currID + 5, researcher5.getId());
    }


    @Test
    @Override
    public void getUsername() {
        super.getUsername();
        assertEquals("username", researcher1.getUsername());
        assertEquals("", researcher2.getUsername());
        assertEquals("username", researcher3.getUsername());
        assertEquals("", researcher4.getUsername());
    }


    @Test
    @Override
    public void getName() {
        super.getName();
        assertEquals("name", researcher1.getName());
        assertEquals("name", researcher2.getName());
        assertEquals("", researcher3.getName());
        assertEquals("", researcher4.getName());
    }


    @Test
    public void getListStudies() {
        assertEquals(0, researcher1.getListStudies().size());
        assertEquals(0, researcher2.getListStudies().size());
        assertEquals(0, researcher3.getListStudies().size());
        assertEquals(0, researcher4.getListStudies().size());
    }


    @Test
    public void getListStudies2() {
        ArrayList<Study> listStudies = new ArrayList<>();
        assertEquals(listStudies, researcher1.getListStudies());
    }


    @Test
    public void listStudiesContains() {
        Study study1 = new RandomizedStudy(1, "study1", 3);
        assertFalse(researcher1.listStudiesContains(study1));
    }


    @Test
    public void addToListStudies() {
        Study study2 = new RandomizedStudy(2, "study1", 3);
        assertFalse(researcher2.listStudiesContains(study2));
        assertTrue(researcher2.addToListStudies(study2));
        assertTrue(researcher2.listStudiesContains(study2));
        assertFalse(researcher2.addToListStudies(study2));
        Study study3 = new RandomizedStudy(3, "study2", 3);
        assertFalse(researcher2.listStudiesContains(study3));
        assertTrue(researcher2.addToListStudies(study3));
        assertTrue(researcher2.listStudiesContains(study3));
        assertEquals(2, researcher2.getListStudies().size());
    }


    @Test
    public void removeFromListStudies() {
        Study study3 = new RandomizedStudy(4, "study1", 3);
        assertFalse(researcher3.listStudiesContains(study3));
        assertTrue(researcher3.addToListStudies(study3));
        assertTrue(researcher3.listStudiesContains(study3));
        assertFalse(researcher3.addToListStudies(study3));
        Study study4 = new RandomizedStudy(5, "study2", 3);
        assertFalse(researcher3.listStudiesContains(study4));
        assertTrue(researcher3.addToListStudies(study4));
        assertTrue(researcher3.listStudiesContains(study4));
        assertEquals(2, researcher3.getListStudies().size());
        assertTrue(researcher3.removeFromListStudies(study3));
        assertFalse(researcher3.listStudiesContains(study3));
        assertEquals(1, researcher3.getListStudies().size());
        assertTrue(researcher3.removeFromListStudies(study4));
        assertFalse(researcher3.listStudiesContains(study4));
        assertEquals(0, researcher3.getListStudies().size());
    }
}