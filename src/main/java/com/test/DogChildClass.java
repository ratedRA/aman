package com.test;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.unitils.util.AnnotationUtils;


public class DogChildClass extends AnimalParentClass{
    public void bark(){
        System.out.println("this one can bark");
    }

    @Override
    public void rub() {
        super.rub();
    }

    @Override
    public void belongsHere(String sayHello) {
        System.out.println("dog doesn't belong in zoo" + sayHello);
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
        Set<Method> importerMethods = AnnotationUtils.getMethodsAnnotatedWith(ZooInterface.class, Importer.class, false);
        Method importerToInvoke = (Method)importerMethods.toArray()[0];

        invokeMethod(importerToInvoke, dogChildClass);

//        String stringAsJson = "{\n" +
//                "  \"page\": \"/art/drawings-watercolor-paintings/\",\n" +
//                "  \"name\": \"Drawings and Watercolor Paintings\",\n" +
//                "  \"type\": \"SEARCH\",\n" +
//                "  \"user\": {\n" +
//                "    \"id\": \"17065242\"\n" +
//                "  }\n" +
//                "}";
//
//        Gson gson = new Gson();
//        Map map = gson.fromJson(stringAsJson, Map.class);
//        MapWrapArg mapWrapArg = new MapWrapArg();
//        mapWrapArg.putAll(map);
//        System.out.println(mapWrapArg);

    }

    private static void invokeMethod(Method method, DogChildClass dogChildClass) throws InvocationTargetException, IllegalAccessException {
        System.out.println("entered invoke method");
        if(method.getAnnotation(Importer.class).key().equals("qualify")) {
            method.invoke(dogChildClass, "sayHello");
        }
    }
}
