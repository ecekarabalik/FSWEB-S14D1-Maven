package com.workintech.developers;

public class JuniorDeveloper extends Employee {
    public JuniorDeveloper(long id, String name, double salary) {
        super(id, name, salary);
    }
    @Override public void work() {
        setSalary(getSalary() * 1.05);
        System.out.println("Junior Developer is learning and coding. Salary updated to " + getSalary());
    }
}