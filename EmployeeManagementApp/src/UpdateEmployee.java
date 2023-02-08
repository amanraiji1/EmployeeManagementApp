import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateEmployee extends JFrame implements ActionListener {
	
	JTextField tffname,tfaddress,tfphone,tfemail,tfsalary,tfdesignation;
	JLabel lblempId;
	JButton addButton,backButton;
	String empId;
	Choice cbdepartment,cbeducation;
	private static final long serialVersionUID = 1L;

	UpdateEmployee(String empId) {
		this.empId = empId;
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Employee Detail");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelname);
		
		JLabel lblname = new JLabel();
		lblname.setBounds(200,150,150,30);
		add(lblname);

		JLabel labelfname = new JLabel("Father's Name");
		labelfname.setBounds(400,150,150,30);
		labelfname.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelfname);
		
		tffname = new JTextField();
		tffname.setBounds(600,150,150,30);
		add(tffname);
		
		JLabel labeldob = new JLabel("Date of Birth");
		labeldob.setBounds(50,200,150,30);
		labeldob.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labeldob);
		
		JLabel lbldob = new JLabel();
		lbldob.setBounds(200,200,150,30);
		add(lbldob);
		
		JLabel labelsalary = new JLabel("Salary");
		labelsalary.setBounds(400,200,150,30);
		labelsalary.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(600,200,150,30);
		add(tfsalary);

		JLabel labeladdress = new JLabel("Address");
		labeladdress.setBounds(50,250,150,30);
		labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labeladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200,250,150,30);
		add(tfaddress);
		
		JLabel labelphone = new JLabel("Phone");
		labelphone.setBounds(400,250,150,30);
		labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600,250,150,30);
		add(tfphone);
		

		JLabel labelemail = new JLabel("Email");
		labelemail.setBounds(50,300,150,30);
		labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,300,150,30);
		add(tfemail);

		JLabel labeleducation = new JLabel("Highest Education");
		labeleducation.setBounds(400,300,150,30);
		labeleducation.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labeleducation);

		String courses[] = {"BBA","BCA","BA","BSC","BCom","B.Tech","MBA","MCA","MA","M.Tech","10th","Diploma"};
		cbeducation = new Choice();
		cbeducation.setBounds(600,300,150,30);
		for(String xString : courses)
			cbeducation.add(xString);
		add(cbeducation);
		
		
		JLabel labeldesignation = new JLabel("Designation");
		labeldesignation.setBounds(50,350,150,30);
		labeldesignation.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labeldesignation);
		
		tfdesignation = new JTextField();
		tfdesignation.setBounds(200,350,150,30);
		add(tfdesignation);
		
		JLabel labelaadhar = new JLabel("Aadhar Number");
		labelaadhar.setBounds(400,350,150,30);
		labelaadhar.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelaadhar);
		
		JLabel lblaadhar = new JLabel();
		lblaadhar.setBounds(600,350,150,30);
		add(lblaadhar);
		
		JLabel labelempId = new JLabel("Employee Id");
		labelempId.setBounds(50,400,150,30);
		labelempId.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelempId);
		
		lblempId = new JLabel();
		lblempId.setBounds(200,400,150,30);
		lblempId.setFont(new Font("SERIF",Font.PLAIN,20));
		add(lblempId);
		
		JLabel labelDepartment = new JLabel("Department");
		labelDepartment.setBounds(400,400,150,30);
		labelDepartment.setFont(new Font("SERIF",Font.PLAIN,20));
		add(labelDepartment);
		
		cbdepartment = new Choice();
		cbdepartment.setBackground(Color.WHITE);
		cbdepartment.setBounds(600,400,150,30);
		add(cbdepartment);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from department");
			
			while(rs.next()) {
				cbdepartment.add(rs.getString("dname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//fetch data for selected employeeId
		try {
			Conn c = new Conn();
			String query = "select * from employee where empId = '"+ empId + "'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				lblname.setText(rs.getString("name"));
				tffname.setText(rs.getString("fname"));
				lbldob.setText(rs.getString("dob"));
				tfaddress.setText(rs.getString("address"));
				tfsalary.setText(rs.getString("salary"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				tfdesignation.setText(rs.getString("designation"));
				lblaadhar.setText(rs.getString("aadhar"));
				lblempId.setText(rs.getString("empId"));
				cbeducation.select(rs.getString("education"));
				cbdepartment.select(rs.getString("selectedDept"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		addButton = new JButton("Update Details");
		addButton.setBounds(250,550,150,40);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.WHITE);
		addButton.addActionListener(this);
		add(addButton);

		backButton = new JButton("Back");
		backButton.setBounds(450,550,150,40);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		backButton.addActionListener(this);
		add(backButton);
		
		setSize(900,700);
		setLocation(250,30);
		setUndecorated(true);//to remove title bar from frame
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			String fname = tffname.getText();
			String salary = tfsalary.getText();
			String phone = tfphone.getText();
			String designation = tfdesignation.getText();
			String address = tfaddress.getText();
			String email = tfemail.getText();
			String education = cbeducation.getSelectedItem();
			String department = cbdepartment.getSelectedItem(); 
			
			if(fname.length() > 0 && salary.length() > 0 && phone.length() > 0 && designation.length() > 0 && address.length() > 0 && email.length() > 0 && education.length() > 0) {
				try {
					Conn con = new Conn();
					String query = "update employee set fname = '"+ fname +"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"',education = '"+education+"', designation = '"+designation+"', selectedDept = '"+ department +"' where empId = '"+ empId + "'";
	                con.s.executeUpdate(query);
	                JOptionPane.showMessageDialog(null, "Detail updated successfully...");
	                setVisible(false);
	                new Home();
				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill all fields");
			}
		}
		else {
			//To go back to home menu
			setVisible(false);
			new Home();
		}
	}
	
}
