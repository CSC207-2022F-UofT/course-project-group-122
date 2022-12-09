package use_cases;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.remove_researcher.RemoveResearcherInputBoundary;
import use_cases.remove_researcher.RemoveResearcherInteractor;





public class remove_resercherTest {

        Researcher researcher1 = new Researcher("username", "name");
        Study study1 = new Study("title", 3);


        @Test
        public void removeResearcherFromStudyTest(){

                RemoveResearcherInputBoundary interactor = new RemoveResearcherInteractor();

                interactor.removeResearcherFromStudy(3, 5, 6);

        }
}
