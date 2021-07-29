import java.util.Vector;


/**
 * Clasa folosita pentru testarea problemei 2
 * @author Nan Mihai
 */
class Graph extends MyList {
    int n;
    int[] vizited;

    public Graph(int n) {
        this.n = n;
        vizited = new int[n + 1];
        for (int i = 1; i <= n + 1; i++) {
            add(new MyList());
        }
    }

    public void add(int x, int y) {
        MyList list = (MyList) get(x);
        list.add(y);
    }

    public void dfs(int start) {
        System.out.println(start);
        vizited[start] = 1;
        MyList list = (MyList) get(start);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                int aux = (int) list.get(i);
                if (vizited[aux] == 0)
                    dfs(aux);
            }
        }
    }

    public String toString() {
        String result = "";
        for (int i = 1; i < size(); i++)
            result += i + " => " + get(i).toString() + '\n';
        return result;
    }
}

public class TestGraph {
    public static void main(String args[]) {
        Graph g = new Graph(8);
        g.add(1, 2);
        g.add(1, 5);
        g.add(1, 8);
        g.add(2, 3);
        g.add(5, 6);
        g.add(4, 2);
        g.add(6, 3);
        g.add(6, 7);
        g.add(6, 8);
        g.add(3, 4);
        System.out.println(g);
        g.dfs(1);
    }
}
