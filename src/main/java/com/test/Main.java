package com.test;


import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.FilenameUtils;
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

public class Main {
    private static boolean checkCase(String value){
        return value == "a" || value == "b";
    }
    private static Set<String> removeL1s = Sets.newHashSet("/art/","/furniture/");
    public static void main(String[] args) throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, ParseException, MalformedURLException {
        List<String> actualList = new ArrayList<>();
        actualList.add("/furniture/lighting/?price=[1 TO 2000]&style=contemporary,mid-century-modern");
        actualList.add("/art/paintings/?per=18-century");
        actualList.add("/art/photography/?price=[2 TO 6000]&per=18-century");
        actualList.add("/art/");
        actualList.add("/furniture/");
        actualList.add("/jewelry/");

        Set<String> s1 = Sets.newHashSet("a", "b", "c");
        Set<String> s2 = Sets.newHashSet("a", "b", "d");

        Map<String, List<String>> params = new HashMap<>();
        if(params.get("api_token") == null){
            params.put("api_token", Lists.newArrayList("firstToken"));
        }if(params.get("api_token") != null) {
            params.get("api_token").add("secondToken");
        }

        /*URI uri = new UriTemplate("https://hq.appsflyer.com/export/").expand(params);
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.execute(uri, HttpMethod.GET, null, null);*/

        /*org.apache.commons.vfs2.impl.StandardFileSystemManager fileSystemManager = new StandardFileSystemManager();
        try {
            fileSystemManager.init();
            File folder = new File("/Users/amanprasad/codebase/analytics-service");
            File[] listOfFiles = folder.listFiles();
            List<FileObject> reportsFileObject = new ArrayList<>();
            for(File file : listOfFiles){
                reportsFileObject.add(fileSystemManager.resolveFile(file.getPath()));
            }
            File a = new File("/");
        } catch (org.apache.commons.vfs2.FileSystemException e) {
            throw new RuntimeException("error");
        }

        actualList.removeAll(removeL1s);*/
        //System.out.println(actualList);

        //System.out.println(params.get("api_token"));

//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a|2021/02/22 hh:mm:ss");
//        Date parse = dateFormat.parse("2/12/1996 2:32:45 AM");
//        System.out.println(parse);

//        String supper = "abcd";
//        if(supper.equals(supper.toUpperCase())){
//            System.out.println(true);
//        }
//        System.out.println(supper);
//        String s = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "Aman");
//        System.out.println(s);
//
//        Date date = DateUtils.addDays(new Date(), -Integer.parseInt("1"));
//        System.out.println(date);

//        String biggerFileName = "EngagedUsers120days_20210322.txt";
//        String justPrefix = "EngagedUsers120days.txt";
//        String withoutExtension = FilenameUtils.removeExtension(justPrefix);
//
//        if(biggerFileName.startsWith(withoutExtension)){
//            System.out.println("you got it right");
//        }

//        File file = new File("/tmp/crontest/EngagedUsers120days_20210322.txt");
//        System.out.println(file.getName());
        byte[] bytes = new byte[12];
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        int position = byteBuffer.remaining();
        System.out.println(position);
        System.out.println(bytes.length);
        try{
            throw new IOException("exception");
        } catch (Exception e){
            if(e.getCause().equals("java.io.IOException")){
                System.out.println(e.getMessage());
            }
        }

    }


    private enum Value{
        VALUE1,
        VALUE2;
    }
}
