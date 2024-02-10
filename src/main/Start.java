package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JFrame implements ActionListener {
    
    Start() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Heading
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        // Click here button
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 300, 60);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
        // This is a thread to display the heading in blinking mode
        while(true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
            
            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                
            }
        }
    }
    
    // Opens the login page when button is clicked
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]) {
        new Start();
	}
}
