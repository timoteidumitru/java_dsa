package com.javaPlayground.strings;

public class Runner {
    public static void main(String[] args) {
        String immutable = new String("immutable");
        immutable.concat(" string");

        System.out.println(immutable);

        StringBuilder mutable = new StringBuilder("mutable");
        mutable.append(" string");

        System.out.println(mutable);
    }
}
