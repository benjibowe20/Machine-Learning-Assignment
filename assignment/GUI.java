/*
 * Assignment Package
 */
package assignment;

/*
 * All used imports listed here for use in class
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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
	JLabel label1, label2, label3, label4, label5;
	JButton button1, button2;
	JPanel panel1, panel2, panel3, panel4;
	JTextField textfield;
	JFrame frame;
	
	/*
	 * Regular data type variables are declared here
	 */
	String[] gender = {"<html><font size = '4'>Male</html>", "<html><font size = '4'>Female</html>"};
	String[] ownBusiness = {"<html><font size = '4'>Yes</html>", "<html><font size = '4'>No</html>"};
	String[] hasJob = {"<html><font size = '4'>Yes</html>", "<html><font size = '4'>No</html>"};
	String[] urbanOrRural = {"<html><font size = '4'>Urban</html>", "<html><font size = '4'>Rural</html>"};
	String[] studiesBusiness = {"<html><font size = '4'>Yes</html>", "<html><font size = '4'>No</html>"};
	
	/*
	 * Generation of GUI, Action Listeners...
	 */
	public GUI(String title) {
		
		super (title);
		
		JFrame frame = new JFrame();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		setVisible(true);
		setSize(500,500);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new FlowLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		
//        panel1.setBounds(101, 650, 900, 50);
//        panel1.setBackground(Color.RED);
		
//		JLabel label2 = new JLabel("<html><font size = '4'>Gender: </html>");
//		panel1.add(label2);
		
		JLabel label1 = new JLabel("<html><font size = '4'>What is the gender of the student?</html>");
		panel1.add(label1);
		
		JComboBox<String> genderBox = new JComboBox<>(gender);
        panel1.add(genderBox);
        genderBox.addActionListener(this);
        
		JLabel label2 = new JLabel("<html><font size = '4'>Does student Parent own a business?</html>");
		panel2.add(label2);
		
		JComboBox<String> ownBusinessBox = new JComboBox<>(ownBusiness);
        panel2.add(ownBusinessBox);
        ownBusinessBox.addActionListener(this);
        
        JLabel label3 = new JLabel("<html><font size = '4'>Does student have a part-time job?</html>");
		panel3.add(label3);
		
		JComboBox<String> hasJobBox = new JComboBox<>(hasJob);
        panel3.add(hasJobBox);
        hasJobBox.addActionListener(this);
        
        JLabel label4 = new JLabel("<html><font size = '4'>Urban or Rural address?</html>");
		panel4.add(label4);
		
		JComboBox<String> urbanOrRuralBox = new JComboBox<>(urbanOrRural);
        panel4.add(urbanOrRuralBox);
        urbanOrRuralBox.addActionListener(this);
        
        JLabel label5 = new JLabel("<html><font size = '4'>Does student study business?</html>");
		panel5.add(label5);
		
		JComboBox<String> studiesBusinessBox = new JComboBox<>(studiesBusiness);
        panel5.add(studiesBusinessBox);
        studiesBusinessBox.addActionListener(this);
        
        button2 = new JButton();
		panel6.add(button2);
		button2.setText("<html><font size = '4'>  Start Machine</html>");
		button2.setToolTipText("This button generates a random number");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(200,35));
        button1 = new JButton();
        
		panel6.add(button1);
		button1.setText("<html><font size = '4'>  Calculate Probability</html>");
		button1.setToolTipText("This button generates a random number");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(200,35));

		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				//call probability from learning model
			}
			if(e.getSource() == button2)
			{
//				learningModel.collectData();
//				learningModel.getEntriesForTraining();
//				learningModel.priorProbability();
//				learningModel.evidentialProbability();
			}
			
		}
}
