package main;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete extends JFrame implements ActionListener {

	JTextField tfusername, tfpassword;
	JButton back, delete;

	Delete() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lbltitle = new JLabel("Delete Account");
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

		delete = new JButton("DELETE ACCOUNT");
		delete.setBounds(150, 140, 150, 30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		add(delete);

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
		try {
			String username = tfusername.getText();
			String password = tfpassword.getText();

			Conn c = new Conn();
			String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

			ResultSet rs = c.s.executeQuery(query);
			if (rs.next()) {
				try {
					Conn cc = new Conn();
					String qquery = "delete from login where username = '" + username + "'";
					cc.s.executeUpdate(qquery);
					JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
					setVisible(false);
					new Login();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Delete();

	}

}