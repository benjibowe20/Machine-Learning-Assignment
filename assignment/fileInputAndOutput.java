/*Object Oriented Programming Assignment 2022.
 * Machine Learning Model, using Naive Bayes.
 * Author: Benji Bowe
 * Student Number: C20416006
 * Last edited: 15/04/2022
 */

/*
 * This class is used for opening and reading file data and splitting the relative data into its own parts
 */

/*
 * Assignment Package
 */
package assignment;

/*
 * Imports used in this class
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class fileInputAndOutput {
	
	/*
	 * Defining variables used in this class
	 */
	String fileName;
	File inputFile;
	static String[] data;
	String[] genderData;
	String[] parentBusinessData;
	String[] jobData;
	String[] addressData;
	String[] studiesBusinessData;
	String[] entrepenuerData;
	
	/*
	 * Constructor for class
	 */
	public fileInputAndOutput(String fileName) {
		
		this.fileName = fileName;
		
	}
	
	/*
	 * Method for opening the file provided by user
	 */
	public void openFile() {
        inputFile = new File(fileName);
        
        /*
         * Try catch statement for error handling with file opening
         */
        try
        {
            Scanner scanFile = new Scanner(inputFile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
	
	/*
	 * Method for reading in file data
	 * 
	 * Data is provided in csv format so is divided by ","
	 */
	public String[] readFile(int column) {
		
		String line = ",";
		String firstLine;
		int count = 0;
		
		/*
		 * Data being split on "," and put in one array called data where it is broken down in other classes
		 */
		try {
			Scanner countCommas = new Scanner(inputFile);
			firstLine = countCommas.nextLine();
			for(int i = 0 ; i < firstLine.length() ; i++) {
				if(firstLine.charAt(i) == ',') {
					count++;
				}
			}
		}
		catch (FileNotFoundException e1) {
			System.out.println("File Not Found:" + e1.getMessage());
		}
		
		try {
			Scanner scanFile = new Scanner(inputFile);
			while(scanFile.hasNextLine()) {
				
				line = line.concat(scanFile.nextLine());
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found:" + e.getMessage());
		}
		
		Pattern ptr = Pattern.compile(",");
		
		
		data = ptr.split(line);
		
		
		
		for (int i = 0; i < data.length ;) {
			i = i+5;
				
			
		}
		return data;
	}
	
	/*
	 * Method for skipping the lines of files which do not contain relative data
	 */
	public static void skipLines(Scanner scanData,int lineNum){
		for(int i = 0; i < lineNum;i++){
			if(scanData.hasNextLine())scanData.nextLine();
		}
	}

	
}