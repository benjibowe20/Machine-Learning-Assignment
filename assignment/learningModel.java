/*Object Oriented Programming Assignment 2022.
 * Machine Learning Model, using Naive Bayes.
 * Author: Benji Bowe
 * Student Number: C20416006
 * Last edited: 15/04/2022
 */

/*
 * This class is used for calculating the folliowing:
 * 		- Prior Probabilities
 * 		- Evidential Probabilities
 * 		- Compute Liklihoods
 * 
 * The class is also used to put the data into smaller arrays
 * 
 * The calculations are based on a random 70% of the dataset so results are varied and more accurate
 */

/*
 * Assignment Package
 */
package assignment;

/*
 * Imports used in class
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class learningModel {
	
	/*
	 * Arraylists made to put all similar data togeteher
	 */
	static ArrayList<String> studiesBusinessData = new ArrayList<String>();
	static ArrayList<String> genderData = new ArrayList<String>();
	static ArrayList<String> parentBusinessData = new ArrayList<String>();
	static ArrayList<String> jobData = new ArrayList<String>();
	static ArrayList<String> addressData = new ArrayList<String>();
	static ArrayList<String> entreprenuerData = new ArrayList<String>();
	static ArrayList<Integer> randomArrayIndexes = new ArrayList<Integer>();
	static ArrayList<Integer> testDataIndexes = new ArrayList<Integer>();
	
	/*
	 * Below are all variables used in this class which contribute to calculations or storing of calculated outputs
	 */
	int probability;
	int i = 0;
	
	static double entreprenuerCount = 0;
	static double notEntreprenuerCount = 0;
	
	static double maleEntreprenuerCount = 0;
	static double studiesBusinessEntreprenuerCount = 0;
	static double urbanEntreprenuerCount = 0;
	static double hasJobCount = 0;
	static double parentHasBusinessCount = 0;
	
	static double maleNotEntreprenuerCount = 0;
	static double studiesBusinessNotEntreprenuerCount = 0;
	static double urbanNotEntreprenuerCount = 0;
	static double hasJobNotCount = 0;
	static double parentHasBusinessNotCount = 0;
	
	static double maleGivenEntreprenuer = 0;
	static double femaleGivenEntreprenuer = 0;
	static double studiesBusinessEntreprenuer = 0;
	static double noStudiesBusinessEntreprenuer = 0;
	static double urbanEntreprenuer = 0;
	static double ruralEntreprenuer = 0;
	static double hasJobEntrepreneur = 0;
	static double hasNoJobEntrepreneur = 0;
	static double parentBusinessEntrepreneur = 0;
	static double noParentBusinessEntrepreneur = 0;
	
	static double maleGivenNotEntreprenuer = 0;
	static double femaleGivenNotEntreprenuer = 0;
	static double studiesBusinessNotEntreprenuer = 0;
	static double noStudiesBusinessNotEntreprenuer = 0;
	static double urbanNotEntreprenuer = 0;
	static double ruralNotEntreprenuer = 0;
	static double hasJobNotEntrepreneur = 0;
	static double hasNoJobNotEntrepreneur = 0;
	static double parentBusinessNotEntrepreneur = 0;
	static double noParentBusinessNotEntrepreneur = 0;
	
	static double yesPrior = 0;
	static double noPrior = 0;
	static double totalCount = randomArrayIndexes.size();
	static double yesCount = 0;
	static double noCount = 0;
	
	static double pStudiesBusiness = 0;
	static double pNoBusinessStudies = 0;
	static double pUrbanAddress = 0;
	static double pRuralAddress = 0;
	static double pHasJob = 0;
	static double pHasNoJob = 0;
	static double pParentHasBusiness = 0;
	static double pParentHasNoBusiness = 0;
	static double pMale = 0;
	static double pFemale = 0;
	
	
	/*
	 * Method for collecting data and putting all similar data into its own arraylist
	 */
	public static void collectData() {
		
		/*
		 * Asks user to enter a filename which they would like to use
		 */
		String fileName = JOptionPane.showInputDialog("Please enter the file name you would like to use.");
		fileInputAndOutput file = new fileInputAndOutput("/Users/35385/"+fileName);
		file.openFile();
		file.readFile(0);
		
		/*
		 * Places all data related to Student studying business into a studentBusinessData array
		 */
		for (int i = 5; i < fileInputAndOutput.data.length;) {
			studiesBusinessData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
		/*
		 * Places all data related to Student becoming an entrepreneur into entrepreneurData array
		 */
		for (int i = 6; i < fileInputAndOutput.data.length;) {
			if (fileInputAndOutput.data[i].contains("Yes")) {
				entreprenuerData.add("Yes");
			}
			if (fileInputAndOutput.data[i].contains("No")) {
				entreprenuerData.add("No");
			}
			i = i+5;
		}
		
		/*
		 * Places all data related to Student gender into a genderData array
		 */
		for (int i = 1; i < fileInputAndOutput.data.length;) {
			if (fileInputAndOutput.data[i].contains("Female")) {
				genderData.add("Female");
			}
			if (fileInputAndOutput.data[i].contains("Male")) {
				genderData.add("Male");
			}
			i = i+5;
		}
		
		/*
		 * Places all data related to Student parent owning business into parentBusinessData
		 */
		for (int i = 2; i < fileInputAndOutput.data.length;) {
			parentBusinessData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
		/*
		 * Places all data related to Student having a part-time job into a jobData array
		 */
		for (int i = 3; i < fileInputAndOutput.data.length;) {
			jobData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
		/*
		 * Places all data related to Student address into a addressData array
		 */
		for (int i = 4; i < fileInputAndOutput.data.length;) {
			addressData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
	}
	
	/*
	 * This method is gets the 70% of the dataset and creates an array consisting of the random indexes oif that 70%
	 */
	public static void getEntriesForTraining() {
		
		/*
		 * variables used in method
		 */
		double numberOfEntries = entreprenuerData.size();
		double get70Percent = numberOfEntries * 0.7;
		int rounded = (int) get70Percent;
		int num;
		
		/*
		 * Creates a random array of indexes which are used for training
		 * 
		 * These numbers account for 70% of the entire dataset provided
		 */
		for (int i = 1; i <= rounded ;i ++) {
			num = (int) (Math.floor(Math.random()*numberOfEntries));
			while (randomArrayIndexes.contains(num)==true ) {
				num = (int) (Math.floor(Math.random()*numberOfEntries));
			}
			randomArrayIndexes.add(num);
			
		}
		
		/*
		 * Creates an array of indexes used for testing
		 * 
		 * These indexes are the remaining 30% which were not used in testing
		 */
		for (int i = 1; i <= numberOfEntries; i++) {
			if (randomArrayIndexes.contains(i) == false) {
				testDataIndexes.add(i);
			}
		}
		
		
		
	}
	
	/*
	 * This method calculates the prior probability of entreprenuer and not entrepreneur
	 */
	public static void priorProbability () {
		
		double countAll = randomArrayIndexes.size();
		
		/*
		 * Counts number of entrepreneurs and not entrepreneurs
		 */
		for (int a = 0; a < countAll ; a++) {
			int num = randomArrayIndexes.get(a);
			if (entreprenuerData.get(num) == "Yes") {
				yesCount = yesCount + 1;
			}
			if (entreprenuerData.get(num) == "No") {
				noCount = noCount + 1;
			}
		}
		
		/*
		 * Calculation for prior probabilities
		 */
		yesPrior = yesCount/countAll;
		noPrior = noCount/countAll;
		
	}
	
	/*
	 * This method is used for calculating the evidential probabilties which goes in the denominator
	 */
	public static void evidentialProbability() {
		
		double totalCount = randomArrayIndexes.size();
		double maleCount = 0;
		double parentHasBusinessCount = 0;
		double hasJobCount = 0;
		double urbanAddressCount = 0;
		double studiesBusinessCount = 0;
		
		/*
		 * Counts number of males
		 */
		for (int a = 0; a < totalCount ; a++) {
			int num1 = randomArrayIndexes.get(a);
			if (genderData.get(num1).contains("Male") == true) {
				maleCount = maleCount + 1;
			}
		}
		
		/*
		 * Counts number of students whos parent owns business
		 */
		for (int b = 0; b < totalCount ; b++) {
			int num2 = randomArrayIndexes.get(b);
			if (parentBusinessData.get(num2).contains("Yes") == true) {
				parentHasBusinessCount = parentHasBusinessCount + 1;
			}
		}
		
		/*
		 * Counts number of students who have a part time job
		 */
		for (int c = 0; c < totalCount ; c++) {
			int num3 = randomArrayIndexes.get(c);
			if (jobData.get(num3).contains("Yes") == true) {
				hasJobCount = hasJobCount + 1;
			}
		}
		
		/*
		 * Counts number of students with urban address
		 */
		for (int d = 0; d < totalCount ; d++) {
			int num4 = randomArrayIndexes.get(d);
			if (addressData.get(num4).contains("Urban") == true) {
				urbanAddressCount = urbanAddressCount + 1;
			}
		}
		
		/*
		 * Counts number of studentrs who study business
		 */
		for (int f = 0; f < totalCount ; f++) {
			int num5 = randomArrayIndexes.get(f);
			if (studiesBusinessData.get(num5).contains("Yes") == true) {
				studiesBusinessCount = studiesBusinessCount + 1;
			}
		}
		
		/*
		 * Evidential probabilities of each trait
		 */
		pMale = maleCount/totalCount;
		pFemale = 1-pMale;
		
		pParentHasBusiness = parentHasBusinessCount/totalCount;
		pParentHasNoBusiness = 1-pParentHasBusiness;
		
		pHasJob = hasJobCount/totalCount;
		pHasNoJob = 1 - pHasJob;
		
		pUrbanAddress = urbanAddressCount/totalCount;
		pRuralAddress = 1 - pUrbanAddress;
		
		pStudiesBusiness = studiesBusinessCount/totalCount;
		pNoBusinessStudies = 1 - pStudiesBusiness;
		
	}
	
	/*
	 * This methoid calculates the liklihoods which goes in the numerator
	 */
	public static void computeLiklihoods() {
		
		double totalCount = randomArrayIndexes.size();
		
		/*
		 * For loop which creates a count of all different traits if trait is yes, urban, male
		 */
		for (int i = 0; i < totalCount ; i++) {
			int num5 = randomArrayIndexes.get(i);
			if (entreprenuerData.get(num5).contains("Yes") == true) {
				entreprenuerCount = entreprenuerCount + 1;
				if (genderData.get(num5).contains("Male") == true) {
					maleEntreprenuerCount++;
				}
				if (studiesBusinessData.get(num5).contains("Yes") == true) {
					studiesBusinessEntreprenuerCount++;
				}
				if (addressData.get(num5).contains("Urban") == true) {
					urbanEntreprenuerCount++;
				}
				if (jobData.get(num5).contains("Yes") == true) {
					hasJobCount++;
				}
				if (parentBusinessData.get(num5).contains("Yes") == true) {
					parentHasBusinessCount++;
				}
			}
		}
		
		/*
		 * Calculations for likilihoods of each trait if trait is yes, urban, male
		 */
		maleGivenEntreprenuer = maleEntreprenuerCount / entreprenuerCount;
		femaleGivenEntreprenuer = 1-maleGivenEntreprenuer;
		
		studiesBusinessEntreprenuer = studiesBusinessEntreprenuerCount / entreprenuerCount;
		noStudiesBusinessEntreprenuer = 1 - studiesBusinessEntreprenuer;
		
		urbanEntreprenuer = urbanEntreprenuerCount / entreprenuerCount;
		ruralEntreprenuer = 1 - urbanEntreprenuer;
		
		hasJobEntrepreneur = hasJobCount / entreprenuerCount;
		hasNoJobEntrepreneur = 1 - hasJobEntrepreneur;
		
		parentBusinessEntrepreneur = parentHasBusinessCount / entreprenuerCount;
		noParentBusinessEntrepreneur = 1 - parentBusinessEntrepreneur;
		
		/*
		 * For loop which creates a count of all different traits if trait is no, rural, female
		 */
		for (int i = 0; i < totalCount ; i++) {
			int num5 = randomArrayIndexes.get(i);
			if (entreprenuerData.get(num5).contains("No") == true) {
				notEntreprenuerCount = notEntreprenuerCount + 1;
				if (genderData.get(num5).contains("Male") == true) {
					maleNotEntreprenuerCount++;
				}
				if (studiesBusinessData.get(num5).contains("Yes") == true) {
					studiesBusinessNotEntreprenuerCount++;
				}
				if (addressData.get(num5).contains("Urban") == true) {
					urbanNotEntreprenuerCount++;
				}
				if (jobData.get(num5).contains("Yes") == true) {
					hasJobNotCount++;
				}
				if (parentBusinessData.get(num5).contains("Yes") == true) {
					parentHasBusinessNotCount++;
				}
			}
		}
		
		/*
		 * Calculates liklihoods of traits if trait is no, rural, female
		 */
		maleGivenNotEntreprenuer = maleNotEntreprenuerCount / notEntreprenuerCount;
		femaleGivenNotEntreprenuer = 1-maleGivenNotEntreprenuer;
		
		studiesBusinessNotEntreprenuer = studiesBusinessNotEntreprenuerCount / notEntreprenuerCount;
		noStudiesBusinessNotEntreprenuer = 1 - studiesBusinessNotEntreprenuer;
		
		urbanNotEntreprenuer = urbanNotEntreprenuerCount / notEntreprenuerCount;
		ruralNotEntreprenuer = 1 - urbanNotEntreprenuer;
		
		hasJobNotEntrepreneur = hasJobNotCount / notEntreprenuerCount;
		hasNoJobNotEntrepreneur = 1 - hasJobNotEntrepreneur;
		
		parentBusinessNotEntrepreneur = parentHasBusinessNotCount / notEntreprenuerCount;
		noParentBusinessNotEntrepreneur = 1 - parentBusinessNotEntrepreneur;
		
		
	}
	
}




















