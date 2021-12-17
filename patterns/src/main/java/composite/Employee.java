package composite;

import java.math.BigDecimal;
import java.util.List;

public abstract class Employee {
    protected final String name;
    protected BigDecimal salary;
    protected List<String> roles;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
