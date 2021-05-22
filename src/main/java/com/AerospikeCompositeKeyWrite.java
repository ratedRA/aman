package com;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.Policy;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.query.IndexType;

public class AerospikeCompositeKeyWrite {
    public static void main(String[] args) {
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

        AerospikeClient client = new AerospikeClient("172.28.128.3", 3000);
        int randomInt;
        Key key1 = null;
        Key key2 = null;
        Key key3 = null;
        Key key4 = null;

        // client.createIndex(new Policy(), "test", "compositeKey", "searchable_key", "key", IndexType.STRING);

        for(int  i=0; i<10; i++){
            key1 = new Key("test", "compositeKey", "a_5013"+ String.valueOf(i));
            Bin fistKeyBin = new Bin("topTen", i);
            Bin constantId = new Bin("key", "a_5013");
            client.put(new WritePolicy(), key1, fistKeyBin, constantId);
        }
        for(int  i=11; i<20; i++){
            key2 = new Key("test", "compositeKey", "b_5013"+String.valueOf(i));
            Bin secondKeyBin = new Bin("topTen", i);
            Bin constantId = new Bin("key", "b_5013");
            client.put(new WritePolicy(), key2, secondKeyBin, constantId);
        }
        key3 = new Key("test", "compositeKey", "otherKey");
        for(int  i=21; i<30; i++){
            Bin secondKeyBin = new Bin("topThirty", i);
            client.put(new WritePolicy(), key3, secondKeyBin);
        }
    }
}
