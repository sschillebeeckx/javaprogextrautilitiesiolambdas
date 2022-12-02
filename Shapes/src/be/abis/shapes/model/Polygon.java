package be.abis.shapes.model;

public abstract class Polygon extends Shape {

    private int nrOfCorners;
    private double height;

    public Polygon(Color color, Point origin, double height) {
        super(color, origin);
        this.height=height;
    }

    public int getNrOfCorners() {
        return nrOfCorners;
    }

    public void setNrOfCorners(int nrOfCorners) {
        this.nrOfCorners = nrOfCorners;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
