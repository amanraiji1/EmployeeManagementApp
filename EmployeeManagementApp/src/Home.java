import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	JButton addButton,removeButton,updateButton,viewButton;

	Home(){
		
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);//for scaling this is required
		ImageIcon i3= new ImageIcon(i2);//we have to add Jlabel and it only accepts Imageicon
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,1120,630);
		add(image);

		JLabel heading = new JLabel("EMPLOYEE MANAGEMENT APP");
		heading.setBounds(630, 20, 400, 40);
		heading.setFont(new Font("Raleway",Font.BOLD,25));
		image.add(heading);

		addButton = new JButton("Add Employee");
		addButton.setBounds(650,80,150,40);
		addButton.addActionListener(this);
		image.add(addButton);
		
		viewButton = new JButton("View Employee");
		viewButton.setBounds(850,80,150,40);
		viewButton.addActionListener(this);
		image.add(viewButton);
		
		updateButton = new JButton("Update Employee");
		updateButton.setBounds(650,150,150,40);
		updateButton.addActionListener(this);
		image.add(updateButton);
		
		removeButton = new JButton("Remove Employee");
		removeButton.setBounds(850,150,150,40);
		removeButton.addActionListener(this);
		image.add(removeButton);
		
		setSize(1120,630);
		setLocation(150,50);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			setVisible(false);
			new AddEmployee();
		}
		else if(e.getSource() == viewButton) {
			setVisible(false);
			new ViewEmployee();
		}
		else if(e.getSource() == updateButton) {
			setVisible(false);
			new ViewEmployee();
		}
		else {
			setVisible(false);
			new RemoveEmployee();
		}
		
	}
}
