package com.codersbid;

import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

public class Main {
    private static Date createdDateAfter;
    private static Date createdDateBefore;
    protected static int age;
    private static TimeUnit timeUnit;

    public static void main(String[] args) {
        TestValuePassing testValuePassing = new TestValuePassing("20");
        setValue(testValuePassing);
        System.out.println(testValuePassing.getValue());
    }
    protected void setAge(int x){
        this.age  = x;
    }
    private static void setValue(TestValuePassing value){
        value.setValue("10");
        return;
    }
}
 class TestValuePassing{
        private String value;

     public TestValuePassing(String value) {
         this.value = value;
     }

     public String getValue() {
         return value;
     }

     public void setValue(String value) {
         this.value = value;
     }
 }
