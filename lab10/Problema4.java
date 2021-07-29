import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Problema4 extends JFrame implements ChangeListener {
    JSlider red;
    JSlider green;
    JSlider blue;
    JTextField field;

    public Problema4(String title) {
        super(title);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        getContentPane().setBackground(Color.blue);
        setLayout(new FlowLayout());

        red = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        green = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        blue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        red.addChangeListener(this);
        green.addChangeListener(this);
        blue.addChangeListener(this);

        add(red);
        add(green);
        add(blue);

        field = new JTextField();
        field.setEnabled(false);
        add(field);

        show();
        pack();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        String count = Integer.toHexString(red.getValue()) + Integer.toHexString(green.getValue())
                + Integer.toHexString(blue.getValue());
        field.setText(count);
        field.setBackground(Color.decode("#" + count));
    }
    public static void main(String[] args) {
        Problema4 test = new Problema4("Laborator");
    }

}