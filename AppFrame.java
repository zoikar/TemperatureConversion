import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class AppFrame extends JFrame{
    public AppFrame(){
        initComp();
    }

    public void initComp(){
        JComboBox<String> jComboBox1 = new JComboBox<>(optionsToChoose1);
        jComboBox1.setBounds(80, 50, 140, 20);
        JComboBox<String> jComboBox2 = new JComboBox<>(optionsToChoose1);
        jComboBox2.setBounds(80, 50, 140, 20);
        ml = new JLabel("Type the degrees and click on convert", SwingConstants.CENTER);
        conv = new JLabel();
        tf = new JTextField();
        convert = new JButton("Convert");
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t = tf.getText().toString();
                if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == jComboBox2.getItemAt(jComboBox2.getSelectedIndex())){
                    conv.setText("Wrong. Choose again");
                }else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == "Kelvin" && jComboBox2.getItemAt(jComboBox2.getSelectedIndex()) == "Celcius"){
                    double x = Double.parseDouble(t);
                    double y = (x - 273.15);
                    conv.setText(y+"C");
                }else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == "Kelvin" && jComboBox2.getItemAt(jComboBox2.getSelectedIndex()) == "Farenheit"){
                    double x = Double.parseDouble(t);
                    double y = ((x - 273.15) * 9/5 + 32);
                    conv.setText(y+"F");
                }else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == "Celcius" && jComboBox2.getItemAt(jComboBox2.getSelectedIndex()) == "Farenheit"){
                    double x = Double.parseDouble(t);
                    double y = (x * 9/5) + 32;
                    conv.setText(y+"F");
                }else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == "Celcius" && jComboBox2.getItemAt(jComboBox2.getSelectedIndex()) == "Kelvin"){
                    double x = Double.parseDouble(t);
                    double y = x + 273.15;
                    conv.setText(y+"K");
                }else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == "Farenheit" && jComboBox2.getItemAt(jComboBox2.getSelectedIndex()) == "Kelvin"){
                    double x = Double.parseDouble(t);
                    double y = (x - 32) * 5/9 + 273.15;
                    conv.setText(y+"K");
                }else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()) == "Farenheit" && jComboBox2.getItemAt(jComboBox2.getSelectedIndex()) == "Celcius"){
                    double x = Double.parseDouble(t);
                    double y = (x - 32) * 5/9;
                    conv.setText(y+"C");
                }
            }
        }); 
        p = new JPanel(new GridLayout(2,2));
        p.add(jComboBox1);
        p.add(tf);
        p.add(jComboBox2);
        p.add(convert);

        add(ml, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(conv, BorderLayout.SOUTH);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args){
        new AppFrame().setVisible(true);
    }

    private JPanel p;
    private JLabel ml, conv;
    private JTextField tf;
    private JButton convert;
    private String t;
    String[] optionsToChoose1 = {"Celcius", "Kelvin", "Farenheit"};
}
