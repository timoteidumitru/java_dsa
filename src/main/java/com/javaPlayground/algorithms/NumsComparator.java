package com.javaPlayground.algorithms;

import java.util.Comparator;
import java.util.Objects;

public class NumsComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (Objects.equals(o1, o2)){
            return 0;
        } else if (o1 > o2) {
            return 1;
        } else{
            return -1;
        }

    }
}
