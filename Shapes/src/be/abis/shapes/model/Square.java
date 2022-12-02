package be.abis.shapes.model;

public class Square extends Polygon {

    public Square(Color color, Point origin, double height) {
        super(color, origin, height);
        this.setNrOfCorners(4);
    }


    @Override
    public double area() {
        return Math.pow(getHeight(),2);
    }

    @Override
    public String getDimensionSentence() {
        return "height= " + getHeight();
    }

    @Override
    public void doubleAreaKeepAspectRatio() {
        this.setHeight(Math.sqrt(2)*getHeight());
    }
}
