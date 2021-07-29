import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prob1 extends JFrame implements ActionListener {
    private JTextField disc;
    private JTextField path;
    private JTextField file;
    private JTextField allPath;
    private JButton button;

    public Prob1(String text) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.blue);
        setLayout(new FlowLayout());
        disc = new JTextField(25);
        path = new JTextField(25);
        file = new JTextField(25);
        allPath = new JTextField(25);

        disc.addActionListener(this);
        path.addActionListener(this);
        file.addActionListener(this);


        add(disc);
        add(path);
        add(file);
        add(allPath);

        show();
        pack();
    }

    public static void main (String args[]) {
        Prob1 b = new Prob1 ("LaboratorPOO");
    }

    public void actionPerformed(ActionEvent e) {
        allPath.setText(disc.getText() + "/" + path.getText() + "/" + file.getText());
    }
}
