package com.cpp;

// comparator can be used to sort the object according to its data member. or is
// basically used to compare to objects.
// to use the comparator in collections.sort(), we need to pass a comparator in it along with the object array or list.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CustomStudentObject {
    private String name;
    private int age;
    private int rollNo;
    private String classId;

    public CustomStudentObject(String name, int age, int rollNo, String classId) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}


public class ComparatorExample {
    public static void main(String[] args) {
        CustomStudentObject stdnt1 = new CustomStudentObject("first", 11, 24, "24");
        CustomStudentObject stdnt2 = new CustomStudentObject("second", 11, 31, "26");
        CustomStudentObject stdnt3 = new CustomStudentObject("third", 11, 45, "25");
        CustomStudentObject stdnt4 = new CustomStudentObject("fourth", 11, 28, "22");
        CustomStudentObject stdnt5 = new CustomStudentObject("fifth", 11, 1, "48");

        List<CustomStudentObject> customStudentObjects = new ArrayList<>();
        customStudentObjects.add(stdnt1);
        customStudentObjects.add(stdnt2);
        customStudentObjects.add(stdnt3);
        customStudentObjects.add(stdnt4);
        customStudentObjects.add(stdnt5);

        //sort by roll number.
        Collections.sort(customStudentObjects, Comparator.comparingInt(CustomStudentObject::getRollNo));
        customStudentObjects.stream().forEach(ob -> System.out.println(ob.getRollNo()));

        // sort by  name.
        // can also replace it by Comparator.comparing.
        Collections.sort(customStudentObjects, (a,b)->{

            return a.getName().compareTo(b.getName());
        });
        customStudentObjects.stream().forEach(ob -> {
            System.out.println(ob.getName());
        });
    }
}
