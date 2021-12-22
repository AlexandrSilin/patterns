package Structural.composite;

import java.math.BigDecimal;

public class Developer extends Employee {
    public Developer(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
