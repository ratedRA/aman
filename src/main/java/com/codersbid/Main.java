package com.codersbid;

import com.google.common.collect.Sets;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class Main {
    private static Date createdDateAfter;
    private static Date createdDateBefore;
    protected static int age;
    private static TimeUnit timeUnit;

    public static void main(String[] args) {
//        TestValuePassing testValuePassing = new TestValuePassing("20");
//        setValue(testValuePassing);
//        System.out.println(testValuePassing.getValue());
        //String s = RandomStringUtils.randomAlphanumeric(8);
        List<String> lost =Arrays.asList("1st, second, 3ird");
        List<String> lost2 = new ArrayList<>();
        String[] toArray = lost2.toArray(new String[0]);
        System.out.println(toArray.length);

        System.out.println(StringUtils.join(lost2, ","));
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
