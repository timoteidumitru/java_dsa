package com.javaPlayground.comparableAndComparator;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Employee> itDepartment = new ArrayList<>();
        Employee mike = new Employee(2, "Mike", 1000, 24);
        Employee jane = new Employee(1, "Jane", 1200, 22);
        Employee james = new Employee(4, "John", 1441, 28);
        Employee alex = new Employee(3, "Alex", 1355, 26);

        itDepartment.add(mike);
        itDepartment.add(jane);
        itDepartment.add(james);
        itDepartment.add(alex);
        itDepartment.sort(new AgeComparator());

        System.out.println(itDepartment);
    }
}
