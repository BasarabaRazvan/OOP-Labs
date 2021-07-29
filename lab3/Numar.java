package com.company;

import java.sql.SQLOutput;

public class Numar {
    int nr;

    public Numar(int nr) {
        this.nr = nr;
    }

    public int suma(int a) {
        return a + this.nr;
    }

    public int suma(int a, int b) {
        return suma(a) + b;
    }

    public int suma(int a, int b, int c) {
        return suma(a, b) + c;
    }

    public int suma(int a, int b, int c, int d) {
        return  suma(a, b, c) + d;
    }

    public static void main(String[] args) {
        Numar n = new Numar(10);
        System.out.println(n.suma(5, 7 , 4, 2));
    }
}
