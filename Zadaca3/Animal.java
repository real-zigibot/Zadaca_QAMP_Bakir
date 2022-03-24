import java.util.Scanner;

public abstract class Animal {
    protected String name;
    protected String food;


    protected abstract void animalSound();
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

    final void sleep() {
        System.out.println("Zzz");
    }
}

class Dog extends Animal {
    private String favoriteBone = new String();
    private boolean likesBigBones = false;

    public Dog() {}

    Dog(String name, String food, String bone, boolean preference) {
        this.name = name;
        this.food = food;
        favoriteBone = bone;
        likesBigBones = preference;
    }

    public Dog(String name, String food, String bone) {
        this(name, food, bone, false);
    }

    public Dog(String name, String food) {
        this();
        this.name = name;
        this.food = food;
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
        Dog Lucky = new Dog();
        Lucky.animalSound();
        Lucky.sleep();
        Cat bigCat = new Cat();
        SiameseCat newCat = new SiameseCat();
        bigCat.animalSound();
        bigCat.sleep();
        newCat.sleep();
        newCat.animalSound();
        newCat.getPedigreeNumber();
        newCat.setPedigree(17);
    }
}