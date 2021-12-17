package composite;

import java.math.BigDecimal;

public class Example {
    public static void main(String[] args) {
        Organization organization = new Organization();
        organization.addEmployee(new Developer("Developer", BigDecimal.valueOf(12345L)));
        organization.addEmployee(new Designer("Designer", BigDecimal.valueOf(1234L)));
        System.out.println("Net salaries: " + organization.getNetSalaries());
    }
}
