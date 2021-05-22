package com.spring28Minutes.execution.sorting;

import com.spring28Minutes.searching.impl.BinarySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Arrays;

public class Main {
    @Autowired
  private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:**/spring-servlet.xml");
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        BinarySearch binarySearch = applicationContext.getBean("binarySearch", BinarySearch.class);
        binarySearch.search(new int[]{1,3,2},3);

    }
}
