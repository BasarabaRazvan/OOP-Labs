import java.util.*;

class ArrayMap<K,V> extends AbstractMap<K,V> {
    ArrayList<ArrayMapEntry<K,V>> list;

    public ArrayMap() {
        list = new ArrayList<>();
    }

    class ArrayMapEntry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        public ArrayMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        public String toString() {
            return getKey() + " " + getValue();
        }

        public boolean equals(Object o) {
            ArrayMapEntry array = (ArrayMapEntry)o;
            if(getKey().equals(array.getKey()) && getValue().equals(array.getValue()))
                return true;
            return false;
        }
        public int hashCode() {
            return (getKey()==null   ? 0 : getKey().hashCode()) ^
                    (getValue()==null ? 0 : getValue().hashCode());
        }
    }

    public Set entrySet() {
        HashSet<Entry<K, V>> set = new HashSet<>(list);
        return set;
    }

    public int size() {
        return list.size();
    }

    public V put(K key, V value) {
        V old = value;
        for(Entry<K, V> i : list) {
            if(key.equals(i.getKey())) {
                return i.setValue((V)value);
            }
        }
        list.add(new ArrayMapEntry<K, V>(key, value));
        return old;
    }

    public String toString() {
        String result = "\n";
        Iterator<ArrayMapEntry<K, V>> it = list.iterator();
        while (it.hasNext()) {
            ArrayMapEntry<K,V> k = it.next();
            result += "" + k + "\n";
        }
        return result;
    }
}

class Task1 {
    public static void main(String args[]) {
        ArrayMap<Integer, String> map = new ArrayMap<>();

        System.out.println("Populam colectia...");
        map.put(7, "Colectii si genericitate");
        map.put(8, "Clase interne");
        map.put(5, "Fluxuri");

        System.out.println("Verificam...");
        System.out.println("Continutul colectiei: " + map);

        if (map.size() != 3) {
            System.err.println("ArrayMap.size() (" + map.size() + ") a fost implementata gresit.");
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        if (entries.size() != 3) {
            System.err.println("ArrayMap.entrySet() a fost implementata gresit.");
        }

        for (Map.Entry<Integer, String> e : entries) {
            map.put(e.getKey(), new StringBuffer(e.getValue()).reverse().toString());
            if (!map.entrySet().contains(e)) {
                System.err.println("ArrayMap.put() nu inlocuieste vechea valoare.");
            }
            if ((!e.toString().contains(e.getKey().toString()) || (!e.toString().contains(e.getValue())))) {
                System.err.println("ArrayMap.ArrayMapEntry.toString() a fost implementata gresit.");
            }
        }

        for (Map.Entry<Integer, String> e1 : entries) {
            for (Map.Entry<Integer, String> e2 : entries) {
                if ((e1 == e2) != (e1.equals(e2))) {
                    System.err.println("ArrayMap.ArrayMapEntry.equals() a fost implementata gresit.");
                }
                if ((e1 == e2) != (e1.hashCode() == e2.hashCode())) {
                    System.err.println("ArrayMap.ArrayMapEntry.hashCode() a fost implementata gresit.");
                }
            }
        }
    }
}