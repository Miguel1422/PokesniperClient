
package com.mycompany.pokemonraros2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList <Integer> a = new ArrayList<>();

        a.add(2);
        a.add(2);

        for (int b: a) {
            a.remove(0);
        }
    }
}
