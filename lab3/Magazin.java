package com.company;

import java.sql.SQLOutput;

public class Magazin {
    String name;
    Produs p1, p2, p3;
    public Magazin(String name, Produs p1, Produs p2, Produs p3) {
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public String toString() {
        return "Magazin " + " " + this.name +" "+ this.p1 +" "+ this.p2 +" "+  this.p3;
    }
    double getTotalMagazin() {
        return this.p1.getTotalProdus() + this.p2.getTotalProdus() + this.p3.getTotalProdus();
    }
    public static void main(String[] args) {
        Produs proteina = new Produs("Proteina", 50, 5);
        Produs creatina = new Produs("Creatina", 25, 10);
        Produs vitamine = new Produs("Vitamine", 90, 22);
        Magazin prot = new Magazin("Prot", proteina, creatina, vitamine);

        System.out.println(prot);
        System.out.println(prot.getTotalMagazin());
    }
}
