package ru.mephi.laba3;

import ru.mephi.hw3.*;

import java.util.ArrayList;
import java.util.function.*;


public class Functions {
    //method for getting name fo employee
    public static void getName(ArrayList<Employee> list) {

        Function<Employee, String> person = emp -> emp.getGivenName() + " " + emp.getSurName();
        Consumer<Employee> name = n -> System.out.println(person.apply(n));

        for (int i = 0; i < list.size(); i++) {
            name.accept(list.get(i));
        }
    }

    //method of checking if person is manager or staff, or executive
    public static void checkRole(ArrayList<Employee> list) {

        Function<Employee, String> name = emp -> emp.getGivenName() + " " + emp.getSurName();

        BiPredicate<Employee, Role> checkRole = (person, role) -> person.getRole() == role;

        Consumer<Employee> checkManagers = n -> System.out.println(name.apply(n) + " MANAGER - " +
                checkRole.test(n, Role.MANAGER));
        Consumer<Employee> checkExecutive = n -> System.out.println(name.apply(n) + " EXECUTIVE - " +
                checkRole.test(n, Role.EXECUTIVE));
        Consumer<Employee> checkStaff = n -> System.out.println(name.apply(n) + " STAFF - " +
                checkRole.test(n, Role.STAFF));


        //print the result with functional interface consumer
        for (int i = 0; i < list.size(); i++) {
            checkManagers.accept(list.get(i));
            checkExecutive.accept(list.get(i));
            checkStaff.accept(list.get(i));

        }
    }

    //method for checking if person work in testing, development, or marketing
    public static void checkDept(ArrayList<Employee> list) {
        Function<Employee, String> name = emp -> emp.getGivenName() + " " + emp.getSurName();

        BiPredicate<Employee, Dept> checkDept = (person, dept) -> person.getDept() == dept;

        Consumer<Employee> checkTesting = n -> System.out.println(name.apply(n) + " TESTING - " +
                checkDept.test(n, Dept.TESTING));
        Consumer<Employee> checkDevelopment = n -> System.out.println(name.apply(n) + " DEVELOPMENT - " +
                checkDept.test(n, Dept.DEVELOPMENT));
        Consumer<Employee> checkMarketing = n -> System.out.println(name.apply(n) + " MARKETING - " +
                checkDept.test(n, Dept.MARKETING));

        //print the result with functional interface consumer
        for (int i = 0; i < list.size(); i++) {
            checkTesting.accept(list.get(i));
            checkDevelopment.accept(list.get(i));
            checkMarketing.accept(list.get(i));
        }

    }

    //method for getting the name of managers and staff
    public static void getPerson(ArrayList<Employee> list) {

        Function<Employee, String> name = emp -> emp.getGivenName() +
                " " + emp.getSurName();
        //supplier interface for manager's names
        Supplier<ArrayList<String>> getNamesManagers = () -> {
            ArrayList<String> names = new ArrayList<>();
            for (Employee person : list) {
                if (person.getRole() == Role.MANAGER) {
                    names.add(name.apply(person));
                }
            }
            return names;
        };
        //supplier interface for staff's names
        Supplier<ArrayList<String>> getNamesStaff = () -> {

            ArrayList<String> names = new ArrayList<>();
            for (Employee person : list) {
                if (person.getRole() == Role.STAFF) {
                    names.add(name.apply(person));
                }
            }
            return names;
        };
        // print the results with help of supplier interface
        System.out.println("=========== " + "NAMES OD MANAGERS" + " ===========");
        System.out.println(getNamesManagers.get());
        System.out.println("=========== " + "NAMES FOR STAFF" + " ===========");
        System.out.println(getNamesStaff.get());

    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        ArrayList<Employee> list = employee.createShortList();
        
        System.out.println("=========== " + "LIST OF EMPLOYEE" + " ===========");
        System.out.println(list);

        System.out.println("=========== " + "NAMES OF EMPLOYERS" + " ===========");
        Functions.getName(list);
        System.out.println("=========== " + "CHECK ROLE" + " ===========");
        Functions.checkRole(list);
        System.out.println("=========== " + "CHECK DEPT" + " ===========");
        Functions.checkDept(list);
        Functions.getPerson(list);
    }

}