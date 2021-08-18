package com.test;

public interface ZooInterface {

    @Importer(key = "qualify")
    default void belongsHere(String sayHello){
        System.out.println("implement this in dogChild");
    }
}
