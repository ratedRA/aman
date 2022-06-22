package com.spring28Minutes.execution.sorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class Main {
    @Autowired
  private static ApplicationContext applicationContext;

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "classpath*:**/spring-servlet.xml");
//        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
//        BinarySearch binarySearch = applicationContext.getBean("binarySearch", BinarySearch.class);
//        binarySearch.search(new int[]{1,3,2},3);

        int b = 5;
        int a = b;
        a+=1;

        System.out.println(b + " " + a);

    }
}
