import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

import net.proteanit.sql.DbUtils;//To fill table

public class ViewEmployee extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JTable table;
	Choice cemployeeId;
	JButton searchButton,updateButton,printButton,backButton;
	
	
	ViewEmployee() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		//For search
		JLabel searchlbl = new JLabel("Search by Employee Id");
		searchlbl.setBounds(20,20,150,20);
		add(searchlbl);
		
		cemployeeId = new Choice();
		cemployeeId.setBounds(180,20,150,20);
		add(cemployeeId);
		
		try {
			//for filling search dropdown
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from employee order by empId");
			while(rs.next()) {
				cemployeeId.add(rs.getString("empId"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(
					"select empId as ID,name as 'Name',department.dname as 'Department',designation as 'Designation',email as 'Email',phone as 'Contact',salary as 'Salary',dob as 'D.O.B.',fname as 'Fathers Name',address as'Address',education as 'Qualification',aadhar as 'Aadhar No.',department.dlocation as 'Location' from employee join department on employee.selectedDept = department.dname  order by empId");
			table.setModel(DbUtils.resultSetToTableModel(rs));//fill table 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//for scrollbar in table
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0,100,1100,600);
		add(jsp);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(20,70,80,20);
		searchButton.addActionListener(this);
		add(searchButton);

		printButton = new JButton("Print");
		printButton.setBounds(120,70,80,20);
		printButton.addActionListener(this);
		add(printButton);

		updateButton = new JButton("Update");
		updateButton.setBounds(220,70,80,20);
		updateButton.addActionListener(this);
		add(updateButton);

		backButton = new JButton("Back");
		backButton.setBounds(320,70,80,20);
		backButton.addActionListener(this);
		add(backButton);
		
		setSize(1100,700);
		setLocation(150,30);
		setUndecorated(true);//to remove title bar from frame
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchButton) {
			
			String query = "select empId as ID,name as 'Name',department.dname as 'Department',designation as 'Designation',email as 'Email',phone as 'Contact',salary as 'Salary',dob as 'D.O.B.',fname as 'Fathers Name',address as'Address',education as 'Qualification',aadhar as 'Aadhar No.',department.dlocation as 'Location' from employee join department on employee.selectedDept = department.dname where empId = '" + cemployeeId.getSelectedItem() + "';";
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		else if(e.getSource() == printButton){
			
			try {
				table.print();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		else if(e.getSource() == updateButton) {
			//We want that whichever empid is selected by user the details of that employee will be already filled so we pass id
			setVisible(false);
			new UpdateEmployee(cemployeeId.getSelectedItem());
		}
		else {
			setVisible(false);
			new Home();
		}
		
	}

}
