/**
 * author pawelstradomski
 */
package jcheckbox.polewyboru;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JCheckBoxPoleWyboru extends JFrame
{
    JCheckBoxPoleWyboru()
    {
        this.setTitle("Pole wyboru - JCheckBox");
        this.setBounds(600, 300, 400, 300);
        initComponent();
        this.setDefaultCloseOperation(3);
    }
    public void initComponent()
    {
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        panel1.add(pogrubiony);
        panel1.add(pochylony);
        panel2.add(etykieta);
        etykieta.setText("Tak dziala zmiana nazwy etykiety");
        
        ActionListener sluchacz = new CheckBoxHandler();
        pogrubiony.addActionListener(sluchacz);
        pochylony.addActionListener(sluchacz);
        
        etykieta.setFont(new Font("Monospaced", Font.PLAIN, 15));
    }
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel etykieta = new JLabel("Tak dziala pole wyboru");
    JCheckBox pogrubiony = new JCheckBox("pogrubiony");
    JCheckBox pochylony = new JCheckBox("pochylony");
    
    public class CheckBoxHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            int style = Font.PLAIN;
            if(pogrubiony.isSelected()) 
                style += Font.BOLD;
            if(pochylony.isSelected())
                style += Font.ITALIC;
            etykieta.setFont(new Font(etykieta.getFont().getFamily(), style, etykieta.getFont().getSize()));
        }
        
    }
    public static void main(String[] args) {
        new JCheckBoxPoleWyboru().setVisible(true);
    }
    
}
