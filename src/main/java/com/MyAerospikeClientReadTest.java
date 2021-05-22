package com;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.Value;
import com.google.gson.Gson;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MyAerospikeClientReadTest {
    public static void main(String[] args) {
        int lowKeyVal = 0;
        int numKeys = 100000;
        int numReads = 100000;

        if (args.length > 0 && args.length != 3) {
            System.err.println("Invalid number of arguments");
            System.exit(1);
        } else if (args.length == 3)
            try {
                lowKeyVal = Integer.parseInt(args[0]);
                numKeys = Integer.parseInt(args[1]);
                numReads = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("All arguments must be integers");
                System.exit(1);
            }

        AerospikeClient client = new AerospikeClient("172.20.98.93", 3000);
        int randomInt;
        Key key = null;
        long startTime = System.currentTimeMillis();
        /*for (int i = 0; i < numReads; i++) {
            randomInt = ThreadLocalRandom.current().nextInt(lowKeyVal, lowKeyVal + numKeys);
            key = new Key("test", "demo", randomInt);
            Record record = client.get(new Policy(), key);
            System.out.println("int:" + record.getInt("intbin") + " string: " + record.getString("strbin"));
        }*/
        for (int i=0; i<100; i++){
            key = new Key("test", "pojoclass", i);
            Record record = client.get(new Policy(), key);
            Gson gson = new Gson();
            MyAerospikeClientWriteTest.AeroSpikeInsertClass testClass = gson.fromJson(record.getString("pojoClass"), MyAerospikeClientWriteTest.AeroSpikeInsertClass.class);
            System.out.println(record.getString("pojoClass"));
        }
        /*key = new Key("test", "compositeKey", "a_5013");
        Record record = client.get(new Policy(), key);
        System.out.println(record.getString("topTen"));
        long endTime = System.currentTimeMillis();
        //System.out.println("records read/sec: " + 100/((endTime - startTime)/1000));
        client.close();*/

       /* key = new Key("test", "item", "f_21619485");
        Record record = client.get(new Policy(), key);
        Map<String, Object> bins = record.bins;
        Gson gson = new Gson();*/
       /* MyAerospikeClientWriteTest.AeroSpikeInsertClass testClass = gson.fromJson(record.getString("pojoClass"), MyAerospikeClientWriteTest.AeroSpikeInsertClass.class);
        System.out.println(record.getString("pojoClass"));*/
    }

    }

