import java.util.*;

abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
    public abstract AMatrix<T> addition(AMatrix<T> m1);

    //Aduna doua elemente de tip T si intoarce rezultatul
    public abstract T sum(T obj1, T obj2);
}

class IntegerMatrix extends AMatrix<Integer> {
    @Override
    public AMatrix<Integer> addition(AMatrix<Integer> m1) {
        //IntegerMatrix sum = new IntegerMatrix();
        for(int i = 0; i < this.size(); i++)
            for(int j = 0; j < this.size(); j++) {
                this.get(i).set(j, sum(this.get(i).get(j), m1.get(i).get(j)));
            }
        return this;
    }

    @Override
    public Integer sum(Integer obj1, Integer obj2) {
        return obj1 + obj2;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        this.forEach(arrayL -> {arrayL.forEach(array -> { result.append(array).append(" ");}); result.append("\n");});
        return result.toString();
    }
}

class test3 {
    public static void main(String[] args) {
        IntegerMatrix matrix1 = new IntegerMatrix();
        ArrayList<Integer> list11 = new ArrayList<>();
        ArrayList<Integer> list12 = new ArrayList<>();
        list11.add(1); list11.add(2);
        list12.add(3); list12.add(4);
        matrix1.add(list11);
        matrix1.add(list12);

        IntegerMatrix matrix2 = new IntegerMatrix();
        ArrayList<Integer> list21 = new ArrayList<>();
        ArrayList<Integer> list22 = new ArrayList<>();
        list21.add(5); list21.add(6);
        list22.add(7); list22.add(8);
        matrix2.add(list21);
        matrix2.add(list22);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix1.addition(matrix2));
    }
}