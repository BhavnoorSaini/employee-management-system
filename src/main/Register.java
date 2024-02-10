package main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	
	JTextField tfusername, tfpassword;
	JButton back, register;
    
    Register() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbltitle = new JLabel("Register New Account");
        lbltitle.setBounds(160, 20, 130, 30);
        add(lbltitle);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 60, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 60, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 100, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 100, 150, 30);
        add(tfpassword);
        
        back = new JButton("RETURN");
        back.setBounds(150, 180, 150, 30); 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        register = new JButton("REGISTER");
        register.setBounds(150, 140, 150, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true); 
        }
	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == register) {
			String username = tfusername.getText();
			String password = tfpassword.getText();
			
			try {
				Conn conn = new Conn();
				String query = "insert into login values('"+username+"', '"+password+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Added Successfully");
				setVisible(false);
				new Login();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} else  if (ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}
	
	
	
	

	public static void main(String[] args) {
		new Register();

	}

}