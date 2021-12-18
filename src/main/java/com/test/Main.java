package com.test;


import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.enums.Enum;
import org.apache.commons.lang.enums.EnumUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.ByteBuffer;
import java.nio.file.FileSystemException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static boolean checkCase(String value){
        return value == "a" || value == "b";
    }
    private static Set<String> removeL1s = Sets.newHashSet("/art/","/furniture/");
    public static void main(String[] args) {
//        System.out.println(Main.class.getResource("/").getPath());
//        String property = System.getProperty("os.name");
//        System.out.println(property);
//        RawQueries rawQueries = new RawQueries();
//        modifyTestClass(rawQueries.getTestClass() );
//        System.out.println(rawQueries.getTestClass().getQpMap());

        String tester = "{!tag=l1}seller";
        String substring = tester.substring(tester.indexOf("{"), tester.indexOf("}") + 1);
        System.out.println(substring);
        if(substring.contains("tag")){
            System.out.println("yes it works");
        }
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
    }

    private enum Value{
        VALUE1,
        VALUE2;
    }
}
