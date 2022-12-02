package be.abis.shapes.util;

import be.abis.shapes.exception.AreaTooBigException;
import be.abis.shapes.model.Shape;

import java.util.function.Predicate;

public class AreaTester {

    public static String checkArea(Shape s) throws AreaTooBigException {
        double area = s.area();
        if (area > 100) throw new AreaTooBigException("Area " + area + " of " + s.baseToString() + " is too big.");
        return "Area " + area + " of " + s.baseToString() + " is ok.";
    }

    public static boolean isSmallShape(Shape s){
        Predicate<Shape> checker =  sh -> sh.area()<1;
        return checker.test(s);
    }
}
