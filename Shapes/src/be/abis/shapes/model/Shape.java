package be.abis.shapes.model;

import be.abis.shapes.exception.AreaTooBigException;

public abstract class Shape implements Comparable<Shape>{
    
	 private Color color;
	 private Point origin;


	 public Shape(Color color, Point origin) {
		this.color = color;
		this.origin = origin;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public abstract double area();

	public String toString(){
		String sentence =  "This is a " + this.color + " " + this.getClass().getSimpleName().toLowerCase() + ". ";
		sentence+="Dimensions: " + this.getDimensionSentence() + ".";
		sentence+=" The area is " + this.area() +".";
		return sentence;
	}

	 public String baseToString(){
		 return this.color.toString().toLowerCase() + " " + this.getClass().getSimpleName().toLowerCase();
	 }

	 public abstract String getDimensionSentence();

	 public String compareArea(Shape other){
		 String retval = "";
		 double area1 = this.area();
		 double area2=other.area();
		 if (area1==area2){
			 retval="EQUAL";
		 } else if (area1<area2){
			 retval="SMALLER";
		 } else {
			 retval="TALLER";
		 }
		 return "The " + this.baseToString() + " has an area which is " + retval + " than of the " + other.baseToString() + ".";
	 }

      public abstract void doubleAreaKeepAspectRatio();


	 public int compareTo(Shape o){
		 return (int)((this.area()-o.area())*1000);
	 }
}
