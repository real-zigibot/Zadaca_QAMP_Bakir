import java.util.Scanner;

public abstract class Animal {
    protected String name;
    protected String food;
    //protected int vaccinationCode;

    protected abstract void animalSound();

    //Animal();

    final void setName() {
        System.out.println("Unesi ime svoje zivotinje: ");
        Scanner obj = new Scanner(System.in);
        name = obj.nextLine();
    }

    protected final String getName() {
        return name;
    }

    protected abstract void setFood();

    protected final String getFood() {
        return food;
    }

    // Regular method
    final void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from Animal)
class Dog extends Animal {
    private String favoriteBone;
    private boolean likesBigBones;

    Dog() {
        favoriteBone = new String();
        likesBigBones = false;
    }

    Dog(String bone) {
        favoriteBone = bone;
        likesBigBones = false;
    }

    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The dog says: woof");
    }

    public void setFood() {
        if (likesBigBones)
            food = "Bones and pasta.";
        else
            food = "Rice and chicken";
    }
}

class Cat extends Animal {
    private String favoriteShelf;
    private String favoriteMilk;

    Cat() {
        favoriteShelf = new String();
        favoriteMilk = new String();
    }

    Cat(String shelf) {
        favoriteShelf = shelf;
        favoriteMilk = new String();
    }

    public void setFood() {
        if (favoriteMilk.length() == 0)
            food = favoriteMilk;
        else
            food = "Tunafish";
    }

    public void animalSound() {
        System.out.println("The cat says: meow");
    }
}

class SiameseCat extends Cat {
    private int pedigree;

    public void animalSound() {
        System.out.println("The Siamesecat says: meow prrr");
    }

    int getPedigreeNumber() {
        return pedigree;
    }

    void setPedigree(int nmb) {
        pedigree = nmb;
    }
}

class Main {
    public static void main(String[] args) {
        Dog myPig = new Dog(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
        Cat macka = new Cat();
        SiameseCat maca = new SiameseCat();
        macka.animalSound();
        macka.sleep();
        maca.sleep();
        maca.animalSound();
        maca.getPedigreeNumber();
        maca.setPedigree(17);
    }
}