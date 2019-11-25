package com.javadroider.interviewprep.designpatterns.structural.composite;

public class CompositePatternTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("David", "Programmer", 1500);
        Employee employee2 = new Employee("Scott", "CEO", 3000);
        Employee employee3 = new Employee("Andrew", "Manager", 2000);
        Employee employee4 = new Employee("Scott", "Janitor", 500);
        Employee employee5 = new Employee("Juliette", "Marketing", 1000);
        Employee employee6 = new Employee("Rebecca", "Sales", 2000);
        Employee employee7 = new Employee("Chris", "Programmer", 1750);
        Employee employee8 = new Employee("Ivan", "Programmer", 1200);

        employee3.addCoworker(employee1);
        employee3.addCoworker(employee7);
        employee3.addCoworker(employee8);

        employee1.addCoworker(employee7);
        employee1.addCoworker(employee8);

        employee2.addCoworker(employee3);
        employee2.addCoworker(employee5);
        employee2.addCoworker(employee6);

        System.out.println(employee2);
        for (Employee headEmployee : employee2.getCoworkers()) {
            System.out.println(headEmployee);

            for(Employee employee : headEmployee.getCoworkers()) {
                System.out.println(employee);
            }
        }
    }
}