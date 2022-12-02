package be.abis.acca.model;

public class Accountant implements Role {

    @Override
    public String getType() {
        return "accountant";
    }

    @Override
    public void doJob() {
        System.out.println("billing and paying salaries");
    }
}
