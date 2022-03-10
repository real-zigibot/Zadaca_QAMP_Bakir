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
public void writeThisOut(){
    System.out.println("Bgm ovo postaje polako jedan fin kalkulatorcic"+this.a+" "+this.b);

}
public double Add(double a, double b){

}
public  double

    public static void main(String[] args) {
    Calculator obj=new Calculator(0,4);
    System.out.println(obj.a+" "+obj.b);
    //System.exit(0);

    }




}
