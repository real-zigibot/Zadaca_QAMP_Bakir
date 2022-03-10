import java.util.*;
public class Calculator {
    private
    double a,b;
    final double PI=Math.atan(1)*4;

//private Calculator(){}
private Calculator(){
    a=0;
    b=0;
}
private Calculator(double a, double b){
    this.a=a;
    this.b=b;
}
private Calculator(double x){
    this(x,0);
}
public void setOperandA(double a){this.a=a;}
    public void setOperandB(double b){this.b=b;}
public void setOperandsAandB(double a, double b){ this.a=a; this.b=b;}
    public double getOperandA(){return a;}
    public double getOperandB(){return b;}
public void writeThisOut(){
    System.out.println("Bgm ovo postaje polako jedan fin kalkulatorcic \n"+this.a+" "+this.b);
}
public double Add(double a, double b){
return this.a+this.b;
}
public double Divide(double a,double b){// uzeo sam double da izbjegnemo potrebu za obilazenjem dijeljenja s nulom
        return this.a/this.b;
    }
public double Subtract(double a,double b){
 return this.a-this.b;
}
    public static void main(String[] args) {
    Calculator obj=new Calculator(0,4);
    System.out.println(obj.a+" "+obj.b);

    obj.writeThisOut();
    //System.exit(0);

    }




}
