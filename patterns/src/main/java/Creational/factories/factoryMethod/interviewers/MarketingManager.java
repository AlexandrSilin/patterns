package Creational.factories.factoryMethod.interviewers;

import Creational.factories.factoryMethod.managers.CommunityExecutive;
import Creational.factories.factoryMethod.managers.HiringManager;

public class MarketingManager extends HiringManager {
    @Override
    public Interviewer makeInterviewer() {
        return new CommunityExecutive();
    }
}
