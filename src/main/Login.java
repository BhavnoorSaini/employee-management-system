package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	JTextField tfusername, tfpassword;
	JButton login, register, delete;

	Login() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		// Username label and text field
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(40, 50, 100, 30);
		add(lblusername);

		tfusername = new JTextField();
		tfusername.setBounds(150, 50, 150, 30);
		add(tfusername);

		// Password label and text field
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(40, 100, 100, 30);
		add(lblpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(150, 100, 150, 30);
		add(tfpassword);

		// Login button
		login = new JButton("LOGIN");
		login.setBounds(150, 140, 150, 30);
		login.setBackground(Color.GREEN);
		login.setForeground(Color.BLACK);
		login.addActionListener(this);
		add(login);

		// Register button
		register = new JButton("REGISTER");
		register.setBounds(150, 173, 150, 30);
		register.setBackground(Color.BLUE);
		register.setForeground(Color.BLACK);
		register.addActionListener(this);
		add(register);

		// Delete button
		delete = new JButton("Delete Account");
		delete.setBounds(150, 206, 150, 30);
		delete.setBackground(Color.RED);
		delete.setForeground(Color.BLACK);
		delete.addActionListener(this);
		add(delete);

		// Background image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 30, 200, 200);
		add(image);

		setSize(600, 300);
		setLocation(450, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		// If login button is clicked
		if (ae.getSource() == login) {
			try {
				String username = tfusername.getText();
				String password = tfpassword.getText();

				Conn c = new Conn();
				String query = "select * from login where username = '" + username + "' and password = '" + password
						+ "'";

				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Home();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		// If register button is clicked
		else if (ae.getSource() == register) {
			setVisible(false);
			new Register(); // Open register account page
		}
		
		// If delete button is clicked
		else if (ae.getSource() == delete) {
			setVisible(false);
			new Delete(); // Open delete account page
		}

	}

	public static void main(String[] args) {
		new Login();
	}
}