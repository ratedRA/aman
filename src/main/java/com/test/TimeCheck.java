package com.test;

import javax.xml.crypto.dsig.TransformException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
public class TimeCheck {
    public static void main(String[] args) {
        try {
            Long transform = PeriodTransformer.MILLIS.transform("30 DAYS");
            System.out.println(transform);
        } catch (TransformException e) {
            e.printStackTrace();
        }
    }
}
