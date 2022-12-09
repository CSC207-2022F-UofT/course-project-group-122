package use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.researcher_enroller.ResearcherEnrollerInteractor;

import use_cases.researcher_enroller.*;

public class researcher_enrollerTest {

    @Test
    public void enrollResearcherTest(){

        ResearcherEnrollerPresenter presenter = new ResearcherEnrollerPresenter();

        Study study = new Study("title", 3);

        Researcher researcher = new Researcher("username", "name");

        ResearcherEnrollerInteractor interactor = new use_cases.researcher_enroller.ResearcherEnrollerInteractor();

        interactor.enrollResearcher(researcher.getId(), study.getId(), researcher.getId());

        assertTrue(researcher.getListStudies().contains(study));



    }
}
