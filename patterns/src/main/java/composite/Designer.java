package composite;

import java.math.BigDecimal;

public class Designer extends Employee {
    public Designer(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
