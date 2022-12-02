package be.abis.acca.model;

public class SalesRepresentative implements Role {

    @Override
    public String getType() {
        return "sales";
    }

    @Override
    public void doJob() {
        System.out.println("selling courses");
    }


}
