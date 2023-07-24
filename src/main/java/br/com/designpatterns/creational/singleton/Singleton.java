package br.com.designpatterns.creational.singleton;

import java.util.Objects;

/**
 *
 *  Singleton
 *
 *  Garante que apenas uma instância de objeto seja criada e defina um único ponto de acesso.
 *  - A classe deve ser final, evitando a criação de subclasses.
 *  - O construtor deve ser privado, evitando ser instanciada.
 *  - O acesso é permitido através do método que retorna a instância única da classe, ou faz a criação de uma.
 *
 *  Ensures that only one object instance is created and defines a single access point.
 *  - The class must be final, avoiding the creation of subclasses.
 *  - The constructor must be private, avoiding being instantiated.
 *  - Access is allowed through the method that returns the single instance of the class, or creates one.
 *
 */

final class Account {                       //evita ser estendida

    public static Account account;

    private Account(){                      //evita ser instanciada

    }

    public static Account getInstance(){    //retorna única instância da classe
        if(Objects.isNull(account))
            account = new Account();
        return account;
    }

}

public class Singleton {

    public static void main(String[] args){

        Account account = Account.getInstance();

        System.out.println(account.hashCode());

        Account other = Account.getInstance();

        System.out.println(other.hashCode());
    }
}
