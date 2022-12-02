package be.abis.shapes.model;

public class Rectangle extends Polygon {

	private double width;
	
	public Rectangle(Color color, Point origin, double height, double width) {
		super(color, origin,height);
		this.width = width;
		this.setNrOfCorners(4);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double area() {
		double area = getHeight()*width;
		return area;
	}

	@Override
	public String getDimensionSentence() {
		return "height= " + getHeight() + ", width= " +width;
	}

	@Override
	public void doubleAreaKeepAspectRatio() {
		this.setHeight(Math.sqrt(2)*getHeight());
		this.width=Math.sqrt(2)*width;
	}

}
