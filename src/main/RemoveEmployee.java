package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener{
	
	Choice cEmpId;
	JButton delete, back;
	
	RemoveEmployee() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		// Fixed employee Id from database
		JLabel lblempId = new JLabel("Employee Id");
		lblempId.setBounds(50, 50, 100, 30);
		add(lblempId);
		
		cEmpId = new Choice();
		cEmpId.setBounds(200, 50, 150, 30);
		add(cEmpId);
		
		try {
			Conn c = new Conn();
			String query = "select * from employee";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				cEmpId.add(rs.getString("empId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Employee Information
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 100, 100, 30);
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200, 100, 100, 30);
		add(lblname);
		
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(50, 150, 100, 30);
		add(labelphone);
		
		JLabel lblphone = new JLabel();
		lblphone.setBounds(200, 150, 100, 30);
		add(lblphone);
		
		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50, 200, 100, 30);
		add(labelemail);
		
		JLabel lblemail = new JLabel();
		lblemail.setBounds(200, 200, 100, 30);
		add(lblemail);
		
		// Fetching Employee Information from database
		try {
			Conn c = new Conn();
			String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				lblname.setText(rs.getString("name"));
				lblphone.setText(rs.getString("phone"));
				lblemail.setText(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cEmpId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				try {
					Conn c = new Conn();
					String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while (rs.next()) {
						lblname.setText(rs.getString("name"));
						lblphone.setText(rs.getString("phone"));
						lblemail.setText(rs.getString("email"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Delete employee button
		delete = new JButton("Delete");
		delete.setBounds(80,300, 100, 30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);
		
		// Back button
		back = new JButton("back");
		back.setBounds(220,300, 100, 30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		// Background Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
		
		setSize(1000, 400);
		setLocation(300, 150);
		setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		// If delete button is clicked, delete employee information from database
		if (ae.getSource() == delete) {
			try {
				Conn c = new Conn();
				String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
				setVisible(false);
				new Home();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			// If back button is clicked, go back to Home page
		} else if (ae.getSource() == back) {
			setVisible(false);
			new Home();
		}
	}
		

	public static void main(String[] args) {
		new RemoveEmployee();

	}

}