package be.abis.shapes.model;

public class Trapezoid extends Polygon {

    private double base1;
    private double base2;

    public Trapezoid(Color color, Point origin, double base1, double base2, double height) {
        super(color, origin,height);
        this.base1 = base1;
        this.base2 = base2;
        this.setNrOfCorners(4);
    }

    public double getBase1() {
        return base1;
    }

    public void setBase1(double base1) {
        this.base1 = base1;
    }

    public double getBase2() {
        return base2;
    }

    public void setBase2(double base2) {
        this.base2 = base2;
    }


    @Override
    public double area() {
        return (base1+base2)*getHeight()/2;
    }

    @Override
    public String getDimensionSentence() {
        return "base1= " + base1 + ", base2= " + base2 + ", height= " + getHeight();
    }

    @Override
    public void doubleAreaKeepAspectRatio() {

    }
}
