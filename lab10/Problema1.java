import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Problema1 extends JFrame implements ActionListener {
    private JTextField disc;
    private JTextField path;
    private JTextField file;
    private JTextField allPath;
    private JButton button;

    public Problema1(String text) {
        super(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.blue);
        setLayout(new FlowLayout());
        button = new JButton("Apasa");
        button.addActionListener(this);
        add(button);
        disc = new JTextField(25);
        add(disc);
        path = new JTextField(25);
        add(path);
        file = new JTextField(25);
        add(file);
        allPath = new JTextField(25);
        add(allPath);

        show();
        pack();
    }

    public static void main (String args[]) {
        Problema1 b = new Problema1 ("LaboratorPOO");
    }

    @Override
    public void actionPerformed(ActionEvent e){
            allPath.setText(disc.getText() + path.getText() + "/" + file.getText());
    }
}
