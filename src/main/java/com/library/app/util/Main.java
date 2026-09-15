package com.library.app.util;

import java.util.*;
import java.util.stream.Collectors;

record Employee(String name, String department, Integer salary){

}

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("John","IT",50000),
                new Employee("David","IT",70000),
                new Employee("Smith","HR",45000),
                new Employee("Mary","HR",60000),
                new Employee("Mike","Finance",80000),
                new Employee("Sam","Finance",75000)
        );
        Map<String, Optional<Employee>> highestSalaryEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::department, Collectors.maxBy(Comparator.comparing(Employee::salary))));
        System.out.println(highestSalaryEmployees);
        highestSalaryEmployees.forEach((dep, employee) -> {
            System.out.println("dep: "+dep+" -> emp: "+employee.get());
        });
    }
}
