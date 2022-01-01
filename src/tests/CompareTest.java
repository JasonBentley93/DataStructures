package tests;

import coordinates.Point;
import coordinates.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static searchAndSort.Generic.binarySearch;
import static searchAndSort.Generic.quickSort;

public class CompareTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t C O M P A R E   O B J E C T S  ");
        System.out.println(" \t \t    T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void comparePoints(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        List<Point> list = new ArrayList<Point>();
        list.add(new Point(6, 5));
        list.add(new Point(8, 6));
        list.add(new Point(3, 7));
        list.add(new Point(7, 9));
        list.add(new Point(2, 5));
        list.add(new Point(5, 4));
        list.add(new Point(5, 6));
        list.add(new Point(1, 8));
        list.add(new Point(7, 5));
        list.add(new Point(4, 8));

        System.out.println("------- dimensions: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }
        System.out.println();

        System.out.println("------- dimensions: natural ordering --------");
        quickSort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }

    }
    public static void compareRectangles(){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        List<Rectangle> list = new ArrayList<Rectangle>();
        list.add(new Rectangle(7, 9));
        list.add(new Rectangle(5, 4));
        list.add(new Rectangle(8, 6));
        list.add(new Rectangle(3, 7));
        list.add(new Rectangle(1, 8));
        list.add(new Rectangle(6, 5));
        list.add(new Rectangle(4, 8));
        list.add(new Rectangle(7, 5));
        list.add(new Rectangle(2, 5));
        list.add(new Rectangle(5, 9));

        System.out.println("------- dimensions: before sorting --------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + ": " + list.get(i));
        }

        System.out.println();
        System.out.println("------- dimensions: natural ordering --------");
        quickSort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }

        System.out.println();
        System.out.println("------- areas: different ordering --------");
        quickSort(list, Rectangle::compareAreas);

        for (Rectangle rectangle : list) {
            System.out.println(rectangle + ": " + rectangle.area());
        }

        System.out.println();
        System.out.println("------- perimeters: different ordering --------");
        quickSort(list, Rectangle::comparePerimeters);

        for (Rectangle rectangle : list) {
            System.out.println(rectangle + ": " + rectangle.perimeter());
        }
    }

    public static void searchPoints(){
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        List<Point> list = new ArrayList<Point>();
        list.add(new Point(6, 5));
        list.add(new Point(8, 6));
        list.add(new Point(3, 7));
        list.add(new Point(7, 9));
        list.add(new Point(2, 5));
        list.add(new Point(5, 4));
        list.add(new Point(5, 6));
        list.add(new Point(1, 8));
        list.add(new Point(7, 5));
        list.add(new Point(4, 8));

        quickSort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println("element " + i + " : " + list.get(i));
        }

        System.out.println("Let's find your point!!!");
        System.out.print("To find the index of one of the above points, enter its x coordinate: ");
        int x = input.nextInt();

        System.out.print("Now enter its y coordinate: ");
        int y = input.nextInt();

        Point p = new Point (x,y);

        if (binarySearch(list,p) == -1){
            System.out.println("sorry, that point doesnt exist...");
        } else {
            System.out.println("Your point is located at index: " + binarySearch(list, p));
        }
    }

    
    public static void main(String[] args) {
        intro();
        comparePoints();
        compareRectangles();
        searchPoints();
    }
}
