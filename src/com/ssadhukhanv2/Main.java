package com.ssadhukhanv2;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer i=9;
        Class c = int.class;
        m(Arrays.asList(""),Arrays.asList(""));
    }
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }
}
