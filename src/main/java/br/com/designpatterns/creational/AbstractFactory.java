package br.com.designpatterns.creational;

/**
 *  Abstract Factory
 *
 *  Especifica que deve-se definir uma interface para criação de famílias de objetos(relacionados ou interdependentes),
 *  sem especificar suas classes concretas. A partir disto consegue-se criar fábricas concretas desses objetos para
 *  atender as necessidades do cliente, excluindo a dependência entre o cliente e a classe dos objetos usados por ele.
 *
 *  Specifies that an interface must be defined for creating object families (related or interdependent),
 *  without specifying their concrete classes. From this it is possible to create concrete factories of
 *  these objects to meet the needs of the client, excluding the dependency between the client and the
 *  class of objects used by him.
 *
 */


interface Car {                                                 //Interface que defini a família de objetos
    String gear();
}

class AutomaticCar implements Car {                             //Objeto da família
    public String gear(){
        return "Automatic";
    }
}

class ManualCar implements Car {                                //Objeto da família
    public String gear(){
        return "Manual";
    }
}

interface CarAbstractFactory {                                  //Interface que defini a fábrica de objetos
    Car buildCar();
}

class AutomaticCarFactory implements CarAbstractFactory {       //Fábrica do objeto AutomaticCar
    public Car buildCar(){
        return new AutomaticCar();
    }
}

class ManualCarFactory implements CarAbstractFactory {          //Fábrica do objeto ManualCar
    public Car buildCar(){
        return new ManualCar();
    }
}

class CarFactory {                                              //Fábrica da família de objetos

    public static Car buildCar(CarAbstractFactory factory){
        return factory.buildCar();
    }
}

public final class AbstractFactory {

    public static void main(String[] args){

        Car automatic = CarFactory.buildCar(new AutomaticCarFactory()); //Cliente passa para fábrica da família de objetos
        System.out.println(automatic.gear());                           //a fábrica do objeto que ele deseja.

        Car manual = CarFactory.buildCar(new ManualCarFactory());
        System.out.println(manual.gear());
    }

}
