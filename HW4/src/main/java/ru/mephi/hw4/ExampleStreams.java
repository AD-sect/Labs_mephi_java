package ru.mephi.hw4;

import ru.mephi.hw3.Dept;
import ru.mephi.hw3.Employee;
import ru.mephi.hw3.Gender;
import ru.mephi.hw3.Role;

import java.util.List;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.Comparator;

/*
На основании прошлой лабораторной работы добавить Employee поле salary (зарплата) и
 cоздать по 2 примера использования следующих методов стримов:
    +1. map и peek
    2. findFirst и lazy операции
    +3. max, min
    +4. average, sum
 */
public class ExampleStreams {

    //increase salary for woman with map
    public static void increaseSalaryWoman(ArrayList<Employee> list, double percent ){

        System.out.println("============ New salary for women (higher in " + percent + " %) ============");
        list.stream().filter(e -> e.getGender() == Gender.FEMALE)
                .map(e ->{
                    e.setSalary(e.getSalary() * (1 + percent));
                    return e;}
                )
                .forEach(e -> System.out.println(
                        e.getGivenName() +
                                " " + e.getSurName() +
                                " " + e.getSalary()));
    }
    // add something to the phone number with map
    public static void changePhoneNumber(ArrayList<Employee> list ) {

        System.out.println("============ New phone numbers : ============");
        list.stream().map(e -> {
                            e.setPhone(" +" + e.getPhone());
                            return e;
                        })
                .forEach(e -> System.out.println(
                        e.getGivenName() +
                                " " + e.getSurName() +
                                " " + e.getPhone()));
    }
    //make address in upper case with peek
    public static void setUpperCaseAddress(ArrayList<Employee> list){

        System.out.println("============ Upper Case addresses : ============");
        list.stream().peek(e ->e.setAddress(e.getAddress().toUpperCase()))
                .forEach(e -> System.out.println(
                        e.getGivenName() +
                                " " + e.getSurName() +
                                " " + e.getAddress()));
    }

    //get the list of employes's names with peek
    public static List<String> getNames(ArrayList<Employee> list){
        System.out.println("============ Names of employees : ============");
        List<String> listNames = list.stream().map(e -> {return e.getGivenName() + " "+ e.getSurName();})
               .peek(e -> System.out.println(e))
               .collect(Collectors.toList());
        return listNames;
    }

    //get  max salary with max
    public static void getMaxSalary(ArrayList<Employee> list){
        System.out.println("============ Max salary : ============");
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o1.getSalary()).compareTo(new Double(o2.getSalary()));
            }
        };

        Employee maxSalary = list.stream().max(comparator).get();
        System.out.println(maxSalary.getGivenName() +" "
                            + maxSalary.getSurName() +" "
                            + maxSalary.getSalary());
    }

    // get max age with max
    public static void getMaxAge(ArrayList<Employee> list){
        System.out.println("============ Max age : ============");
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
        };

        Employee maxAge = list.stream().max(comparator).get();
        System.out.println(maxAge.getGivenName() +" "
                + maxAge.getSurName() +" "
                + maxAge.getAge());
    }

    //get min  salary with min
    public static void getMinSalary(ArrayList<Employee> list){
        System.out.println("============ Min salary : ============");
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o1.getSalary()).compareTo(new Double(o2.getSalary()));
            }
        };

        Employee minSalary = list.stream().min(comparator).get();
        System.out.println(minSalary.getGivenName() +" "
                + minSalary.getSurName() +" "
                + minSalary.getSalary());
    }

    //get min age with min
    public static void getMixAge(ArrayList<Employee> list){
        System.out.println("============ Min age : ============");

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
            }
        };

        Employee minAge = list.stream().min(comparator).get();
        System.out.println(minAge.getGivenName() +" "
                + minAge.getSurName() +" "
                + minAge.getAge());
    }

    //get average salary with average
    public static void averageSalary(ArrayList<Employee> list){
        System.out.println("============ Average salary : ============");

        OptionalDouble average = list.stream().mapToDouble(e -> e.getSalary()).average();
        System.out.println("Average salary: " + average.getAsDouble());

    }

    //get average salary for woman with average
    public static void averageSalaryWoman(ArrayList<Employee> list){
        System.out.println("============ Average salary for woman : ============");

        OptionalDouble average = list.stream().filter(e -> e.getGender() == Gender.FEMALE)
                                              .mapToDouble(e -> e.getSalary()).average();
        System.out.println("Average salary: " + average.getAsDouble());
    }

    //get sum salary with sum
    public static void sumSalary(ArrayList<Employee> list){
        System.out.println("============ Sum of salary : ============");
        double sum = list.stream().mapToDouble(e -> e.getSalary()).sum();
        System.out.println("Sum salary: " + sum);

    }

    //get sum salary for all roles with sum
    public static void sumSalaryRole(ArrayList<Employee> list){
        System.out.println("============ Sum salary for different roles : ============");
        for(Role role : Role.values()){
            double sum = list.stream().filter(e -> e.getRole() == role).mapToDouble(e -> e.getSalary()).sum();
            System.out.println("Sum salary for " + role + " : " + sum);
        }
    }

    //get i employee with find first; if employee is not exist return "null" employee
    public static void getEmployee(ArrayList<Employee> list, int i){

        System.out.println("============ Get " + i + " employee : ============");

        Employee emp = new Employee.Builder()
                .setGivenName("null")
                .setSurName("null")
                .setAge(0)
                .setGender(null)
                .setDept(null)
                .setRole(null)
                .seteMail("null")
                .setPhone("null")
                .setAddress("null")
                .setCity("null")
                .setState("null")
                .setCode("null")
                .setSalary(0)
                .build();

        Employee emp1 = list.stream().skip(i - 1).findFirst().orElse(emp);
        System.out.println("Employee №" + i + " : " + emp1)  ;

    }
}
