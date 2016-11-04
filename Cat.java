package p2;

import p1.Animal;
public class Cat extends Animal
{
    public Cat(){
        super.name = "benny";//possible
        name = "benny" ;// possible (same as before in this context)
        Cat c = new Cat();
        c.name = "benny"; //  possible, because it's a cat and cat is in the same package(same class even)
        Animal a = new Animal();
        a.name= "benny"; // not possible, because Animal is in a different package 
    }
}