import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problema4 {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        int count = 1;
        try {
            File f = new File("/home/razvan/Desktop/test01.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                StringTokenizer token = new StringTokenizer(sc.nextLine(), " 1234567890][(){};'.+/<>=,:!?*-\n\t\"");
                while (token.hasMoreTokens()) {
                    String s = token.nextToken();
                    if(!map.containsKey(s)) {
                        LinkedList list = new LinkedList();
                        list.add(count);
                        map.put(s, list);
                    } else {
                        LinkedList list = (LinkedList) map.get(s);
                        list.add(count);
                        map.put(s, list);
                    }
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu s a putut deschide fisierul.");
        }

        for(Object entry : map.entrySet()) {
            String key = ((Map.Entry<String,LinkedList>) entry).getKey();
            LinkedList value = ((Map.Entry<String,LinkedList>) entry).getValue();

            System.out.println(key + " => " + value + " size: " + value.size());
        }
    }
}
