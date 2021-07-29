package com.company;

public class Fractie {
    int numarator, numitor;
    public Fractie(int numarator, int numitor) {
        this.numarator = numarator;
        this.numitor = numitor;
    }

    public Fractie() {
        this(1, 1);
    }

    int cmmdc(int a, int b)  {
        while (a != b) {
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    Fractie suma(Fractie x) {
        Fractie f = new Fractie();
        int baza = this.numitor * x.numitor / cmmdc(this.numitor, x.numitor);
        f.numarator = (this.numarator * baza) / this.numitor +
                (x.numarator * baza) / x.numitor;
        f.numitor = baza;
        return f;
    }

    public String toString() {
        return this.numarator + " / " + this.numitor;
    }

    boolean equals(Fractie f) {
        if(numarator * f.numitor == numitor * f.numarator)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Fractie f1 = new Fractie(2, 5);
        Fractie f2 = new Fractie(5,6);
        System.out.println(f1.suma(f2));
    }
}
