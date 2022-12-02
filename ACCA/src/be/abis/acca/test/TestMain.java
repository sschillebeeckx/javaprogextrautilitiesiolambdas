package be.abis.acca.test;

import be.abis.acca.exception.AgeException;
import be.abis.acca.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

public class TestMain {

    public static void main(String[] args) {
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
        Company c = new Company("Abis",a);
        Person p1 = new Person("Ann","Smits", LocalDate.of(1986,12,21),c);
        Person p2 = new Person("Yvette","Van den Acker",LocalDate.of(1952,05,8));
        Person p3 = new Person("John","Doe",LocalDate.of(2005,1,15));

        System.out.println("----------------------Persons With Exceptions -----------------------------------");
        Person[] persons = {p1,p2,p3};
        for (Person p:persons){
            try {
                System.out.println(p.getFirstName() + " is " + p.calculateAge() + " years old.");
            } catch (AgeException e) {
                System.out.println(p.getFirstName() + ": " +e.getMessage());
            }
        }

        System.out.println("\n----------------------Courses-----------------------------------");
        Course co1 = new Course("Java",5,500,true);
        Course co2 = new Course("SQL",2,375,false);
        Course co3 = new Course("TDD",3,600,false);
        Course co4 = new Course("XML",1,387,false);
        Course[] courses = {co1,co2,co3,co4};

        for(Course co:courses){
            co.printInfo();
        }

        System.out.println("\n----------------------Abis Employees-----------------------------------");
        AbisEmployee ae1 = new AbisEmployee("Koen","De Backer",LocalDate.of(1958,8,16),5123.65,new Address("Some street","4","Kessel-Lo","BE"));
        try {
            ae1.printInfo();


        System.out.println("\n----------------------Net salary-----------------------------------");
        System.out.println("Current net salary of "+ ae1.getFirstName() + " is " + ae1.calculateNetSalary());

        System.out.println("\n----------------------Salary history-----------------------------------");
        AbisEmployee ae2 = new AbisEmployee("Peter","Vanroose",LocalDate.of(1962,3,27),23,2700.,4600.,new Address("Some street","4","Kessel-Lo","BE"));
        ae2.printSalaryHistory();

        System.out.println("\n----------------------Roles-----------------------------------");
        AbisEmployee ae3 = new AbisEmployee("Yvette","Van den Acker",LocalDate.of(1952,05,8),4600.,new Address("Some street","4","Haacht","BE"));
        AbisEmployee ae4 = new AbisEmployee("Arnout","Veugelen",LocalDate.of(1985,11,21),4600.,new Address("Some street","4","Kessel-Lo","BE"));
        ae1.addRole(new Instructor());
        ae2.addRole(new Instructor());
        ae3.addRole(new Accountant());
        ae4.addRole(new Instructor());
        ae4.addRole(new Manager());
        ae4.addRole(new SalesRepresentative());

        System.out.println("\n----------------------Performing role-----------------------------------");
        ae1.findRole("instructor").doJob();

        System.out.println("\n----------------------Adding intructors to course-----------------------------------");

        co1.addInstructor(ae1);
        co2.addInstructor(ae2);
        co2.addInstructor(ae3);
        co2.addInstructor(ae4);

        Course[] courses2 = {co1,co2};
        for(Course co:courses2){
            co.printInfo();
        }

        System.out.println("\n----------------------Sorting persons-----------------------------------");
        Person[] personsToSort = {p1,p3,ae1,ae2,ae3,ae4};

        System.out.println("----------------------By personNumber:-----------------------------------");
        Collections.sort(Arrays.asList(personsToSort));
        for (Person p : personsToSort){
            System.out.println(p);
        }

        System.out.println("----------------------By age:-----------------------------------");
        Collections.sort(Arrays.asList(personsToSort),new Person.AgeComparator());
        for (Person p : personsToSort){
            System.out.println(p);
        }

        System.out.println("----------------------By first name:-----------------------------------");
        Collections.sort(Arrays.asList(personsToSort),new Person.FirstNameComparator());
        for (Person p : personsToSort){
            System.out.println(p);
        }

        } catch (AgeException e) {
            //throw new RuntimeException(e);
        }


    }
}
