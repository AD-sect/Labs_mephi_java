import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        ArrayList<Employee> list = employee.createShortList();
        System.out.println("=========== " + "LIST OF EMPLOYEEE" + " ===========");
        System.out.println(list);
        Accountant.paySalary(employee);
        System.out.println(" ");
        Accountant.payPremium(employee);


    }

}
