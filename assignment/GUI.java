/*Object Oriented Programming Assignment 2022.
 * Machine Learning Model, using Naive Bayes.
 * Author: Benji Bowe
 * Student Number: C20416006
 * Last edited: 15/04/2022
 */

/*
 * This is the class for the Graphical User Interface (GUI) 
 */

/*
 * Assignment Package
 */
package assignment;

/*
 * All used imports listed here for use in class
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * GUI interacts with the followiung classes:
 * 		- learningModel.java
 * 		- dataAnalysis.java
 */

public class GUI extends JFrame implements ActionListener{
	
	/*
	 * All javax.swing variables declared here
	 */
	JLabel label1, label2, label3, label4, label5;
	static JLabel label6;
	JButton button1, button2;
	JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
	JTextField textfield;
	JFrame frame;
	JComboBox ownBusinessBox, genderBox, hasJobBox, urbanOrRuralBox, studiesBusinessBox;
	
	/*
	 * These vaiables are used to take the input from the JComboBox and store it for use in dataAnalysis.java class
	 */
	static String ownBusinessInput, genderInput, hasJobInput, urbanOrRuralInput, studiesBusinessInput;
	
	/*
	 * Regular data type variables are declared here
	 * These string arrays contain html code to help make the layout of the GUI look better
	 */
	static String[] gender = {"<html><font size = '4'>Male</html>", "<html><font size = '4'>Female</html>"};
	static String[] ownBusiness = {"<html><font size = '4'>Yes</html>", "<html><font size = '4'>No</html>"};
	static String[] hasJob = {"<html><font size = '4'>Yes</html>", "<html><font size = '4'>No</html>"};
	static String[] urbanOrRural = {"<html><font size = '4'>Urban</html>", "<html><font size = '4'>Rural</html>"};
	static String[] studiesBusiness = {"<html><font size = '4'>Yes</html>", "<html><font size = '4'>No</html>"};
	
	/*
	 * Generation of GUI
	 */
	public GUI(String title) {

		/*
		 * Sets the title for the GUI frame
		 */
		super (title);
		
		/*
		 * Setting the dimensions and layout of GUI
		 * I used flow layout for this GUI as I felt it was the most fitting for the task at hand
		 */
		JFrame frame = new JFrame();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		setVisible(true);
		setSize(500,600);
		setLayout(new FlowLayout());
		
		/*
		 * Creating and adding the Panels to the GUI in order so they will appear as intended
		 */
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		add(panel8);
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
		
		/*
		 * This label is used to provide instructions to the user.
		 */
		JLabel label7 = new JLabel("<html><font size = '4' font color=\"red\">Instructions for use:<br>"
				+ "1. Press \"Start Machine\" and enter file name.<br>"
				+ "2. Select student details.<br>"
				+ "3. Press \"Calculate Probability\".<br>"
				+ "4. Repeat step 3 as much as you like.<br><br></html>");
		panel8.add(label7);
		
		/*
		 * Below the label to ask for student gender is created and added to panel1
		 */
		JLabel label1 = new JLabel("<html><font size = '4'>What is the gender of the student?</html>");
		panel1.add(label1);
		
		/*
		 * JComboBox for student gender is created and added to panel1
		 * An action listener is also added to this JComboBox
		 */
		genderBox = new JComboBox<>(gender);
        panel1.add(genderBox);
        genderBox.addActionListener(this);
        
        /*
		 * Below the label to ask if student parent owns their own business is created and added to panel2
		 */
		JLabel label2 = new JLabel("<html><font size = '4'>Does student Parent own a business?</html>");
		panel2.add(label2);
		
		/*
		 * JComboBox for students parent owning business is created and added to panel1
		 * An action listener is also added to this JComboBox
		 */
		ownBusinessBox = new JComboBox<>(ownBusiness);
        panel2.add(ownBusinessBox);
        ownBusinessBox.addActionListener(this);
        
        /*
		 * Below the label to ask is student has a part-time job is created and added to panel3
		 */
        JLabel label3 = new JLabel("<html><font size = '4'>Does student have a part-time job?</html>");
		panel3.add(label3);
		
		/*
		 * JComboBox for student part-time job is created and added to panel1
		 * An action listener is also added to this JComboBox
		 */
		hasJobBox = new JComboBox<>(hasJob);
        panel3.add(hasJobBox);
        hasJobBox.addActionListener(this);
        
        /*
		 * Below the label to ask for student address is created and added to panel4
		 */
        JLabel label4 = new JLabel("<html><font size = '4'>Urban or Rural address?</html>");
		panel4.add(label4);
		
		/*
		 * JComboBox for student address is created and added to panel1
		 * An action listener is also added to this JComboBox
		 */
		urbanOrRuralBox = new JComboBox<>(urbanOrRural);
        panel4.add(urbanOrRuralBox);
        urbanOrRuralBox.addActionListener(this);
        
        /*
		 * Below the label to ask if student studeies business is created and added to panel5
		 */
        JLabel label5 = new JLabel("<html><font size = '4'>Does student study business?</html>");
		panel5.add(label5);
		
		/*
		 * JComboBox for student business studies is created and added to panel1
		 * An action listener is also added to this JComboBox
		 */
		studiesBusinessBox = new JComboBox<>(studiesBusiness);
        panel5.add(studiesBusinessBox);
        studiesBusinessBox.addActionListener(this);
        
        /*
         * Creating and adding the "Start Machine" button and adding an action listener to this button.
         * The dimensions of this button were also added for better aesthetics
         */
        button2 = new JButton();
		panel6.add(button2);
		button2.setText("<html><font size = '4'>  Start Machine</html>");
		button2.setToolTipText("This button starts gets file and starts analysis");
		button2.addActionListener(this);
		button2.setPreferredSize(new Dimension(200,35));
		
		/*
         * Creating and adding the "Calculate Probability" button and adding an action listener to this button.
         * The dimensions of this button were also added for better aesthetics
         */
        button1 = new JButton();
		panel6.add(button1);
		button1.setText("<html><font size = '4'>  Calculate Probability</html>");
		button1.setToolTipText("This button will calculate the probability based on above selection");
		button1.addActionListener(this);
		button1.setPreferredSize(new Dimension(200,35));
		button1.setEnabled(false);
		
		/*
		 * This label displays the formula used with Naive Bayes
		 */
		JLabel label6 = new JLabel("<html><font size = '4' font color=\"green\">Calculations are based on Naive Bayes Classifier:<br><br>"
				+ "<i>&emsp;&emsp;&ensp;Liklihood of evidences * Prior Probability<br>"
				+ "&emsp;&emsp;----------------------------------------------------------<br>"
				+ "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Probability of Evidences</i></html>");
		panel7.add(label6);
		
		/*
		 * NOTE** 
		 * The below if-else statements takes the values oif the JComboBox values before they are changed so they have dpo not all
		 * have to be set individually. They all have preset values.
		 */
		
		/*
		 * The below if-else statement gets the value form the ownBusinessBox JComboBox and stores it in a variable
		 */
		if (ownBusinessBox.getSelectedItem().toString().contains("Yes") == true) {
			ownBusinessInput = "Yes";
		}
		else {
			ownBusinessInput = "No";
		}
		
		/*
		 * The below if-else statement gets the value form the genderBox JComboBox and stores it in a variable
		 */
		if (genderBox.getSelectedItem().toString().contains("Male") == true) {
			genderInput = "Male";	
		}
		else {
			genderInput = "Male";
		}
		
		/*
		 * The below if-else statement gets the value form the hasJobBox JComboBox and stores it in a variable
		 */
		if (hasJobBox.getSelectedItem().toString().contains("Yes") == true) {
			hasJobInput = "Yes";	
		}
		else {
			hasJobInput = "No";
		}
		
		/*
		 * The below if-else statement gets the value form the studiesBusinessBox JComboBox and stores it in a variable
		 */
		if (studiesBusinessBox.getSelectedItem().toString().contains("Yes") == true) {
			studiesBusinessInput = "Yes";	
		}
		else {
			studiesBusinessInput = "No";
		}
		
		/*
		 * The below if-else statement gets the value form the urbanOrRuralBox JComboBox and stores it in a variable
		 */
		if (urbanOrRuralBox.getSelectedItem().toString().contains("Urban") == true) {
			urbanOrRuralInput = "Urban";	
		}
		else {
			urbanOrRuralInput = "Rural";
		}

		
		
	} // ends constructor
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			/*
			 * if "Calculate Probability" button is pressed the enteredData method is called from dataAnalysis.java
			 */
			if(e.getSource() == button1)
			{
		        dataAnalysis.enteredData();
		        
			}
			
			/*
			 * if "Start Machine" button is pressed all methods used in the calculations are run. 
			 * These calculations are run on 70% of the dataset
			 * 
			 * Once the calculations are complete the remaining 30% is tested to calculate the accuracy of the model
			 * This accuracy is then printed in a JOptionPane
			 * 
			 * This button is also disabled after use for prevention of errors
			 * 
			 * Once this button is pressed the Calculate probabilities button becomes visible
			 */
			if(e.getSource() == button2)
			{
				
				learningModel.collectData();
				learningModel.getEntriesForTraining();
				learningModel.priorProbability();
				learningModel.evidentialProbability();
				learningModel.computeLiklihoods();
				button2.setEnabled(false);
				
		        dataAnalysis.testData();
		        JOptionPane.showMessageDialog(this, "Start-up Complete.\n\nAccuracy of "
		        		+ "current model\nbased on testing of provided data: "+Math.round(dataAnalysis.accuracy*100.0)/100.0+"%");
		        
		        button1.setEnabled(true); 
			}
			
			/*
			 * The below if-else statement gets the value form the ownBusinessBox JComboBox and stores it in a variable
			 */
			if (e.getSource() == ownBusinessBox) {
				if (ownBusinessBox.getSelectedItem().toString().contains("Yes") == true) {
					ownBusinessInput = "Yes";
				}
				else {
					ownBusinessInput = "No";
				}
			}
			
			/*
			 * The below if-else statement gets the value form the genderBox JComboBox and stores it in a variable
			 */
			if (e.getSource() == genderBox) {
				if (genderBox.getSelectedItem().toString().contains("Male") == true) {
					genderInput = "Male";	
				}
				else {
					genderInput = "Male";
				}
			}
			
			/*
			 * The below if-else statement gets the value form the hasJobBox JComboBox and stores it in a variable
			 */
			if (e.getSource() == hasJobBox) {
				if (hasJobBox.getSelectedItem().toString().contains("Yes") == true) {
					hasJobInput = "Yes";	
				}
				else {
					hasJobInput = "No";
				}
			}
			
			/*
			 * The below if-else statement gets the value form the studiesBusinessBox JComboBox and stores it in a variable
			 */
			if (e.getSource() == studiesBusinessBox) {
				if (studiesBusinessBox.getSelectedItem().toString().contains("Yes") == true) {
					studiesBusinessInput = "Yes";	
				}
				else {
					studiesBusinessInput = "No";
				}
			}
			
			/*
			 * The below if-else statement gets the value form the urbanOrRuralBox JComboBox and stores it in a variable
			 */
			if (e.getSource() == urbanOrRuralBox) {
				if (urbanOrRuralBox.getSelectedItem().toString().contains("Urban") == true) {
					urbanOrRuralInput = "Urban";	
				}
				else {
					urbanOrRuralInput = "Rural";
				}
			}
		}
}






















