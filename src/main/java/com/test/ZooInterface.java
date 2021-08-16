package com.test;

public interface ZooInterface {

    default void belongsHere(){
        System.out.println("implement this in dogChild");
    }
}
