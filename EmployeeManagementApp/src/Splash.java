import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public Splash() {
		getContentPane().setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel heading = new JLabel("EMPLOYEE MANAGEMENT APP");
		heading.setBounds(160, 20, 1200, 60);
		heading.setFont(new Font("serif",Font.PLAIN,60));
		heading.setForeground(Color.RED);
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);//for scaling this is required
		ImageIcon i3= new ImageIcon(i2);//we have to add Jlabel and it only accepts Imageicon
		JLabel image = new JLabel(i3);
		image.setBounds(70,100,1050,600);
		add(image);
		
		JButton clickHere = new JButton("Continue");
		clickHere.setBounds(400,420,150,70);
		clickHere.setBorder(null);
		clickHere.setBackground(Color.black);
		clickHere.setForeground(Color.white);
		clickHere.addActionListener(this);//Event of click
		image.add(clickHere);
		
		setSize(1170,650);
		setLocation(150, 50);
		setUndecorated(true);//to remove title bar from frame
		setVisible(true);
		getRootPane().setDefaultButton(clickHere);//to submit on pressing ENTER
		//For Blinking the heading
		while(true) {
			heading.setVisible(true);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			
			}

			heading.setVisible(false);
			try {
				Thread.sleep(500);
			} catch (Exception e) {

			}
		}
	}
	public static void main(String[] args) {
		new Splash();
	}

	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();
	}

}
