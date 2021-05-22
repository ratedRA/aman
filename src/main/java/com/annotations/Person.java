package com.annotations;

import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class Person{

    @JsonElement
    private String fName;

    @JsonElement
    private String lName;

    @JsonElement(key = "personAge")
    private String age;

    private String address;

    @Init(fName = "aman", lName = "prasad")
    public void initNames(String fName, String lName) throws  CapitalizeException{
//        try {
//            this.fName = this.fName.substring(0, 1).toUpperCase() + this.fName.substring(1);
//            this.lName = this.lName.substring(0, 1).toUpperCase() + this.lName.substring(1);
//            System.out.println(fName+" "+lName);
//        }
//        catch (Exception e){
//            throw new CapitalizeException("number cannot be converted to string");
//        }
        // "Before Now"
        Person p = new Person();
        try{
            Method m = p.getClass().getMethod("initNames",String.class, String.class);
            Init initialization = m.getAnnotation(Init.class);
            System.out.println("Before Initialization");
            System.out.println(initialization.fName()+" "+initialization.lName());
            //initialization.fName() = initialization.fName().substring(0,1).toUpperCase()+initialization.fName().substring(1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        fName = fName.substring(0,1).toUpperCase() + fName.substring(1);
        lName = lName.substring(0,1).toUpperCase() + lName.substring(1);
        System.out.println("After initialization");
        System.out.println(fName+" "+lName);



    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
