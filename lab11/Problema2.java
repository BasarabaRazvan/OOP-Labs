import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Problema2 extends JFrame implements ListSelectionListener {
    JList<Book> list;
    JTextField titlu;
    JTextField autor;
    JLabel t;
    JLabel a;
    JPanel p;

    public Problema2(String text, DefaultListModel<Book> books) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground (Color.white);
        setLayout(new FlowLayout());

        p = new JPanel();
        titlu = new JTextField("",25);
        autor = new JTextField("",25);
        t = new JLabel("Titlu: ");
        a = new JLabel("Autor: ");
        p.add(t);
        p.add(titlu);
        p.add(a);
        p.add(autor);

        list = new JList(books);
        JScrollPane sc = new JScrollPane(list);
        list.addListSelectionListener(this);

        add(sc);
        add(p);

        show();
        pack();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(list.isSelectionEmpty())
            return;
        Book b = (Book) list.getSelectedValue();
        titlu.setText(b.getName());
        autor.setText(b.getAuthor());
    }

    public static void main(String[] args) {
        DefaultListModel<Book> books = new DefaultListModel<>();

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

        books.addElement(b1);
        books.addElement(b2);
        books.addElement(b3);
        books.addElement(b4);
        books.addElement(b5);
        books.addElement(b6);
        books.addElement(b7);
        books.addElement(b8);
        books.addElement(b9);
        books.addElement(b10);

        Problema2 p = new Problema2("Lab11",books);
    }

}
