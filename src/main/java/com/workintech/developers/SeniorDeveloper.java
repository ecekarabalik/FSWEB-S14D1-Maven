package com.workintech.developers;

public class SeniorDeveloper extends Employee {
    public SeniorDeveloper(long id, String name, double salary) {
        super(id, name, salary);
    }
    @Override public void work() {
        setSalary(getSalary() * 1.12);
        System.out.println("Senior Developer is leading and optimizing. Salary updated to " + getSalary());
    }
}