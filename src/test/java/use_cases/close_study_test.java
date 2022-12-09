package use_cases;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import entities.*;

import use_cases.close_study.*;

public class close_study_test {

    @Test
    void closestudytest(){

        CloseStudyPresenter presenter = new CloseStudyPresenter();

        CloseStudyInputBoundary Interactor = new CloseStudyInteractor();

        Interactor.closeStudy(4, 3);

    }




}
