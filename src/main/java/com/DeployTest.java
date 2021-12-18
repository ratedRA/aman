package com;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
public class DeployTest {
    public static void main(String[] args) {
        try {
            Long stTime = System.currentTimeMillis();
            System.out.println(InetAddress.getLocalHost());
            System.out.println((stTime - System.currentTimeMillis()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
