package javaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSort {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Rakesh"));
        employees.add(new Employee(2, "Ani"));
        List<Employee> emp2 = employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
        for (Employee employee : emp2) {
            System.out.println(employee.getName());
        }
    }
}

class Employee {
    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}