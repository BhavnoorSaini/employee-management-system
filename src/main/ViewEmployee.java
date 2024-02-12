package main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
	
	JTable table;
	Choice cemployeeId;
	JButton search, print, update, back;
	
	
	ViewEmployee() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		// Background Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1050, 700);
        add(image);
		
        // Employee ID label and retrieve ID from database
		JLabel searchlbl = new JLabel("Search by Employee ID");
		searchlbl.setBounds(20, 20, 150, 20);
		image.add(searchlbl);
		
		cemployeeId = new Choice();
		cemployeeId.setBounds(180, 20, 150, 20);
		image.add(cemployeeId);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
			while (rs.next()) {
				cemployeeId.add(rs.getString("empId"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Table and Scroll Pane
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 600);
		image.add(jsp);
		
		// Search, Print, Update, Back buttons
		search = new JButton("Search");
		search.setBounds(20, 70, 80, 20);
		search.addActionListener(this);
		image.add(search);
		
		print = new JButton("Print");
		print.setBounds(120, 70, 80, 20);
		print.addActionListener(this);
		image.add(print);
		
		update = new JButton("Update");
		update.setBounds(220, 70, 80, 20);
		update.addActionListener(this);
		image.add(update);
		
		back = new JButton("Back");
		back.setBounds(320, 70, 80, 20);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 700);
		setLocation(300, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		// If search button is clicked, retrieve data from database and display in table
		if (ae.getSource() == search) {
			String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == print) {
			try {
				table.print();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// If update button is clicked, get employee ID and open update employee page
		} else if (ae.getSource() == update) {
			setVisible(false);
			new UpdateEmployee(cemployeeId.getSelectedItem());
			
			// If back button is clicked, go back to home page
		} else if (ae.getSource() == back) {
			setVisible(false);
			new Home();
		}
		
	}
	
	public static void main(String args[]) {
		new ViewEmployee();
	}

}