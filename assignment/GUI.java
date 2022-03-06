package assignment;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	
	JLabel label1, label2;
	JButton button1, button2;
	JPanel panel1, panel2;
	JTextField textfield;

	
	public GUI(String title) {
		super (title);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new FlowLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		add(panel1);
		panel1.setLayout(new FlowLayout());
		add(panel2);
		panel2.setLayout(new FlowLayout());
		
		
		
		JLabel label1 = new JLabel("<html><font size = '5'>What is the gender of the student?");
		add(label1);
		
		button1 = new JButton();
		panel2.add(button1);
		button1.setText("<html><font size = '5'>  Male");
		button1.setToolTipText("This button generates a random number");
		button1.addActionListener(this);
		
		button2 = new JButton();
		panel2.add(button2);
		button2.setText("<html><font size = '5'>Female");
		button2.setToolTipText("This button generates a random number");
		button2.addActionListener(this);
		

		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == button1)
			{
				JOptionPane.showMessageDialog(this, "Male");
			}
			
		}

}
