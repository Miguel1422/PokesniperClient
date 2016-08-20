/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemonraros2;

import java.util.StringTokenizer;

/**
 *
 * @author Miguel
 */
public class tets {
    public static void main(String[] args) {
        String h = "lkasd, dasd";
        StringTokenizer st = new StringTokenizer(h, ", ");

        System.out.println(st.nextToken());
        System.out.println(st.nextToken());

    }
}

