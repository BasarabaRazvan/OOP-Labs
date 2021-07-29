import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class NumarNegativ extends Exception {
    public NumarNegativ() {
        System.out.println("Numarul introdus este negativ!");
    }
}
public class prob3 {
    Scanner scanner;
    Vector v;

    public prob3() {
        scanner = new Scanner(System.in);
        v = new Vector();
    }

    public void myRead() throws NumarNegativ {
        int nr = scanner.nextInt();
        while (nr >= 0)
        {
            v.add(nr);
            nr = scanner.nextInt();
        }
        if(nr < 0)
            throw new NumarNegativ();
    }
    public static void main(String[] args) {
        prob3 p = new prob3();
        try {
            p.myRead();
        }
        catch (NumarNegativ neg) {
            System.out.println();
        } finally {
            System.out.println(Collections.max(p.v));
        }
    }
}
