import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.sqrt;


public class Numbers {
    private ArrayList<Double> numbers;

    private Numbers(ArrayList<Double> l) {
        numbers = l;
    }

    private Numbers() {
        numbers = new ArrayList<Double>();
        Scanner someObj = new Scanner(System.in);
        System.out.println("Koliko brojeva zelis u listi: ");
        int size = someObj.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.format("Unesi %d. broj: ", i + 1);
            numbers.add(someObj.nextDouble());
        }
    }

    public double getElement(int position) {
        if (position > 0) {
            if (numbers.size() < position) {
                throw new ArrayIndexOutOfBoundsException("Lista nema element na poziciji");
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Index negativan ili 0");
        }
        return numbers.get(position - 1);
    }

    public Numbers setElement(int position, double element) {
        if (position > 0) {
            if (numbers.size() < position) {
                throw new ArrayIndexOutOfBoundsException("Lista nema element na poziciji");
            }
            numbers.set(position - 1, element);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index negativan ili 0 ");
        }
        return this;
    }

    public void addNnumbers() {
        double sum = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            //  writeOutFunction(90, i);
            // numbers.add(someObj.nextDouble());
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }

    public void addNnumbers(ArrayList<Double> array) { //dodano u slucaju da se zeli metoda primijeniti nad odredjenom
        // instancom klase cak i kada ne zelimo da vrsimo prethodnu dodjelu sa "numbers"(ovdje array) argumentom
        // druge instance
        double sum = 0;
        numbers = array;
        for (int i = 0; i < array.size(); i++) {
            sum += numbers.get(i);
        }
        //writeOutFunction(3,90);
        System.out.println(sum);
    }

    public double maxNumber() {
        double max = numbers.get(0);
        if (numbers.size() != 0) {
            for (int i = 0; i < numbers.size(); ++i) {
                if (numbers.get(i) > max) {
                    max = numbers.get(i);
                }
            }
        }
        return max;
    }

    public double minNumber() {
        double min = numbers.get(0);
        if (numbers.size() != 0) {
            for (int i = 0; i < numbers.size(); ++i) {
                if (numbers.get(i) < min) {
                    min = numbers.get(i);
                }
            }
        }
        return min;
    }

    public boolean primeNumberCheck(Double number) {
        if (number.intValue() == 1) {
            return false;
        }
        for (int i = 2; i <= sqrt(number); ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void primeNumberRemoval() {
        for (int i = 0; i < numbers.size(); ++i) {
            if (!primeNumberCheck(numbers.get(i))) {
                numbers.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        try {
            Numbers instance = new Numbers();
            ArrayList<Double> list = new ArrayList<>(Arrays.asList(1., 2., 3.,
                    4., 5., 6., 7., 8.));
            instance.addNnumbers();
            System.out.println(instance.maxNumber() + " " + instance.minNumber());
            instance.primeNumberRemoval();
            for (Double element : instance.numbers) {
                System.out.println(element.intValue());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.exit(0);
    }

}
