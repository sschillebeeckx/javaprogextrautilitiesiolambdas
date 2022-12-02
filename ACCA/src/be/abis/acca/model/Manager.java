package be.abis.acca.model;

public class Manager implements Role {

    @Override
    public String getType() {
        return "manager";
    }

    @Override
    public void doJob() {
        System.out.println("delegating things and attending meetings");
    }


}
