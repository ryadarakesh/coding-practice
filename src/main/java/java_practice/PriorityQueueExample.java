package java_practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Employee> empQueue = new PriorityQueue<>(Comparator.comparing(Employee::getId).reversed());
        System.out.println("In Employeer Id revesre priority");
        empQueue.add(new Employee(1, "Rakesh"));
        empQueue.add(new Employee(4, "Agastya"));
        empQueue.add(new Employee(3, "Anitha"));
        empQueue.add(new Employee(2, "Tapasvi"));
        while (!empQueue.isEmpty()) {
            Employee e = empQueue.remove();
            System.out.println(e.id+" - "+e.name);
        }
        System.out.println("In Employee name order ");
        empQueue = new PriorityQueue<>(Comparator.comparing(Employee::getName));
        empQueue.add(new Employee(1, "Rakesh"));
        empQueue.add(new Employee(4, "Agastya"));
        empQueue.add(new Employee(3, "Anitha"));
        empQueue.add(new Employee(2, "Tapasvi"));
        while (!empQueue.isEmpty()) {
            Employee e = empQueue.remove();
            System.out.println(e.id+" - "+e.name);
        }
    }

    static class Employee{
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

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
}
