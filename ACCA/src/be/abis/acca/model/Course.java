package be.abis.acca.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Course {

    private String title;
    private int numberOfDays;
    private double pricePerDay;
    private boolean priorKnowledgeRequired;

    private int instructorCounter;
    private List<AbisEmployee> instructors = new ArrayList<AbisEmployee>();

    public Course(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
        this.priorKnowledgeRequired = priorKnowledgeRequired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isPriorKnowledgeRequired() {
        return priorKnowledgeRequired;
    }

    public void setPriorKnowledgeRequired(boolean priorKnowledgeRequired) {
        this.priorKnowledgeRequired = priorKnowledgeRequired;
    }

    public List<AbisEmployee> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<AbisEmployee> instructors) {
        this.instructors = instructors;
    }



    public double calculateTotalPrice(){
        double total=numberOfDays*pricePerDay;
        if (numberOfDays<3 && !priorKnowledgeRequired)total*=1.21;
        return total;
    }

    public String labelCoursePrice(){
        String label = "";
        double price = this.calculateTotalPrice();
        if (price<500){
            label="CHEAP";
        } else if (price<1500){
            label="OK";
        } else {
            label="EXPENSIVE";
        }
        return label;
    }

    public void printInfo(){
        double totalPrice = this.calculateTotalPrice();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl","NL"));
        nf.setGroupingUsed(false);
        String label = this.labelCoursePrice();
        System.out.println("The " + this.title + " takes "+ this.numberOfDays + ". Prior knowledge is" + ((priorKnowledgeRequired)?" ":" not ") + "required. The total price is " + nf.format(totalPrice).replaceAll("\\p{Z}","") + ". This is " + label.toLowerCase() + ".");
        System.out.println("Instructors are: " );
        for (AbisEmployee ae : this.getInstructors()){
            System.out.println(ae.getFirstName() + " " + ae.getLastName());
        }
    }

    public void addInstructor(AbisEmployee ae){
        if (ae.hasRole("instructor")){
            instructors.add(ae);
        } else {
            System.out.println(ae.getFirstName() + " is not an instructor.");
        }
    }
}
