package Behavioral.visitor.visitors;

import Behavioral.visitor.AnimalOperation;
import Behavioral.visitor.animals.Dolphin;
import Behavioral.visitor.animals.Lion;
import Behavioral.visitor.animals.Monkey;

public class Speak implements AnimalOperation {

    @Override
    public void visitMonkey(Monkey monkey) {
        monkey.voice();
    }

    @Override
    public void visitLion(Lion lion) {
        lion.voice();
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        dolphin.voice();
    }
}
