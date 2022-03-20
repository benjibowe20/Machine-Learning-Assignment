package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class fileInputAndOutput {
	
	String fileName;
	File inputFile;
	static String[] data;
	String[] genderData;
	String[] parentBusinessData;
	String[] jobData;
	String[] addressData;
	String[] studiesBusinessData;
	String[] entrepenuerData;
	
	public fileInputAndOutput(String fileName) {
		
		this.fileName = fileName;
		
	}
	
	public void openFile() {
        inputFile = new File(fileName);

        try
        {
            Scanner scanFile = new Scanner(inputFile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
	
	
	public String[] readFile(int column) {
		
		String line = ",";
		String firstLine;
		int count = 0;
		
		try {
			Scanner countCommas = new Scanner(inputFile);
			firstLine = countCommas.nextLine();
			for(int i = 0 ; i < firstLine.length() ; i++) {
				if(firstLine.charAt(i) == ',') {
					count++;
				}
			}
			System.out.println("number of commas in first line: "+count);
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
		for (int i = 3; i < data.length ;) {
			System.out.println(data[i]);
			i = i+5;
				
			
		}
		return data;
	}
	
	public static void skipLines(Scanner scanData,int lineNum){
		for(int i = 0; i < lineNum;i++){
			if(scanData.hasNextLine())scanData.nextLine();
		}
	}

	
}