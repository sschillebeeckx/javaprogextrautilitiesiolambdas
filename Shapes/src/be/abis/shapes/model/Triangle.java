package be.abis.shapes.model;

public class Triangle extends Polygon {

	private double base;

	public Triangle(Color color, Point origin, double height, double base) {
		super(color, origin,height);
		this.base = base;
		this.setNrOfCorners(3);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Override
	public double area() {
		double area = (getHeight()*base)/2;
		return area;
	}

	@Override
	public String getDimensionSentence() {
		return "height= " + getHeight() + ", base= " +base;
	}

	@Override
	public void doubleAreaKeepAspectRatio() {

	}

}
