package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class JavaSupplier {
    public static void main(String[] args) {
        Supplier<String> getCurDateInESTTimeZOne = ()->{
            SimpleDateFormat  dateFormat = new SimpleDateFormat("YYYY_MM_dd : HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
            return dateFormat.format(new Date());
        };
        System.out.println(getCurDateInESTTimeZOne.get());
    }

}
