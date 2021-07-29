import java.util.*;

class ArrayMap<K, V> extends AbstractMap<K, V> {
    private Vector<K> keyVec;
    private Vector<V> valueVec;

    public ArrayMap() {
        keyVec = new Vector<K>();
        valueVec = new Vector<V>();
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

    public String toString() {
        String result = "";
        for(int i = 0 ;i < keyVec.size(); i++) {
            result += keyVec.get(i) + " " + valueVec.get(i) + "\n";
        }
        return result;
    }

    public V put(K key, V val) {
        V old = val;
        if (keyVec.contains(key)) {
            int index = keyVec.indexOf(key);
            old = valueVec.get(index);
            valueVec.set(index, val);
        } else {
            keyVec.add(key);
            valueVec.add(val);
        }
        return old;
    }

    @Override
    public V get(Object key) {
        if(keyVec.contains(key)) {
            int i = keyVec.indexOf(key);
            return valueVec.get(i);
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keyVec);
    }

    @Override
    public Collection<V> values() {
        return new ArrayList<>(valueVec);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        HashSet<Map.Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < valueVec.size(); i++) {
            set.add(new ArrayMapEntry<>(keyVec.get(i), valueVec.get(i)));
        }
        return set;
    }
}

class test2 {
    public static void main(String[] args) {
        ArrayMap<Integer, String> map = new ArrayMap<>();
        map.put(1, "Ana");
        map.put(4, "are");
        map.put(3, "mere");
        map.put(3, "pere");
        System.out.println(map);
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        System.out.println(set);
    }
}
