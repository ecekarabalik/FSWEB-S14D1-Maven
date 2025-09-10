package com.workintech.developers;

public class MidDeveloper extends Employee {
    public MidDeveloper(long id, String name, double salary) {
        super(id, name, salary);
    }
    @Override public void work() {
        setSalary(getSalary() * 1.08);
        System.out.println("Mid Developer is delivering features. Salary updated to " + getSalary());
    }
}