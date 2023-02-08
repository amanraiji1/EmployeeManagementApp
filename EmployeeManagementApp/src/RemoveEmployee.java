import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	Choice cEmpId;
	JButton deleteButton, backButton;
	RemoveEmployee() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50,50,100,30);
		add(labelempId);
		
		cEmpId = new Choice();
		cEmpId.setBounds(200,50,150,30);
		add(cEmpId);
		
		try {
			Conn c = new Conn();
			String query = "select * from employee";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				cEmpId.add(rs.getString("empId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50,100,100,30);
		add(labelname);
		
		JLabel lblname = new JLabel("");
		lblname.setBounds(200,100,100,30);
		add(lblname);

		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(50,150,100,30);
		add(labelphone);
		
		JLabel lblphone = new JLabel("");
		lblphone.setBounds(200,150,100,30);
		add(lblphone);

		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50,200,100,30);
		add(labelemail);
		
		JLabel lblemail = new JLabel("");
		lblemail.setBounds(200,200,100,30);
		add(lblemail);
		

		try {
			Conn c = new Conn();
			String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				lblemail.setText(rs.getString("email"));
				lblphone.setText(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cEmpId.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Conn c = new Conn();
					String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()) {
						lblname.setText(rs.getString("name"));
						lblemail.setText(rs.getString("email"));
						lblphone.setText(rs.getString("phone"));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(80,300,100,30);
		deleteButton.setBackground(Color.BLACK);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.addActionListener(this);
		add(deleteButton);

		backButton = new JButton("Back");
		backButton.setBounds(220,300,100,30);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.addActionListener(this);
		add(backButton);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);//for scaling this is required
		ImageIcon i3= new ImageIcon(i2);//we have to add Jlabel and it only accepts Imageicon
		JLabel image = new JLabel(i3);
		image.setBounds(350,0,600,400);
		add(image);
		
		setSize(1000,400);
		setLocation(200,150);
		setUndecorated(true);//to remove title bar from frame
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deleteButton) {
			try {
				Conn c = new Conn();
				String query = "delete from employee where empId = '"+ cEmpId.getSelectedItem() + "'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee successfully deleted");
				setVisible(false);
				new Home();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new Home();
		}
		
	}
}
