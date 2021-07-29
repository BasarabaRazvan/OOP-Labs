import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

class myComp implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return ((String)o2).compareTo((String)o1);
    }
}

public class Problema1 {
    public TreeSet printWords(String name) {
        TreeSet t = new TreeSet();
        try {
            File f = new File(name);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                StringTokenizer token = new StringTokenizer(sc.nextLine(), " 1234567890][(){};'.+/<>=,:!?*-\n\t\"");
                while (token.hasMoreTokens())
                    t.add(token.nextToken());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu s a putut deschide fisierul.");
        }
        return t;
    }

    public TreeSet printWordsComparator(TreeSet t) {
        TreeSet a = new TreeSet(new myComp());
        a.addAll(t);
        return a;
    }
}
class test {
    public static void main(String[] args) {
        Problema1 p1 = new Problema1();
        TreeSet t = new TreeSet();
        t = p1.printWords("/home/razvan/Desktop/test01.txt");
        TreeSet t_ordonat = new TreeSet();
        t_ordonat = p1.printWordsComparator(t);
        System.out.println(t);
        System.out.println(t_ordonat);
    }
}
