package br.com.designpatterns.creational.factorymethod;

/**
 *
 *  Factory Method
 *
 *  Especifica que deve-se criar uma classe abstrata que defini os métodos
 *  responsáveis por criar objetos sem especificar suas classes concretas.
 *
 *  Specifies that an abstract class must be created that defines the methods
 *  responsible for creating objects without specifying their concrete classes.
 */

interface Car { }

class AutomaticCar implements Car {                             //Objeto AutomaticCar
    public AutomaticCar(){
        System.out.println("Automatic");
    }
}

class ManualCar implements Car {                                //Objeto ManualCar
    public ManualCar(){
        System.out.println("Manual");
    }
}

abstract class CarsFactory {                                    //Classe abstrata que defini os métodos
    public abstract Car buildAutomaticCar();                    //que irão criar os objetos
    public abstract Car buildManualCar();
}

class CarFactory extends CarsFactory {                          //Fábrica de objetos

    public Car buildAutomaticCar(){
        return new AutomaticCar();
    }

    public Car buildManualCar(){
        return new ManualCar();
    }
}

public class FactoryMethod {

    public static void main(String[] args){

        CarFactory factory = new CarFactory();

        Car automatic = factory.buildAutomaticCar();            //Cliente chama o método da fábrica de objetos que ele deseja
        Car manual = factory.buildManualCar();
    }
}
