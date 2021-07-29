package com.company;

import java.util.Random;
import java.util.Vector;

public class Problema4 {
    Vector reunion(Vector v1, Vector v2) {
        Vector reunire = new Vector();
        reunire.addAll(v1);
        for(int i = 0; i < v2.size(); i++)
        {
            int ok = 1;
            for(int j = 0; j < v1.size(); j++)
                if(v2.get(i) == v1.get(j))
                    ok =0;
           if(ok == 1)
               reunire.add(v2.get(i));
        }
        return reunire;
    }
    Vector intersection(Vector v1, Vector v2) {
        Vector intersectie = new Vector();
        for (int i = 0; i < v1.size(); i++) {
            int ok = 0;
            for (int j = 0; j < v2.size(); j++)
                if (v1.get(i) == v2.get(j))
                    ok = 1;
            if (ok == 1)
                intersectie.add(v1.get(i));
        }
        return intersectie;
    }
    Vector diferenta(Vector v1, Vector v2) {
        Vector dif = new Vector();
        for (int i = 0; i < v1.size(); i++) {
            int ok = 1;
            for (int j = 0; j < v2.size(); j++)
                if(v1.get(i) == v2.get(j))
                    ok = 0;
             if(ok == 1)
                 dif.add(v1.get(i));
        }
        return dif;
    }
    public static void main(String[] args) {
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        Vector vectorRez = new Vector();
        vector1.add(1);
        vector1.add(2);
        vector1.add(3);
        vector1.add(4);
        vector2.add(3);
        vector2.add(4);
        vector2.add(5);
        vector2.add(6);
        System.out.println(vector1);
        System.out.println(vector2);
        Problema4 rez = new Problema4();
        Vector reunire = rez.reunion(vector1, vector2);
        Vector intersectie = rez.intersection(vector1, vector2);
        Vector dif = rez.diferenta(vector1, vector2);
        System.out.println(reunire);
        System.out.println(intersectie);
        System.out.println(dif);
    }
}
