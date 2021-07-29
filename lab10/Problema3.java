import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Problema3 extends JFrame implements ActionListener, ItemListener {
    JButton button;
    JTextField question;
    JCheckBox r1;
    JCheckBox r2;
    JCheckBox r3;
    JCheckBox r4;
    int count;

    public Problema3(String text) {
        super(text);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.white);
        setLayout(new FlowLayout());

        Vector<String> v = new Vector<>();
        try {
            File f = new File("/home/razvan/Desktop/intrebare.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                v.add(sc.nextLine());
            }
        } catch (FileNotFoundException o) {
            System.out.println("Nu exista fisierul");
        }

        question = new JTextField(v.get(0));
        question.setBackground(Color.white);
        add(question);

        r1 = new JCheckBox(v.get(1));
        r2 = new JCheckBox(v.get(2));
        r3 = new JCheckBox(v.get(3));
        r4 = new JCheckBox(v.get(4));

        r1.addItemListener(this);
        r2.addItemListener(this);
        r3.addItemListener(this);
        r4.addItemListener(this);

        add(r1);
        add(r2);
        add(r3);
        add(r4);

        button = new JButton("Apasa");
        button.addActionListener(this);
        add(button);

        show();
        pack();
    }

    public static void main(String[] args) {
        Problema3 p = new Problema3("Laborator");
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
     if(e.getStateChange() == ItemEvent.SELECTED)
         count++;
     if(e.getStateChange() == ItemEvent.DESELECTED)
         count--;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            if (r1.isSelected() && r3.isSelected() && count == 2) {
                r1.setForeground(Color.green);
                r3.setForeground(Color.green);
            } else {
                r1.setForeground(Color.red);
                r3.setForeground(Color.red);
            }
        }
    }
}
