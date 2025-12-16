
package com.mycompany.app;

import me.xdrop.fuzzywuzzy.FuzzySearch;

public class FuzzyExample {
    public static void main(String[] args) {
        String s1 = "Apache Commons Text";
        String s2 = "apache cmons";

        int ratio = FuzzySearch.ratio(s1, s2);

        System.out.println("Fuzzy ratio: " + ratio);
    }
}
