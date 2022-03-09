package assignment;

import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;


public class fileInputAndOutput {
	
	public static String[] genderData;
	String line = "";
	
	public fileInputAndOutput() throws FileNotFoundException
	{
	    File inputFile = new File("/Users/35385/MLdata.csv");
	    Scanner scanData = new Scanner(inputFile);
	    skipLines(scanData, 3);
	    
	    while ((line = scanData.nextLine()) != null)
		{
			String[] values = line.split(",");
			
			String genderData = values[0];
			String parentBusinessData = values[1];
			String jobData = values[2];
			String addressData = values[3];
			String studiesBusinessData = values[4];
			String entrepenuerData = values[5];
			
			if ((scanData.nextLine()) == null)
			{
				break;
			}
			
			System.out.println("Gender: "+genderData+" Parents own Business: "+parentBusinessData+" Entrepenuer: "+entrepenuerData);
		}
	  
	    scanData.close();
	    }
	
	public static void skipLines(Scanner scanData,int lineNum){
        for(int i = 0; i < lineNum;i++){
            if(scanData.hasNextLine())scanData.nextLine();
        }
    }
}
	
