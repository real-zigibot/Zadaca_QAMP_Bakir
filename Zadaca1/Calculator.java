import java.util.*;

public class Calculator {
    private
    double a, b;
    double r;
    double result;
    ArrayList<Double> numbers; //bas me interesovalo sto ne da, da se primitivni tipovi(double) pobacaju u listu
                                //odgovor me je malo iznervirao XD
    final double PI = Math.atan(1) * 4;

    //private Calculator(){}
    private Calculator() {
        a = 0;
        b = 0;
        r = 0;
        numbers=new ArrayList<Double>();
        result = 0;
    }

    private Calculator(double a, double b, double r) {
        this.a = a;
        this.b = b;
        this.r = r;
        numbers=new ArrayList<Double>();
        this.result = 0;
    }

    private Calculator(double a, double b) {
        this(a, b, 0);
    }

    private Calculator(double x) { //overloadamo konstruktore
        this(x, 0, 0);
    }

    public void setOperandA(double a) {
        this.a = a;
    }

    public void setOperandB(double b) {
        this.b = b;
    }

    public void setOperandsAandB(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public void setRadius(double r) {
        this.r = r;
    }
    public double getRadius() {
        return r;
    }
    public void setArray(ArrayList<Double> array){
        numbers=array;
    }
    public ArrayList<Double> getArray(){
        return numbers;
    }
    public double getOperandA() {
        return a;
    }

    public double getOperandB() {
        return b;
    }

    public void setDiameter(double D) {
        r = D / 2;
    }

    public void writeObjectOut() {
        System.out.println("Trenutni prvi operand: " + a + "\nTrenutni drugi operand: " + b +
                "\nTrenutni poluprecnik za krug: " + r);
    }

    public static void writeObjectOut(Calculator x) {
        System.out.println("Trenutni prvi operand: " + x.a + "\nTrenutni drugi operand: " + x.b +
                "\nTrenutni poluprecnik za krug: " + x.r + "\nRezultat operacije je: " + x.result);
    }

    public Calculator Add(double a, double b) {
        result = this.a / this.b;
        writeObjectOut(this);                //static ovdje dodan za metode kao proof koncepta
        // access modifikatora. Mozemo je koristiti bez instance objekta klase,
        //odnosno kao "obicnu" funkciju. Ona se nazalost onda ne moze lancati ali
        // joj to nije ni svrha
        return this;
    }

    public Calculator Add() {
        result = this.a / this.b;
        writeObjectOut(this);
        return this;
    }

    public Calculator Divide(double a, double b) {// uzeo sam double da izbjegnemo potrebu za
        // obilazenjem dijeljenja nulom
        result = a / b;
        writeObjectOut(this);
        return this;
    }

    public Calculator Divide() {
        result = a / b;
        writeObjectOut(this);   //rezultat dodat kao argument klase da mozemo ulancavati operacije,
        // a i istovremeno imati sacuvan rez
        return this;
    }

    public Calculator Subtract() {
        result = this.a - this.b;
        writeObjectOut(this);
        return this;

    }

    public Calculator Subtract(double a, double b) {
        result = a - b;
        return this;
    }

    public Calculator Multiply() {
        result = a * b;
        writeObjectOut(this);
        return this;
    }

    public Calculator Multiply(double a, double b) {
        result = a * b;
        writeObjectOut(this);
        return this;
    }


    public Calculator circleSurfaceArea() {
        Scanner someObj = new Scanner(System.in);
        writeOutFunction(0,0);
        someObj.nextDouble();
        result = r*r * PI;
        writeObjectOut(this);
        return this;
    }

    public Calculator circleSurfaceArea(double r) {
        this.result = r * r * this.PI;
        return this;
    }
    public Calculator addNnumbers(){
        Scanner someObj = new Scanner(System.in);
       writeOutFunction(1,0);
       double sum=0,size= someObj.nextDouble();
      for(int i=0;i<size;i++) {
          writeOutFunction(90, i);
         // numbers.add(someObj.nextDouble());
          sum+=numbers.get(i);
      }
        writeOutFunction(3,90);
        System.out.println(sum);
    return this;
}
    public Calculator addNnumbers(ArrayList<Double> array){
        double sum=0;
        numbers=array;
        for(int i=0;i<array.size();i++)
            sum+=numbers.get(i);
        writeOutFunction(3,90);
        System.out.println(sum);
        return this;
    }
public Calculator multiplyNnumbers(){
    Scanner someObj = new Scanner(System.in);
  writeOutFunction(2,0);
    double product=1,size= someObj.nextDouble();
    for(int i=0;i<size;i++) {
        writeOutFunction(90, i);
        //numbers.add(someObj.nextDouble());
        product*=numbers.get(i);
    }
    writeOutFunction(4,90);
    System.out.println(product);
    return this;
}
    public Calculator multiplyNnumbers(ArrayList<Double> array){
        double product=1;
        numbers=array;
        for(int i=0;i<array.size()-1;i++)
            product*=numbers.get(i);
        writeOutFunction(4,90);
        System.out.println(product);
        return this;
    }
public static void writeOutFunction(int x, int counter){
        switch(x){
            case 0:
                System.out.print("Unesi poluprecnik zeljenog kruga: ");
                break;
                case 1:
                    System.out.print("Koliko brojeva zelis sabrati: ");
                    break;
                    case 2:
                        System.out.print("Koliko brojeva zelis pomnoziti: ");
                        break;
                        case 3:
                            System.out.print("Rezultat sabiranja je: ");
                            break;
                            case 4:
                                System.out.print("Rezultat mnozenja je: ");
                                break;
                                    default:
                                        System.out.format("Unesi %d. broj: ",counter+1);
                                        break;
        }
}

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        obj.writeObjectOut();
        obj.setDiameter(10);
        obj.setOperandA(80);
        obj.setOperandB(9);
        obj.setOperandsAandB(90, 0);
        obj.Divide();
        obj.Divide(10, 5);
        obj.writeObjectOut();
        System.out.println(obj.a + " " + obj.b);
        obj.writeObjectOut();
        obj.circleSurfaceArea().writeObjectOut();
        ArrayList<Double> numbers = new ArrayList<>(Arrays.asList(1., 2., 3.,
                4., 5., 6., 7., 8.));
        obj.addNnumbers(numbers);
        obj.multiplyNnumbers(numbers);
        //System.exit(0);

    }

};


