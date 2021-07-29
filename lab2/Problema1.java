package com.company;

class Problema1 {
    public static void main(String[] args) {
        ///metoda indexOf
        String s1 = "si";
        String s = "sir1 si cu sir2 fac un sir3";
        int poz = s.indexOf(s1);
        if (poz == -1) {
            System.out.println("Sirul 1 nu se afla in sirul 2");
            return;
        }
        int number = 1;
        while (s.indexOf(s1, poz + 1) != -1) {
            number++;
            poz = s.indexOf(s1, poz + 1);
        }
        System.out.println("Numarul de aparitii este: " + number);
    }
}
