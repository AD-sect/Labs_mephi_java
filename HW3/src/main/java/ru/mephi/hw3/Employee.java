package ru.mephi.hw3;

import java.util.ArrayList;

public class Employee {

    private String givenName;
    private String surName;
    private int age;
    private Gender gender;
    private Dept dept;
    private Role role;
    private String eMail;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;

    private Employee(){

    }

    @Override
    public String toString() {
        return "ru.mephi.laba3.Employee : " +
                "givenName: " + givenName +
                "  |  surName: " + surName +
                "  |  age: " + age +
                "  |  gender: " + gender +
                "  |  dept: " + dept +
                "  |  role: " + role +
                "  | eMail: " + eMail +
                "  |  phone: " + phone +
                "  |  address: " + address +
                "  |  city: " + city +
                "  |  state: " + state +
                "  |  code: " + code +
                "\n";
    }

    public static ArrayList<Employee> createShortList(){
        ArrayList<Employee> list = new ArrayList();

        list.add(new Builder()
                .setGivenName("Anasyasia")
                .setSurName("Dmitruk")
                .setAge(20)
                .setGender(Gender.FEMALE)
                .setDept(Dept.DEVELOPMENT)
                .setRole(Role.MANAGER)
                .seteMail("anandmitruk@ya.ru")
                .setPhone("88005553535")
                .setAddress("Mosckw")
                .setCity("Moscow")
                .setState("CA")
                .setCode("221")
                .build());

        list.add(new Builder()
                .setGivenName("Sergey")
                .setSurName("Rinakov")
                .setAge(47)
                .setGender(Gender.MALE)
                .setDept(Dept.MARKETING)
                .setRole(Role.MANAGER)
                .seteMail("rinakow@ya.ru")
                .setPhone("88004895959")
                .setAddress("Mosckw")
                .setCity("Mosckow")
                .setState("CA")
                .setCode("221")
                .build());

        list.add(new Builder()
                .setGivenName("Dmitry")
                .setSurName("Gordeev")
                .setAge(35)
                .setGender(Gender.MALE)
                .setDept(Dept.DEVELOPMENT)
                .setRole(Role.STAFF)
                .seteMail("dmn@ya.ru")
                .setPhone("89184857828")
                .setAddress("Moscow")
                .setCity("Mosckow")
                .setState("CA")
                .setCode("221")
                .build());

        list.add(new Builder()
                .setGivenName("Nikita")
                .setSurName("Fedorov")
                .setAge(40)
                .setGender(Gender.MALE)
                .setDept(Dept.TESTING)
                .setRole(Role.STAFF)
                .seteMail("jekichan@ya.ru")
                .setPhone("89152220202")
                .setAddress("Moscow")
                .setCity("SPB")
                .setState("UA")
                .setCode("222")
                .build());

        list.add(new Builder()
                .setGivenName("Alex")
                .setSurName("Safronov")
                .setAge(18)
                .setGender(Gender.MALE)
                .setDept(Dept.TESTING)
                .setRole(Role.EXECUTIVE)
                .seteMail("alalalal@ya.ru")
                .setPhone("89164650842")
                .setAddress("Moscow")
                .setCity("SPB")
                .setState("UA")
                .setCode("222")
                .build());

        list.add(new Builder()
                .setGivenName("Natasha")
                .setSurName("Ivanova")
                .setAge(45)
                .setGender(Gender.FEMALE)
                .setDept(Dept.TESTING)
                .setRole(Role.EXECUTIVE)
                .seteMail("nata777@ya.ru")
                .setPhone("89268889877")
                .setAddress("Moscow")
                .setCity("SPB")
                .setState("UA")
                .setCode("222")
                .build());

        list.add(new Builder()
                .setGivenName("Viktorya")
                .setSurName("Ivanova")
                .setAge(19)
                .setGender(Gender.FEMALE)
                .setDept(Dept.TESTING)
                .setRole(Role.MANAGER)
                .seteMail("vvviii@ya.ru")
                .setPhone("89250010302")
                .setAddress("Moscow")
                .setCity("SPB")
                .setState("UA")
                .setCode("222")
                .build());

        list.add(new Builder()
                .setGivenName("Vera")
                .setSurName("Klimova")
                .setAge(31)
                .setGender(Gender.FEMALE)
                .setDept(Dept.MARKETING)
                .setRole(Role.MANAGER)
                .seteMail("kukurusa@ya.ru")
                .setPhone("89273450707")
                .setAddress("Moscow")
                .setCity("SPB")
                .setState("UA")
                .setCode("222")
                .build());

        return list;

    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Dept getDept() {
        return dept;
    }

    public Role getRole() {
        return role;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCode() {
        return code;
    }

    public static class Builder{

        private String givenName;
        private String surName;
        private int age;
        private Gender gender;
        private Dept dept;
        private Role role;
        private String eMail;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String code;

        public Builder setGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setDept(Dept dept) {
            this.dept = dept;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Builder seteMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Employee build(){
            Employee employee = new Employee();

            employee.address = this.address;
            employee.age = this.age;
            employee.dept = this.dept;
            employee.gender = this.gender;
            employee.role = this.role;
            employee.city = this.code;
            employee.code = this.code;
            employee.givenName = this.givenName;
            employee.surName = this.surName;
            employee.eMail = this.eMail;
            employee.phone = this.phone;
            employee.state = this.state;
            return employee;
        }
    }


}
