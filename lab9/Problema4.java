import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

interface GenericInterface {
    //Sterge duplicatele dintr-o lista si returneaza lista rezultata
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list);
    //Determina elementul maxim dintr-o lista
    public <E extends Comparable<E>> E max(ArrayList<E> list);
    //Cauta o valoare in lista sortata, folosind algoritmul de cautare binara si returneaza pozitia
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end);
}

class GenericListMethods implements GenericInterface {

    @Override
    public <E extends Comparable<E>> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> set = new HashSet(list);
        return new ArrayList<E>(set);
    }

    @Override
    public <E extends Comparable<E>> E max(ArrayList<E> list) {
        return Collections.max(list);
    }

    @Override
    public <E extends Comparable<E>> int binarySearch(ArrayList<E> list, E key, int start, int end) {
        if(end > start) {
            int mij = start + (end - start) / 2;
            if (list.get(mij).compareTo(key) == 0)
                return mij;
            if (list.get(mij).compareTo(key) == 1)
                return binarySearch(list, key, start, mij - 1);
            return binarySearch(list, key, mij + 1, end);
        }
        return -1;
    }
}

class test4 {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.add(1);
        array.add(22);
        array.add(7);
        array.add(9);
        array.add(7);
        array.add(3);
    }
}