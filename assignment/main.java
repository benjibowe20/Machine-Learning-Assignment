/*Object Oriented Programming Assignment 2022.
 * Machine Learning Model, using Naive Bayes.
 * Author: Benji Bowe
 * Student Number: C20416006
 * Last edited: 08/03/2022
 */

/*
 * Assignment Package
 */
package assignment;

import java.io.FileNotFoundException;

/*
 * Main Class for control of all other classes.
 */
public class main {
	
	public static void main(String[] args) {
		
		/*
		 * Calls GUI from GUI.java for user to interact with application
		 */
		//GUI mine = new GUI("Machine Learning Model");
		
		try {
			fileInputAndOutput fileInputAndOutput = new fileInputAndOutput();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//learningModel Learn = new learningModel();
		
	}
}
//END
