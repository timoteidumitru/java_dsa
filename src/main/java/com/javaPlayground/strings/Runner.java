package com.javaPlayground.strings;

public class Runner {
    public static void main(String[] args) {
        String immutable = "immutable";
        String newStr =   immutable.concat(" string");

//        System.out.println(immutable.intern().equals(newStr));

        System.out.println(newStr.intern());
//        System.out.println(immutable);

        StringBuilder mutable = new StringBuilder("mutable");
//        mutable.append(" string");

//        System.out.println(mutable);
    }
}
