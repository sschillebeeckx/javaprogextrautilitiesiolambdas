package be.abis.acca.model;

import be.abis.acca.exception.AgeException;
import be.abis.acca.exception.PersonShouldBeAdultException;
import be.abis.acca.exception.PersonShouldNotBeRetiredException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Person implements Comparable<Person>{

    private static int personCounter;
    private int personNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Company company;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate=birthDate;
        personNumber=++personCounter;
    }

    public Person(String firstName, String lastName, LocalDate birthDate, Company company) {
        this(firstName, lastName, birthDate);
        this.company = company;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String toString(){
        return "Person " + personNumber + ", "+firstName + " " + lastName + ", born on: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(birthDate);
    }

    public void printInfo() throws AgeException {
        String info="Person "+this.personNumber + ": " + this.firstName + " " + this.lastName + " (" + this.calculateAge() + " years old)";
        info+= (company!=null)?" works for " + company.getName() + " in " + company.getAddress().getTown() + ".": " is not employed for the moment.";
        System.out.println(info);
    }

    public int calculateAge() throws PersonShouldBeAdultException,PersonShouldNotBeRetiredException {
        int age=Period.between(birthDate,LocalDate.now()).getYears();
        if (age<18) throw new PersonShouldBeAdultException("You are too young",this);
        if (age>67) throw new PersonShouldNotBeRetiredException("You should be enjoying life",this);
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return this.personNumber-o.personNumber;
    }

    public static class AgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int returnValue = 0;
            try {
                int agePerson1 = o1.calculateAge();
                int agePerson2 = o2.calculateAge();
                returnValue = agePerson1- agePerson2;
            } catch (PersonShouldBeAdultException ex) {
                if(ex.getPerson().equals(o1)) returnValue = -100;
                else returnValue=+100;
            } catch (PersonShouldNotBeRetiredException e) {
                if(e.getPerson().equals(o1)) returnValue = +100;
                else returnValue=-100;
            }
            return returnValue;
        }

    }

    public static class FirstNameComparator implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.firstName.compareTo(o2.firstName);
        }
    }
}
