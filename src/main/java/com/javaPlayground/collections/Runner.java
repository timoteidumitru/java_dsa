package com.javaPlayground.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        final List<String> list = new ArrayList<>(); // runtime polymorphism
        list.add("hey");
        list.add("sup");

        System.out.println(list);

        HashSet<Employee> firmX = new HashSet<>();
        Employee employee1 = new Employee(1, "Mike");
        Employee employee2 = new Employee(1, "Mike");
        Employee employee3 = new Employee(2, "Jane");

        firmX.add(employee1);
        firmX.add(employee2);
        firmX.add(employee3);

        System.out.println(firmX);
    }
}
