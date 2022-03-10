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
public void writeObjectOut(boolean x){
        System.out.println("Trenutni prvi operand: "+a+"\nTrenutni drugi operand: "+b+"\nTrenutni poluprecnik za krug: "+r+"\nRezultat operacije je: "+result);
    }

public double Add(double a,double b){
    result=this.a/this.b;
    this.writeObjectOut(true);
return result;
}
public double Add(){
    result=this.a/this.b;
    this.writeObjectOut(true);
    return result;
    }
public double Divide(double a,double b){// uzeo sam double da izbjegnemo potrebu za obilazenjem dijeljenja nulom
    result=this.a/this.b;
    this.writeObjectOut(true);
    return result;
    }
    public double Divide(){
        result=this.a/this.b;
        this.writeObjectOut(true);   //rezultat dodat kao argument sklase da mozemo ulancavati operacije
        return result;
    }
public double Subtract(double a,double b){
    result=this.a-this.b;
    this.writeObjectOut(true);
 return result;
}


    public static void main(String[] args) {
    Calculator obj=new Calculator(0,4,5);
    obj.setDiameter(10);
    obj.setOperandA(80);
    obj.setOperandB(9);
    obj.setOperandsAandB(90,0);
    obj.Divide();
    obj.Divide(10,5);
    System.out.println(obj.a+" "+obj.b+"");
    obj.writeObjectOut();
    //System.exit(0);

    }
}
