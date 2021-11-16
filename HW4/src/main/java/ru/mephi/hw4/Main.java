package ru.mephi.hw4;

import ru.mephi.hw3.Employee;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = Employee.createShortList();
        System.out.println("============ List : ============");
        System.out.println(list);
        ExampleStreams.increaseSalaryWoman(list, 0.5);
        ExampleStreams.changePhoneNumber(list);
        ExampleStreams.setUpperCaseAddress(list);
        ExampleStreams.getNames(list);
        ExampleStreams.getMaxAge(list);
        ExampleStreams.getMixAge(list);
        ExampleStreams.getMaxSalary(list);
        ExampleStreams.getMinSalary(list);
        ExampleStreams.averageSalary(list);
        ExampleStreams.averageSalaryWoman(list);
        ExampleStreams.sumSalary(list);
        ExampleStreams.sumSalaryRole(list);
        ExampleStreams.getEmployee(list, 5);

    }
}
