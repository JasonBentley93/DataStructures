package coordinates;

/******************************************************************
 * <p> This class was provided in my Data Structures class in order
 *     to test my own search and sort generic algorithms.
 *     I DID NOT WRITE THE CODE IN THIS CLASS, OR THE JAVADOCS COMMENTS
 * </p>
 ******************************************************************/

public class Rectangle implements Comparable<Rectangle> {
    private double height;
    private double width;

    public Rectangle(int width, int height) {
        this.height = height;
        this.width  = width;
    }

    public double area() {
        return width * height;
    }

    public static int compareAreas(Rectangle r1, Rectangle r2) {
        return Double.compare(r1.area(), r2.area());
    }

    public static int comparePerimeters(Rectangle r1, Rectangle r2) {
        return Double.compare(r1.perimeter(), r2.perimeter());
    }

    public int compareTo(Rectangle other) {
        if(width != other.width) {
            return Double.compare(width, other.width);
        }else {
            return Double.compare(height, other.height);
        }
    }

    public boolean equals(Object obj) {
        if(obj instanceof Rectangle other)
            return width == other.width && height == other.height;
        return false;
    }

    public double perimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return String.format("[%.2f, %.2f]", width, height);
    }
}
