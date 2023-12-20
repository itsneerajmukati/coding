package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {

               
        // Employee employee1 = new Employee("E1", 1, 100,"D1");
        // Employee employee2 = new Employee("E2", 2, 200,"D1");
        // Employee employee3 = new Employee("E3", 3, 50,"D2");
        // List<Employee> employees = new ArrayList<>();
        // employees.add(employee1);
        // employees.add(employee2);
        // employees.add(employee3);
        // filter(employees);
        
    }
    private static void max(List<Employee> employees) {
        Employee e = employees.stream().max( (o1,o2) -> {
                    return o1.getSalary().compareTo(o2.getSalary());
            }).get();
        System.out.println(e.getName());
    }

    private static void min(List<Employee> employees) {
        Employee e = employees.stream().min( (o1,o2) -> {
                    return o1.getSalary().compareTo(o2.getSalary());
            }).get();
        System.out.println(e.getName());
    }

    private static void sort(List<Employee> employees) {
        List<Employee> sortedEmployees = employees.stream().sorted((o1,o2) -> {
                return o1.getSalary().compareTo(o2.getSalary());
        }).collect(Collectors.toList());
        sortedEmployees.forEach((e) -> System.out.println(e.getName()));
    }

    private static void average(List<Employee> employees) {
        double ans = employees.stream().collect(Collectors.averagingInt(e -> e.getSalary()));
        System.out.println(ans);
    }

    private static void groupBy(List<Employee> employees) {
        Map<String, List<Employee>> employeesByDepartment = employees.stream().
        collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeesByDepartment.toString());
    }

    private static void groupByAndAvg(List<Employee> employees) {
        Map<String, Double> employeesByDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
        System.out.println(employeesByDepartment.toString());
    }

    private static void groupByAndMaxBySalary(List<Employee> employees) {
        Map<String, Optional<Employee>> employeesByDepartment = employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        employeesByDepartment.forEach( (k,v) -> {System.out.println(k +":"+v.get().getName());});
    }

    private static void map(List<Employee> employees) {
        List<String> result = employees.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(result.toString());
    }

    private static void filter(List<Employee> employees) {
        List<Employee> result = employees.stream().filter(e -> (e.getSalary()>50 && e.getDepartment().equals("D2"))).collect(Collectors.toList());
        System.out.println(result.toString());
    }
}


class Employee {
    String name;
    Integer id;
    Integer salary;
    String department;

    Employee(String name, Integer id, Integer salary, String department) {
        this.name=name;
        this.id=id;
        this.salary=salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
}