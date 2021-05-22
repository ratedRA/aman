package com;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.Value;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MyAerospikeClientWriteTest {
    public static void main(String[] args) {
        // Default is to write 100,000 records
        int lowKeyVal = 0;
        int numKeys = 100000;

        if (args.length > 2 || args.length == 1) {
            System.err.println("Invalid number of arguments");
            System.exit(1);
        } else if (args.length == 2)
            try {
                lowKeyVal = Integer.parseInt(args[0]);
                numKeys = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Both arguments must be integers");
                System.exit(1);

            }

        AerospikeClient client = new AerospikeClient("172.20.98.93", 3000);
        int randomInt;
        Key key = null;

        /*long startTime = System.currentTimeMillis();
        for (int i = lowKeyVal; i < lowKeyVal + numKeys; i++) {
            key = new Key("test", "demo", i);
            randomInt = ThreadLocalRandom.current().nextInt(1, 100000);
            Bin int_bin = new Bin("intbin", randomInt);
            Bin str_bin = new Bin("strbin", String.valueOf(randomInt));
            client.put(new WritePolicy(), key, int_bin, str_bin);
        }*/

        for(int i =0; i<100; i++){
            key = new Key("test","pojoclass", i);
            AeroSpikeInsertClass insertClass =  new AeroSpikeInsertClass(generateRandomWords(1)[0], generateRandomWords(1)[0], new ChildAerospike(generateRandomWords(1)[0], Lists.newArrayList(generateRandomWords(3))));
            new Gson().toJson(insertClass);
            Bin pojoClass = new Bin("pojoClass", new Gson().toJson(insertClass).toString());
            client.put(new WritePolicy(), key, pojoClass);
        }
        }

        public static String[] generateRandomWords(int numberOfWords)
        {
            String[] randomStrings = new String[numberOfWords];
            Random random = new Random();
            for(int i = 0; i < numberOfWords; i++)
            {
                char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
                for(int j = 0; j < word.length; j++)
                {
                    word[j] = (char)('a' + random.nextInt(26));
                }
                randomStrings[i] = new String(word);
            }
            return randomStrings;
        }

        static class AeroSpikeInsertClass{
            private String name;
            private String val;
            private ChildAerospike childAerospike;

            public AeroSpikeInsertClass(String name, String val, ChildAerospike aerospike) {
                this.name = name;
                this.val = val;
                this.childAerospike = aerospike;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getVal() {
                return val;
            }

            public void setVal(String val) {
                this.val = val;
            }

            public ChildAerospike getChildAerospike() {
                return childAerospike;
            }

            public void setChildAerospike(ChildAerospike childAerospike) {
                this.childAerospike = childAerospike;
            }
        }

        static class ChildAerospike{
            private String firstName;
            private List<String> stringList;

            public ChildAerospike(String firstName, List<String> stringList) {
                this.firstName = firstName;
                this.stringList = stringList;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public List<String> getStringList() {
                return stringList;
            }

            public void setStringList(List<String> stringList) {
                this.stringList = stringList;
            }
        }
    }

