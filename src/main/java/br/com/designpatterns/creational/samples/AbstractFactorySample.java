package br.com.designpatterns.creational.samples;

/**
 * Design Patterns in Java
 *
 * Abstract Factory Sample
 */

interface Car {

    void gear();
    void model(String model);
}

class AutomaticCar implements Car {

    String gear;
    String model;

    public AutomaticCar(String model){
        gear();
        model(model);
    }

    public void gear(){
        this.gear = "Automatic";
    }

    public void model(String model){
        this.model = model;
    }

    public String toString(){
        return "Model: " +model+ "\nGear: " +gear;
    }
}

class ManualCar implements Car {

    String gear;
    String model;

    public ManualCar(String model){
        gear();
        model(model);
    }

    public void gear(){
        this.gear = "Manual";
    }

    public void model(String model){
        this.model = model;
    }

    public String toString(){
        return "Model: " +model+ "\nGear: " +gear;
    }
}

interface CarAbstractFactory {

    Car buildCar();
}

class AutomaticCarFactory implements CarAbstractFactory {

    public String model;

    public AutomaticCarFactory(String model){
        this.model = model;
    }

    public Car buildCar(){
        return new AutomaticCar(model);
    }
}

class ManualCarFactory implements CarAbstractFactory {

    String model;

    public ManualCarFactory(String model){
        this.model = model;
    }

    public Car buildCar(){
        return new ManualCar(model);
    }
}

class CarFactory {

    public static Car buildCar(CarAbstractFactory factory){
        return factory.buildCar();
    }
}

public final class AbstractFactorySample {
    public static void main(String[] args) {

        Car automatic = CarFactory.buildCar(new AutomaticCarFactory("Pulse"));
        System.out.println(automatic);

        Car manual = CarFactory.buildCar(new ManualCarFactory("Pulse"));
        System.out.println(manual);
    }
}
