package ru.mephi.hw3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = Employee.createShortList();
        System.out.println("=========== " + "LIST OF EMPLOYEEE" + " ===========");
        System.out.println(list);
        Accountant.paySalary(list);
        System.out.println(" ");
        Accountant.payPremium(list);


    }

}
