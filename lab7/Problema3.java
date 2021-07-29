import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SListSet extends LinkedList implements SortedSet {

    Comparator cmp;

    public SListSet() {
       // super();
        cmp = null;
    }

    public SListSet(Comparator cmp) {
        this.cmp = cmp;
    }

    @Override
    public Comparator comparator() {
        return cmp;
    }

    public boolean add(Object o) {
        if(contains(o))
            return false;
        super.add(o);
        Collections.sort(this, cmp);
        return true;
    }

    @Override
    public SortedSet subSet(Object fromElement, Object toElement) {
        SortedSet n = new SListSet();
        if(contains(fromElement) && contains(toElement)) {
            int start = indexOf(fromElement);
            int end = indexOf(toElement);
            for(int i = start; i < end; i++) {
                n.add(get(i));
            }
            return n;
        }
        return null;
    }

    @Override
    public SortedSet headSet(Object toElement) {
        if(contains(toElement))
            return subSet(first(), toElement);
        return null;
    }

    @Override
    public SortedSet tailSet(Object fromElement) {
        if(contains(fromElement))
            return subSet(fromElement, last());
        return null;
    }

    @Override
    public Object first() {
        if (size() == 0)
            return null;
        return getFirst();
    }

    @Override
    public Object last() {
        if (size() == 0)
            return null;
        return getLast();
    }
}

class test3 {
    public static void main(String[] args) {
        SListSet t = new SListSet();
        try {
            File f = new File("/home/razvan/Desktop/test01.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                StringTokenizer token = new StringTokenizer(sc.nextLine(), " 1234567890][(){};'.+/<>=,:!?*-\n\t\"");
                while (token.hasMoreTokens())
                    t.add(token.nextToken());
            }
            System.out.println(t);
        } catch (FileNotFoundException e) {
            System.out.println("Nu s a putut deschide fisierul.");
        }
    }
}
