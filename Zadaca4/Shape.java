import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Shape {
    final double PI = Math.atan(1) * 4;
    double Circumference,SurfaceArea;

    protected abstract double calculateSurfaceArea() throws Exception;
    protected abstract double calculateCircumference() throws Exception;
    protected final void check() throws Exception {
        if(SurfaceArea<0){
            throw new Exception("Povrsina je negativna, nesto ste pogrijesili.");
        }
        if(Circumference<0){
            throw new Exception("Obim je negativan, nesto ste pogrijesili.");
        }
    }

}

class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateCircumference() throws Exception {
        Circumference=2 * radius * PI;
        try{
            this.check();
        }
        catch (Exception x){
            throw x;
        }
        return Circumference;
    }

    public double calculateSurfaceArea() throws Exception {
        SurfaceArea=radius * radius * PI;
                try{
                    this.check();
                }
                catch (Exception x){
                    throw x;
                }
        return SurfaceArea;
    }
}

class Rectangle extends Shape {
    private double sideA, sideB;

    public Rectangle() {
    }

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    //there is no need for parameterized constructors with less than two or three parameters for rectangles,
    // triangles because we take the nature and construction of these shapes into consideration
    public double calculateCircumference() throws Exception {
        Circumference=2*(sideB+sideA);

        try{
            this.check();
        }
        catch (Exception x){
            throw x;
        }
        return Circumference;
    }

    public double calculateSurfaceArea() throws Exception {
        SurfaceArea=sideA*sideB;
        try {
            this.check();
        }
        catch (Exception x){
            throw x;
        }
        return SurfaceArea;
    }
}


class Triangle extends Shape {
    private double sideA, sideB, sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double calculateCircumference() throws Exception {
        Circumference=sideA+sideB+sideC;
        try {
            this.check();
        }
        catch (Exception x){
            throw x;
        }
        return Circumference;
    }

    public double calculateSurfaceArea() throws Exception {
        double parameter = sideA + sideB + sideC; //Heron's formula
        SurfaceArea = Math.sqrt(parameter * (parameter - sideA) * (parameter - sideB) * (parameter - sideC));
        try {
            this.check();
        }
        catch (Exception x){
            throw x;
        }
        return SurfaceArea;
    }

}

class Menu {
    static void generate(int noOfShapes, ArrayList<Shape> newShapes){
        for(int i=0;i<noOfShapes;i++){
            try{
            System.out.format("Povrsina i obim %d Shape-a je, P=%f O=%f\n",i+1,newShapes.get(i).calculateSurfaceArea(),
                    newShapes.get(i).calculateCircumference());
            }
            catch (Exception e){
                System.out.println(e);
                continue;
            }
        }
    }

static void subMenu(int option) {
    if (option == 1) {
        System.out.println("Koji objekat zelite kreirati?\nPritisnite 1 za krug, 2 za pravougaonik, 3 za trougao, " +
                "4 za proracun povrsine i obima, 0 za zavrsetak programa.\n");
    }
        else if (option == 0) {
        System.out.println("Vidimo se!");
    } else {
        System.out.println("Koliki broj zelite kreirati(unesite cijeli broj): ");
    }

}
static int create(){
    Scanner obj = new Scanner(System.in);
    int noOfShapes=obj.nextInt();
    return noOfShapes;
}
    public static void mainMenu() {
        int option = 1;
        subMenu(option);
        int noOfCircles=0,noOfRectangles=0,noOfTriangles=0;
        while (option != 0) {
            Scanner obj = new Scanner(System.in);
            option=obj.nextInt();
            switch (option) {
                case 1: {
                    subMenu(7);
                    noOfCircles = create();
                    break;
                }
                case 2: {
                    subMenu(7);
                    noOfRectangles = create();
                    break;
                }
                case 3: {
                    subMenu(7);
                    noOfTriangles = create();
                    break;
                }
                case 4: {
                    try {
                        if ((noOfCircles == 0 || noOfRectangles == 0 || noOfCircles == 0)) { //creation of at least one different
                            // child instance is forced because we want to show the abstraction concept in action
                            throw new RuntimeException("Niste kreirali objekte.");
                        }
                        ArrayList<Shape> newShapes = new ArrayList<>(); //heterogenous list declared and initialized
                        // so I can create child class object
                        //I will also implement a procedure for adding objects with different class arguments here
                        //generate(noOfCircles,newShapes);
                        //generate(noOfRectangles,newShapes);
                        //generate(noOfTriangles,newShapes);
                    } catch (Exception t) {
                        throw t;
                    }
                    break;
                }
                default: {
                    System.exit(0);
                }
            }
            subMenu(1);

        }
    }

    public static void main(String[] args) {
        try {
            mainMenu();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}