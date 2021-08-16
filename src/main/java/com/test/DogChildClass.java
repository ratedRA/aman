package com.test;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.io.IOUtils;



public class DogChildClass extends AnimalParentClass{
    public void bark(){
        System.out.println("this one can bark");
    }

    @Override
    public void rub() {
        super.rub();
    }

    @Override
    public void belongsHere() {
        System.out.println("dog doesn't belong in zoo");
    }
}
class Main1{
    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");
    private static final String SEPARATOR = "/";

    private static AnimalParentClass callerContext(){
        AnimalParentClass childClass = new DogChildClass();

        return childClass;
    }
    private static int getNumber(int x){
        while(x>0){
            if(x == 5){
                return x;
            }
            x--;
        }
        return x;
    }
    public static InputStream getInputStream(String str, String encoding) throws UnsupportedEncodingException {
        return new ByteArrayInputStream(str.getBytes(encoding));
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /*DogChildClass dogChildClass = (DogChildClass) callerContext();
        // dogChildClass.bark();

        System.out.println(getNumber(10));*//*
        try {
            File ret = File.createTempFile("123435435" + '-' + "installs" + '-' + "2021-02-03" + '-' + "2021-02-03", ".csv", new File(TEMP_DIR));
            File file = new File(TEMP_DIR + SEPARATOR + "appsFyler2" + SEPARATOR + "123435435" + '-' + "installs" + '-' + "2021-02-03" + '-' + "2021-02-03.csv");
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            if(!file.exists()){
                file.createNewFile();
            }
            InputStream input = getInputStream("aman@nd Test", "UTF-8");
            IOUtils.copy(input, new FileOutputStream(file));
            System.out.println(file.getAbsolutePath());*/

        DogChildClass dogChildClass  = new DogChildClass();
        dogChildClass.rub();

        Class clasz = ZooInterface.class;
        Method declaredMethods = clasz.getDeclaredMethod("belongsHere");
        invokeMethod(declaredMethods, dogChildClass);

    }

    private static void invokeMethod(Method method, DogChildClass dogChildClass) throws InvocationTargetException, IllegalAccessException {
        System.out.println("entered invoke method");
        method.invoke(dogChildClass);
    }
}
