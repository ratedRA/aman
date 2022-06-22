package com.test;


import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static boolean checkCase(String value){
        return value == "a" || value == "b";
    }
    private static Set<String> removeL1s = Sets.newHashSet("/art/","/furniture/");
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//
        String s = "auction_lot_status";
        if(s.charAt(0) != '-'){
            System.out.println("yes");
        }
    }

    private static void modifyAssignment(CheckAssignment checkAssignment){
        String name = checkAssignment.getName();
        name = "changedName";
    }
    private static void modifyTestClass(TestClass testClass){
        Map<String, String> qpMap = testClass.getQpMap();
        qpMap.put("aman", "changed");
    }
    private static class CustomException extends RuntimeException{
        public CustomException(Exception ex) {
            super(ex);
        }
    }
    private static class RawQueries{
        private TestClass testClass = new TestClass();

        public TestClass getTestClass() {
            return testClass;
        }

        public void setTestClass(TestClass testClass) {
            this.testClass = testClass;
        }
    }
    private static class CheckAssignment{
        private String name;

        public CheckAssignment(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    private static class TestClass{
        private Map<String, String> qpMap = new HashMap<>();

        public TestClass() {
            qpMap.put("aman", "firstInit");
        }

        public Map<String, String> getQpMap() {
            return qpMap;
        }

        public void setQpMap(Map<String, String> qpMap) {
            this.qpMap = qpMap;
        }

        @Override
        public String toString() {
            return "TestClass{" +
                    "qpMap=" + qpMap +
                    '}';
        }
    }

    private enum Value{
        VALUE1,
        VALUE2;
    }
}
