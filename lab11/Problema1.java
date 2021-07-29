import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Problema1 extends JFrame {
    JList<Book> list;

    public Problema1(String text, Vector<Book> books) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground (Color.white);
        setLayout(new FlowLayout());


        list = new JList(books);
        JScrollPane sc = new JScrollPane(list);

        add(sc);
        show();
        pack();
    }

    public static void main(String[] args) {
        Vector<Book> books = new Vector<>();

        Book b1 = new Book("n1","a1","icon1");
        Book b2 = new Book("n2","a2","icon2");
        Book b3 = new Book("n3","a3","icon3");
        Book b4 = new Book("n4","a4","icon4");
        Book b5 = new Book("n5","a5","icon5");
        Book b6 = new Book("n6","a6","icon6");
        Book b7 = new Book("n7","a7","icon7");
        Book b8 = new Book("n8","a8","icon8");
        Book b9 = new Book("n9","a9","icon9");
        Book b10 = new Book("n10","a10","icon10");

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);
        books.add(b9);
        books.add(b10);

        Problema1 p = new Problema1("Lab11",books);
    }
}
