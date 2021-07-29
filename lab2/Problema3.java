package com.company;
import java.util.Random;
import java.util.Vector;

public class Problema3 {
    public static int rm(Vector<Integer> v, int x) {
        int nr = 0;
        for(int i = 0 ; i < v.size(); i++) {
            if(v.get(i) == x)
                v.remove(i);
                i--;
                nr++;
        }
        System.out.println(v);
        return nr;
    }
    public static void main(String[] args) {
        Vector<Integer>  v = new Vector<>(20);
        Random rd = new Random();
        for(int i = 0; i < 20; i++)
            v.add(rd.nextInt(10));
        System.out.println(v);
        //int numar = rm(v, 7);
        //System.out.println(numar);
        System.out.println(v);
        int M = -1, m = 11, suma = 0;
        for(int i = 0; i < v.size(); i++) {
            if(v.get(i) > M)
                M = v.get(i);
            if(v.get(i) < m)
                m = v.get(i);
            suma = suma + v.get(i);
        }
        double medie = suma / v.size();
        System.out.println("Maximul este: " + M);
        System.out.println("Minimul este: " + m);
        System.out.println("Media este: " + medie);
    }
    }

