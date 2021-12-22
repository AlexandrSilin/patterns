package Creational.factories.factoryMethod.managers;

import Creational.factories.factoryMethod.interviewers.Developer;
import Creational.factories.factoryMethod.interviewers.Interviewer;

public class DevelopmentManager extends HiringManager {
    @Override
    public Interviewer makeInterviewer() {
        return new Developer();
    }
}
