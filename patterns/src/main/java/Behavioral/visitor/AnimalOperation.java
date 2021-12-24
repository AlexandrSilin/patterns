package Behavioral.visitor;

import Behavioral.visitor.animals.Dolphin;
import Behavioral.visitor.animals.Lion;
import Behavioral.visitor.animals.Monkey;

public interface AnimalOperation {
    void visitMonkey(Monkey monkey);

    void visitLion(Lion lion);

    void visitDolphin(Dolphin dolphin);
}
