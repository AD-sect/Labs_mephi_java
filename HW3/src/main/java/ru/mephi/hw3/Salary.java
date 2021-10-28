package ru.mephi.hw3;

import java.util.HashMap;
import java.util.*;


public class Salary {


  Map<Role, Integer> marketing;
  Map<Role, Integer> development;
  Map<Role, Integer>  testing;


  Salary(){

      marketing = new HashMap<>();
      marketing.put(Role.MANAGER, 100);
      marketing.put(Role.STAFF, 200);
      marketing.put(Role.EXECUTIVE, 300);

      development= new HashMap<>();
      development.put(Role.MANAGER, 150);
      development.put(Role.STAFF, 250);
      development.put(Role.EXECUTIVE, 350);

     testing= new HashMap<>();
     testing.put(Role.MANAGER, 170);
     testing.put(Role.STAFF, 270);
     testing.put(Role.EXECUTIVE, 370);
  }

    public Map<Role, Integer> getMarketing() {
        return marketing;
    }

    public Map<Role, Integer> getDevelopment() {
        return development;
    }

    public Map<Role, Integer> getTesting() {
        return testing;
    }

    public Map<Role, Integer> getDeptSalary(Dept dept){
       if (dept.equals(Dept.DEVELOPMENT)){
           return development;
       } else
       if (dept.equals(Dept.MARKETING)){
           return marketing;
       } else{
           return testing;
       }
    }

    public int getSalary( Dept dept, Role role ){
      return getDeptSalary(dept).get(role);
    }
}
