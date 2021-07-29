import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Problema2 extends JFrame implements ActionListener {
    JButton button;
    JTextField question;
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton r3;
    JRadioButton r4;

   public Problema2(String text) {
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
       add(question);

       r1 = new JRadioButton(v.get(1));
       r2 = new JRadioButton(v.get(2));
       r3 = new JRadioButton(v.get(3));
       r4 = new JRadioButton(v.get(4));

       r1.addActionListener(this);
       r2.addActionListener(this);
       r3.addActionListener(this);
       r4.addActionListener(this);

       ButtonGroup group = new ButtonGroup();
       group.add(r1);
       group.add(r2);
       group.add(r3);
       group.add(r4);

       add(r1);
       add(r2);
       add(r3);
       add(r4);

       button = new JButton("Apasa");
       button.addActionListener(this);
       button.setEnabled(false);
       add(button);

       show();
       pack();
   }

    public static void main(String[] args) {
        Problema2 p = new Problema2("Laborator");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JRadioButton ) {
            button.setEnabled(true);
        } else if(e.getSource() instanceof JButton) {
            if (r1.isSelected()) {
                r1.setForeground(Color.green);
            } else {
                r1.setForeground(Color.red);
            }
        }
    }
}
