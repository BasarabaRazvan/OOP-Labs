package com.company;
import java.util.StringTokenizer;

public class Problema2 {
    public int nraparitii(String s1, String s2) {
        String token[] = s1.split( " ");
        int number = 0;
        for(int i = 0; i < token.length; i++) {
            if(s2.equals(token[i]))
                number++;
        }
        return number;
    }
    public static void main(String[] args) {
        Problema2 aparitii = new Problema2();
        //metoda split
        System.out.println(aparitii.nraparitii("sir1 si sir2 sunt 2 siruri", "sir2"));
        ///clasa stringtokenizer
        StringTokenizer st = new StringTokenizer("Marius, de ce nu l-ai ajutat pe George? Era de datoria ta sa vezi ce poti face.",
                ":,.-? ");
        int ap = 0;
        while (st.hasMoreTokens()) {
            if(st.nextToken().equals("ce"))
                ap++;
        }
        System.out.println(ap);
    }
}
