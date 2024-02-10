package main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	JButton view, add, update, remove;

	Home () {
		
		setLayout(null);
		
		// Background Image
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/homeScreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        // Heading label
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(110, 20, 500, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        // Add employee button
        add = new JButton("Add Employee");
        add.setBounds(150, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        // View employee button
        view = new JButton("View Employees");
        view.setBounds(320, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        // Update employee button
        update = new JButton("Update Employee");
        update.setBounds(150, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        // Remove employee button
        remove = new JButton("Remove Employee");
        remove.setBounds(320, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);
		
		setSize(1120, 630);
		setLocation(250, 100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		// If add button is clicked, open AddEmployee page
		if (ae.getSource() == add) {
			setVisible(false);
			new AddEmployee();
			
			// If view button is clicked, open ViewEmployee page
		} else if (ae.getSource() == view) {
			setVisible(false);
			new ViewEmployee();
			
			// If update button is clicked, open UpdateEmployee page
		} else if (ae.getSource() == update) {
			setVisible(false);
			new ViewEmployee();
			
			// If remove button is clicked, open RemoveEmployee page
		} else if (ae.getSource() == remove){
			setVisible(false);
			new RemoveEmployee();
		}
	}
	
	
	
	public static void main(String args[]) {
		new Home();
	}
}