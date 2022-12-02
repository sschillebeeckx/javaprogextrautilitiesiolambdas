package be.abis.shapes.test;

import be.abis.shapes.exception.AreaTooBigException;
import be.abis.shapes.model.*;
import be.abis.shapes.util.AreaTester;

import java.util.ArrayList;
import java.util.List;


public class Client {

	public static void main(String[] args)  {

		Point p = new Point();
		
		List<Shape> shapeList = new ArrayList<>();
		
		shapeList.add(new Circle(Color.RED,p,2));
		shapeList.add(new Rectangle(Color.BLUE,new Point(),10,2));
		shapeList.add(new Square(Color.YELLOW,new Point(),5.6));
		shapeList.add(new Triangle(Color.ORANGE,new Point(),5,8));
		shapeList.add(new Trapezoid(Color.BLUE,new Point(),5,8, 3));
		shapeList.add(new Circle(Color.BLACK,new Point(),10));
		shapeList.add(new Triangle(Color.YELLOW,new Point(),0.5,0.8));

		System.out.println("\n----------------AREATESTER----------------------");

	    for (Shape s : shapeList){
			try {
				String result = AreaTester.checkArea(s);
				System.out.println(result);
			} catch (AreaTooBigException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("\nSmall shapes removed:");
		shapeList.removeIf(s -> AreaTester.isSmallShape(s));
        shapeList.forEach(System.out::println);


	}

}
