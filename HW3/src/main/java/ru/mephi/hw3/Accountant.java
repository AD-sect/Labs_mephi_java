package ru.mephi.hw3;

import java.util.ArrayList;

public class Accountant {

    Accountant(){
    }

    public static void paySalary(Employee employee) {

        ArrayList<Employee> list = employee.createShortList();
        Salary salary = new Salary();


        //salary for managers
        System.out.println("=========== " + "SALARY FOR MANAGERS" + " ===========");
        list.stream()
                .filter(e -> e.getRole() == Role.MANAGER)
                .forEach(e -> System.out.println(
                      e.getGivenName() + "  "
                    + e.getSurName()
                    + ": " + e.getRole()
                    + " -- " + salary.getSalary(e.getDept(), Role.MANAGER)));

        System.out.println(" ");


        //salary for different dept
        for (Dept dept : Dept.values()) {
            System.out.println("=========== " + "SALARY FOR " + dept + " ===========");
            list.stream()
                    .filter(e -> e.getDept() == dept)
                    .forEach(e -> System.out.println(
                          e.getGivenName() + "  "
                        + e.getSurName()
                        + ":" + e.getDept()
                        + " -- " + salary.getSalary(dept, e.getRole())));
            System.out.println(" ");

        }
    }

    public static void payPremium(Employee employee) {

        ArrayList<Employee> list = employee.createShortList();
        Salary salary = new Salary();

        //premium for woman
        System.out.println("=========== " + "PREMIUM FOR WOMAN" + " ===========");
        list.stream()
                .filter(e -> e.getGender() == Gender.FEMALE)
                .forEach(e -> System.out.println(
                      e.getGivenName() + " -- "
                    + e.getSurName()
                    + ": " + e.getGender()
                    + " -- " + (salary.getSalary(e.getDept(), e.getRole()))
                    * (1 + e.getRole().getRate())));

        System.out.println(" ");
        //premium for >30 and from different departments
        for (Dept dept : Dept.values()) {
            System.out.println("=========== " + "PREMIUM FOR 30 Y.O. IN " + dept + " ===========");

            list.stream()
                    .filter(e -> e.getAge() > 30 && e.getDept() == dept)
                    .forEach(e -> System.out.println("Premium -- "
                            + e.getGivenName() + " -- "
                            + e.getSurName()
                            + " -- " + e.getAge()
                            + " -- " + e.getDept()
                            + " -- " + (salary.getSalary(e.getDept(), e.getRole())
                            * (1 + e.getRole().getRate()))));
            System.out.println(" ");
        }

        //premium for staff
        System.out.println("=========== " + "PREMIUM FOR STAFF" + " ===========");
        list.stream()
                .filter(e -> e.getRole() == Role.STAFF)
                .forEach(e -> System.out.println(
                          e.getGivenName() + "  "
                        + e.getSurName()
                        + ": " + e.getRole()
                        + " -- " + ((salary.getSalary(e.getDept(), Role.MANAGER))
                        * (1 + e.getRole().getRate()))));
        System.out.println(" ");

    }
}




