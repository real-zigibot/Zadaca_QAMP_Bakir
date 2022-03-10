import java.util.*;
public class Calculator {
    private
    double a,b;
    double r;
    double result;
    final double PI=Math.atan(1)*4;

//private Calculator(){}
private Calculator(){a=0;b=0;r=0;result=0;}
private Calculator(double a, double b,double r){
    this.a=a;
    this.b=b;
    this.r=r;
    this.result=0;
}
    private Calculator(double a, double b) {
this(a,b,0);
}
private Calculator(double x){ //overloadamo konstruktore
    this(x,0,0);
}
public void setOperandA(double a){this.a=a;}
    public void setOperandB(double b){this.b=b;}
public void setOperandsAandB(double a, double b){ this.a=a; this.b=b;}
    public double getOperandA(){return a;}
    public double getOperandB(){return b;}
    public void setDiameter(double D){r=D/2;}
    public void setRadius(double R){r=R;}
/*
    public void writeThisOut(){
    System.out.println("Bgm ovo postaje polako jedan fin kalkulatorcic \n"+this.a+" "+this.b);
}*/
public void writeObjectOut(){
    System.out.println("Trenutni prvi operand: "+a+"\nTrenutni drugi operand: "+b+"\nTrenutni poluprecnik za krug: "+r);
}
public static void writeObjectOut(Calculator x){
        System.out.println("Trenutni prvi operand: "+x.a+"\nTrenutni drugi operand: "+x.b+
                "\nTrenutni poluprecnik za krug: " +x.r+"\nRezultat operacije je: "+x.result);
    }

public Calculator Add(double a,double b){
    result=this.a/this.b;
    writeObjectOut(this);                //static ovdje dodan za metode kao proof koncepta
                                            // access modifikatora. Mozemo je koristiti bez instance objekta klase,
                                             //odnosno kao "obicnu" funkciju. Ona se nazalost onda ne moze lancati ali
                                            // joj to nije ni svrha
return this;
}
public Calculator Add(){
    result=this.a/this.b;
    writeObjectOut(this);
    return this;
    }
public Calculator Divide(double a,double b){// uzeo sam double da izbjegnemo potrebu za obilazenjem dijeljenja nulom
    result=a/b;
    writeObjectOut(this);
    return this;
    }
    public Calculator Divide(){
        result=a/b;
        writeObjectOut(this);   //rezultat dodat kao argument klase da mozemo ulancavati operacije,
                                    // a i istovremeno imati sacuvan rez
        return this;
    }
public Calculator Subtract(){
    result=this.a-this.b;
    writeObjectOut(this);
 return this;

}
    public Calculator Subtract(double a,double b) {
        result=a-b;
        return  this;
    }
public Calculator Multiply(){
    result=a*b;
    writeObjectOut(this);
    return this;
}
    public Calculator Multiply(double a,double b){
        result=a*b;
        writeObjectOut(this);
        return this;
    }


public Calculator circleSurfaceArea(){
Scanner someObj=new Scanner(System.in);
System.out.print("Unesi poluprecnik zeljenog kruga: ");
result=r*r*PI;
return this;
}

    public Calculator circleSurfaceArea(double r){
    this.result=r*r*this.PI;
    return this;
    }
    /*public Calculator addNnumbers(){

    return this;
}
public Calculator multiplyNnumbers(){

}
*/
    public static void main(String[] args) {
        Calculator obj=new Calculator(0,4,5);
        obj.setDiameter(10);
        obj.setOperandA(80);
        obj.setOperandB(9);
        obj.setOperandsAandB(90,0);
        obj.Divide();
        obj.Divide(10,5);
        obj.writeObjectOut();
        System.out.println(obj.a+" "+obj.b);
        obj.writeObjectOut();
        obj.circleSurfaceArea().writeObjectOut();
        //System.exit(0);

    }


};


