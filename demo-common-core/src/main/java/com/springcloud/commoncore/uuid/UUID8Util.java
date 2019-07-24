package com.springcloud.commoncore.uuid;

import java.util.Random;
import java.util.UUID;

public class UUID8Util {

    public static String generate8UUID() {
        Random r = new Random();
        String s="";
        for (int i = 0; i < 8; i++) {
            s+=r.nextInt(10);
        }
        return s;
    }
}
