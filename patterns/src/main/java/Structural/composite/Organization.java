package Structural.composite;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Organization {
    private final Set<Employee> employees;

    public Organization() {
        employees = new HashSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public BigDecimal getNetSalaries() {
        BigDecimal netSalaries = new BigDecimal(BigInteger.ZERO);
        for (Employee employee : employees) {
            netSalaries = netSalaries.add(employee.salary);
        }
        return netSalaries;
    }
}
