package br.com.designpatterns.creational.builder;

/**
 *  Builder
 *
 *  Especifica que deve-se definir uma interface para construção
 *  passo a passo de um objeto, permitindo construir diferentes
 *  configurações de um memso objeto.
 *
 *  Specifies that an interface must be defined for building an
 *  object step by step, allowing building different configurations
 *  of the same object.
 */

interface Car {}

class AutomaticCar implements Car {                    //Objeto AutomaticCar

    String model, seats, gear;

    public AutomaticCar(String model, String seats, String gear){
        this.model = model;
        this.seats = seats;
        this.gear = gear;
    }

    public String toString(){
        return "Model: " +model+ "\nSeats: " +seats+ "\nGear: " +gear;
    }
}

class ManualCar implements Car {                       //Objeto ManualCar

    String model, seats, gear;

    public ManualCar(String model, String seats, String gear){
        this.seats = seats;
        this.model = model;
        this.gear = gear;
    }

    public String toString(){
        return "Model: " +model+ "\nSeats: " +seats+ "\nGear: " +gear;
    }
}

interface CarBuilder {                                  //Interface que defini os passos que a classe
    CarBuilder setModel(String model);                  //construtora do objeto deverá executar
    CarBuilder setSeats(String seats);
    CarBuilder setGear(String gear);
}

class AutomaticCarBuilder implements CarBuilder {       //Construtor do objeto AutomaticCar

    String model, seats, gear;

    public AutomaticCarBuilder setModel(String model){
        this.model = model;
        return this;
    }

    public AutomaticCarBuilder setSeats(String seats){
        this.seats = seats;
        return this;
    }

    public AutomaticCarBuilder setGear(String gear){
        this.gear = gear;
        return this;
    }

    public Car build(){
        return new AutomaticCar(model, seats, gear);
    }
}

class ManualCarBuilder implements CarBuilder {          //Construtor do objeto ManualCar

    String model, seats, gear;

    public ManualCarBuilder setModel(String model){
        this.model = model;
        return this;
    }

    public ManualCarBuilder setSeats(String seats){
        this.seats = seats;
        return this;
    }

    public ManualCarBuilder setGear(String gear){
        this.gear = gear;
        return this;
    }

    public Car build(){
        return new ManualCar(model, seats, gear);
    }
}

public class Builder {

    public static void main(String[] args){

        Car automatic = new AutomaticCarBuilder()
                            .setModel("Pulse")
                            .setSeats("5")
                            .setGear("Automatic").build();
        System.out.println(automatic);

        Car manual = new ManualCarBuilder()
                            .setModel("Pulse")
                            .setSeats("5")
                            .setGear("Manual").build();
        System.out.println(manual);
    }
}
