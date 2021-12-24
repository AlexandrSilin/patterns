package Creational.factories.factoryMethod;

import Creational.factories.factoryMethod.interviewers.MarketingManager;
import Creational.factories.factoryMethod.managers.DevelopmentManager;
import Creational.factories.factoryMethod.managers.HiringManager;

public class Example {
    public static void main(String[] args) {
        HiringManager developer = new DevelopmentManager();
        HiringManager marketing = new MarketingManager();
        developer.takeInterview();
        marketing.takeInterview();
    }
}
