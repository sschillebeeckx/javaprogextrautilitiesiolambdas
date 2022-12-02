package be.abis.acca.model;

public class Instructor implements Role {

    @Override
    public String getType() {
        return "instructor";
    }

    @Override
    public void doJob() {
        System.out.println("teaching");
    }


}
