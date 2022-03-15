
import java.util.*;
import java.lang.Math;

import static java.lang.Math.sqrt;

public class Numbers {
    private ArrayList<Double> umbers;

    private Numbers(ArrayList<Double> l) {
        umbers = l;
    }

    private Numbers() {
        umbers = new ArrayList<Double>();
        Scanner someObj = new Scanner(System.in);
        System.out.println("Koliko brojeva zelis u listi: ");
        int size = someObj.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.format("Unesi %d. broj: ", i + 1);
            umbers.add(someObj.nextDouble());
        }
    }

    public double getElement(int position) {
        if(position>0) {
            if (umbers.size() < position)
                throw new ArrayIndexOutOfBoundsException("Lista nema element na poziciji");
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Index negativan ili 0");
        }
        return umbers.get(position-1);
    }

    public Numbers setElement(int position, double element) {
        if(position>0) {
            if (umbers.size() < position)
                throw new ArrayIndexOutOfBoundsException("Lista nema element na poziciji");
            umbers.set(position - 1, element);
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Index negativan ili 0 ");
        }
        return this;
    }

    public Numbers addNnumbers() {
        double sum = 0;
        for (int i = 0; i < this.umbers.size(); i++) {
            //  writeOutFunction(90, i);
            // numbers.add(someObj.nextDouble());
            sum += umbers.get(i);
        }
        System.out.println(sum);
        return this;
    }

    public Numbers addNnumbers(ArrayList<Double> array) {
        double sum = 0;
        umbers = array;
        for (int i = 0; i < array.size(); i++)
            sum += umbers.get(i);
        //writeOutFunction(3,90);
        System.out.println(sum);
        return this;
    }

    public double maxNumber() {
        double max = umbers.get(0);
        if (umbers.size() != 0)
            for (int i = 0; i < umbers.size(); ++i) {
                if (umbers.get(i) > max)
                    max = umbers.get(i);
            }
        return max;
    }

    public double minNumber() {
        double min = umbers.get(0);
        if (umbers.size() != 0)
            for (int i = 0; i < umbers.size(); ++i) {
                if (umbers.get(i) < min)
                    min = umbers.get(i);
            }
        return min;
    }
    public boolean primeNumberCheck(Double number){
        if(number.intValue()==1)
            return false;
        for(int i=2;i<=sqrt(number);++i){
            if(number%i==0)
                return false;
        }
        return true;
    }

    public Numbers primeNumberRemoval(){
        for(int i=0;i<umbers.size();++i) {
            if (!primeNumberCheck(umbers.get(i))) {
                umbers.remove(i);
            }
        }
        return this;
    }


    public static void main(String[] args) {
        try {
            Numbers instance = new Numbers();
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(1., 2., 3.,
                    4., 5., 6., 7., 8.));
            instance.addNnumbers();
            System.out.println(instance.maxNumber() + " " + instance.minNumber());
            instance.primeNumberRemoval();
            for(Double element:instance.umbers)
                System.out.println(element.intValue());

        }
        catch (Exception e){
            System.out.println(e);
        }

        System.exit(0);
    }


}
