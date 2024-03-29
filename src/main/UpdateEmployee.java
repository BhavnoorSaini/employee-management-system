package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
	
	JTextField tfeducation, tffname, tfaddress, tfssn, tfphone, tfemail, tfsalary, tfdesignation;
	JLabel lblempId;
	JButton add, back;
	String empId;
	
	UpdateEmployee(String empId) {
		this.empId = empId;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		// Heading
		JLabel heading = new JLabel("Update Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
		add(heading);
		
		// Name label and textfield
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200, 150, 150, 30);
		add(lblname);
		
		// Father's Name label and textfield
		JLabel labelfname = new JLabel("Father's Name");
		labelfname.setBounds(400, 150, 150, 30);
		labelfname.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelfname);
		
		tffname = new JTextField();
		tffname.setBounds(600, 150, 150, 30);
		add(tffname);
		
		// Date of Birth label
		JLabel labeldob = new JLabel("Date of Birth");
		labeldob.setBounds(50, 200, 150, 30);
		labeldob.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldob);
		
		JLabel lbldob = new JLabel();
		lbldob.setBounds(200, 200, 150, 30);
		add(lbldob);
		
		// Salary label and textfield
		JLabel labelsalary = new JLabel("Salary");
		labelsalary.setBounds(400, 200, 150, 30);
		labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(600, 200, 150, 30);
		add(tfsalary);
		
		// Address label and textfield
		JLabel labeladdress = new JLabel("Address");
		labeladdress.setBounds(50, 250, 150, 30);
		labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250, 150, 30);
		add(tfaddress);
		
		// Phone label and textfield
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(400, 250, 150, 30);
		labelphone.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250, 150, 30);
		add(tfphone);
		
		// Email label and textfield
		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50, 300, 150, 30);
		labelemail.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 300, 150, 30);
		add(tfemail);
		
		// Highest Education label and textfield
		JLabel labeleducation = new JLabel("Highest Education");
		labeleducation.setBounds(400, 300, 150, 30);
		labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeleducation);
		
		tfeducation = new JTextField();
		tfeducation.setBounds(600, 300, 150, 30);
		add(tfeducation);
		
		// Designation label and textfield
		JLabel labeldesignation = new JLabel("Designation");
		labeldesignation.setBounds(50, 350, 150, 30);
		labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
		add(labeldesignation);
		
		tfdesignation = new JTextField();
		tfdesignation.setBounds(200, 350, 150, 30);
		add(tfdesignation);
		
		// SSN label
		JLabel labelssn = new JLabel("SSN");
		labelssn.setBounds(400, 350, 150, 30);
		labelssn.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelssn);
		
		JLabel lblssn = new JLabel();
		lblssn.setBounds(600, 350, 150, 30);
		add(lblssn);
		
		// Employee ID label and textfield
		JLabel labelempId = new JLabel("Employee ID");
		labelempId.setBounds(50, 400, 150, 30);
		labelempId.setFont(new Font("serif", Font.PLAIN, 20));
		add(labelempId);
		
		lblempId = new JLabel();
		lblempId.setBounds(200, 400, 150, 30);
		lblempId.setFont(new Font("serif", Font.PLAIN, 20));
		add(lblempId);
		
		// Fetching employee data from database
		try {
			Conn c = new Conn();
			String query = "select * from employee where empId = '"+empId+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				tffname.setText(rs.getString("fname"));
				lbldob.setText(rs.getString("dob"));
				tfaddress.setText(rs.getString("address"));
				tfsalary.setText(rs.getString("salary"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				tfeducation.setText(rs.getString("education"));
				lblssn.setText(rs.getString("ssn"));
				lblempId.setText(rs.getString("empId"));
				tfdesignation.setText(rs.getString("designation"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Update Button
		add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        // Back Button
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
		
		
			
		setSize(900, 700);
		setLocation(300, 50);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		// If add button is clicked, update employee details
		if (ae.getSource() == add) {
			String fname = tffname.getText();
			String salary = tfsalary.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String education = tfeducation.getText();
			String designation = tfdesignation.getText();
			
			try {
				Conn conn = new Conn();
				String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Updated Successfully");
				setVisible(false);
				new Home();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// If back button is clicked, go back to home
		} else  if (ae.getSource() == back) {
			setVisible(false);
			new Home();
		}
	}

	
	public static void main(String args[]) {
		new UpdateEmployee("");
	}
}
