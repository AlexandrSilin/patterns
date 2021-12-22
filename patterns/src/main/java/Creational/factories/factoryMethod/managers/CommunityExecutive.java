package Creational.factories.factoryMethod.managers;

import Creational.factories.factoryMethod.interviewers.Interviewer;

public class CommunityExecutive implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about community building");
    }
}
