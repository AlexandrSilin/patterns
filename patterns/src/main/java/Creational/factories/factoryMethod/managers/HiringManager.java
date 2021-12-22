package Creational.factories.factoryMethod.managers;

import Creational.factories.factoryMethod.interviewers.Interviewer;

public abstract class HiringManager {
    protected abstract Interviewer makeInterviewer();

    public void takeInterview() {
        makeInterviewer().askQuestions();
    }
}
