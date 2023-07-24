package br.com.designpatterns.creational.prototype;

/**
 *  Prototype
 *
 *  Especifica que deve-se definir uma interface que possibilite a clonagem
 *  de objetos, possibilitando alterações, sem a necessidade de criar um
 *  novo objeto.
 *
 *  Specifies that an interface must be defined that allows the cloning of objects,
 *  allowing changes, without the need to create a new object.
 *
 */

class Sheep implements Cloneable {

    String name;

    public Sheep(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public Object clone(){

        Object object = null;

        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return object;
    }
}

interface SheepPrototype {                              //Interface que possibilita a clonagem
    Sheep clone(Sheep sheep);
}

class SheepPrototypeImpl implements SheepPrototype {
    public Sheep clone(Sheep sheep){
        return (Sheep) sheep.clone();
    }
}

public class Prototype {

    public static void main(String[] args){

        Sheep sheep = new Sheep("Dolly");

        System.out.println(sheep);

        Sheep clone = new SheepPrototypeImpl().clone(sheep);

        System.out.println(clone);                      // Objeto clonado apto a alterações
    }
}
