/*
 * Assignment Package
 */
package assignment;

/*
 * All used imports listed here for use in class
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/*
 * Class used for the generation and interaction of GUI
 * Contains: 
 * 		-
 * 		-
 */
public class GUI extends JFrame implements ActionListener{
	
	/*
	 * All javax.swing variables declared here
	 */
	JLabel label1, label2;
	JButton button1, button2;
	JPanel panel1, panel2;
	JTextField textfield;
	JFrame frame;
	
	/*
	 * Regular data type variables are declared here
	 */
	//String[] gender = {"<html><font size = '5'>Male", "<html><font size = '5'>Female"};
	
	/*
	 * Generation of GUI, Action Listeners...
	 */
	public GUI(String title) {
		
		super (title);
		
		JFrame frame = new JFrame();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		setVisible(true);
	//	setSize(500,500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new FlowLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		add(panel1);
		add(panel2);
		
		JLabel label1 = new JLabel("<html><font size = '4'>What is the gender of the student?</html>");
		panel1.add(label1);
		
		
		
		
//		JComboBox<String> genderBox = new JComboBox<>(gender);
//      panel2.add(genderBox);
//      genderBox.addActionListener(this);
		
		
		
		button1 = new JButton();
		panel2.add(button1);
		button1.setText("<html><font size = '4'>  Male</html>");
		button1.setToolTipText("This button generates a random number");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(100,35));
		
		button2 = new JButton();
		panel2.add(button2);
		button2.setText("<html><font size = '4'>  Female</html>");
		button2.setToolTipText("This button generates a random number");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(100,35));
		
//		JLabel label2 = new JLabel("<html><font size = '4'>Gender: </html>");
//		panel1.add(label2);
		

		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				//label2.setText("<html><font size = '4'>Gender: Male</html>");
			}
			
		}
}
