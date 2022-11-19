package use_cases.fetch_study_data;

import entities.Participant;

interface FetchStudyDataOutputBoundary {

    void displayStudyData(Participant participant);

    void displayNoStudyAssociated(Participant participant);

    void displayAllStudyData(FetchStudyDataResponseModel response);
}
