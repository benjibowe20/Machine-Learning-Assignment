/*Object Oriented Programming Assignment 2022.
 * Machine Learning Model, using Naive Bayes.
 * Author: Benji Bowe
 * Student Number: C20416006
 * Last edited: 15/04/2022
 */

/*
 * This class is used for testing algorithm on remaining 30% to get accuracy of algorithm
 * 
 * The probability of Entrepreneur and not an Entrepreneur is also calculated based on user input
 */

/*
 * Assignment package
 */
package assignment;

/*
 * Imports used in class
 */
import javax.swing.JOptionPane;

public class dataAnalysis {

	/*
	 * Variables used in class for testing and calculating user input
	 */
	double probabilityOfEntrepreneur = 0;
	double probabilityOfNotEntrepreneur = 0;
	
	static double entrepreneurPrior = learningModel.yesPrior;
	static double notEntrepreneurPrior = learningModel.noPrior;
	
	static double probability1;
	static double probability2;
	
	static String current = "";
	
	static int check = 0;
	
	static double correctPrediction = 0;
	
	static double accuracy = 0;
	
	static double variable1 = 0;
	static double variable2 = 0;
	static double variable3 = 0;
	static double variable4 = 0;
	static double variable5 = 0;
	
	static double evidence1 = 0;
	static double evidence2 = 0;
	static double evidence3 = 0;
	static double evidence4 = 0;
	static double evidence5 = 0;
	
	/*
	 * This method is used for testing the data on the remaining 30% of data
	 */
	public static void testData () {
		
		//System.out.println(learningModel.testDataIndexes.size());
		
		/*
		 * loops through all indexes in the test data
		 */
		for (int i = 0 ; i < learningModel.testDataIndexes.size() ; i++) {
			int num = learningModel.testDataIndexes.get(i);
			
			/*
			 * calculations for probability the student becomes an entrepreneur given they are male or female
			 */
			if (learningModel.genderData.get(num-1).contains("Male") == true) {
				variable1 = learningModel.maleGivenEntreprenuer;
				evidence1 = learningModel.pMale;
			}
			if (learningModel.genderData.get(num-1).contains("Female") == true) {
				variable1 = learningModel.femaleGivenEntreprenuer;
				evidence1 = learningModel.pFemale;
			}
			
			/*
			 * calculations for probability the student becomes an entrepreneur given their parent does or doesnt own their own business
			 */
			if (learningModel.parentBusinessData.get(num-1).contains("Yes") == true) {
				variable2 = learningModel.parentBusinessEntrepreneur;
				evidence2 = learningModel.pParentHasBusiness;
			}
			if (learningModel.parentBusinessData.get(num-1).contains("No") == true) {
				variable2 = learningModel.noParentBusinessEntrepreneur;
				evidence2 = learningModel.pParentHasNoBusiness;
			}
			
			/*
			 * calculations for probability the student becomes an entrepreneur given they do or dont have a part time job
			 */
			if (learningModel.jobData.get(num-1).contains("Yes") == true) {
				variable3 = learningModel.hasJobEntrepreneur;
				evidence3 = learningModel.pHasJob;
			}
			if (learningModel.jobData.get(num-1).contains("No") == true) {
				variable3 = learningModel.hasNoJobEntrepreneur;
				evidence3 = learningModel.pHasNoJob;
			}
			
			/*
			 * calculations for probability the student becomes an entrepreneur given they have a rural or urban address
			 */
			if (learningModel.addressData.get(num-1).contains("Urban") == true) {
				variable4 = learningModel.urbanEntreprenuer;
				evidence4 = learningModel.pUrbanAddress;
			}
			if (learningModel.addressData.get(num-1).contains("Rural") == true) {
				variable4 = learningModel.ruralEntreprenuer;
				evidence4 = learningModel.pRuralAddress;
			}
			
			/*
			 * calculations for probability the student becomes an entrepreneur given they do or dont study business
			 */
			if (learningModel.studiesBusinessData.get(num-1).contains("Yes") == true) {
				variable5 = learningModel.studiesBusinessEntreprenuer;
				evidence5 = learningModel.pStudiesBusiness;
			}
			if (learningModel.studiesBusinessData.get(num-1).contains("No") == true) {
				variable5 = learningModel.noStudiesBusinessEntreprenuer;
				evidence5 = learningModel.pNoBusinessStudies;
			}
			
			/*
			 * Calculations for the probability of entrepreneur
			 */
			probability1 = (variable1 * variable2 * variable3 * variable4 * variable5) * entrepreneurPrior;
			
			/*
			 * calculations for probability the student becomes isnt an entrepreneur given they are male or femlae
			 */
			if (learningModel.genderData.get(num-1).contains("Male") == true) {
				variable1 = learningModel.maleGivenNotEntreprenuer;
				evidence1 = learningModel.pMale;
			}
			if (learningModel.genderData.get(num-1).contains("Female") == true) {
				variable1 = learningModel.femaleGivenNotEntreprenuer;
				evidence1 = learningModel.pFemale;
			}
			
			/*
			 * calculations for probability the student becomes isnt an entrepreneur given their parent does or doesnt own their own business
			 */
			if (learningModel.parentBusinessData.get(num-1).contains("Yes") == true) {
				variable2 = learningModel.parentBusinessNotEntrepreneur;
				evidence2 = learningModel.pParentHasBusiness;
			}
			if (learningModel.parentBusinessData.get(num-1).contains("No") == true) {
				variable2 = learningModel.noParentBusinessNotEntrepreneur;
				evidence2 = learningModel.pParentHasNoBusiness;
			}
			
			/*
			 * calculations for probability the student becomes isnt an entrepreneur given they have a part-time job
			 */
			if (learningModel.jobData.get(num-1).contains("Yes") == true) {
				variable3 = learningModel.hasJobNotEntrepreneur;
				evidence3 = learningModel.pHasJob;
			}
			if (learningModel.jobData.get(num-1).contains("No") == true) {
				variable3 = learningModel.hasNoJobNotEntrepreneur;
				evidence3 = learningModel.pHasNoJob;
			}
			
			/*
			 * calculations for probability the student becomes isnt an entrepreneur given they have an urban or rural address
			 */
			if (learningModel.addressData.get(num-1).contains("Urban") == true) {
				variable4 = learningModel.urbanNotEntreprenuer;
				evidence4 = learningModel.pUrbanAddress;
			}
			if (learningModel.addressData.get(num-1).contains("Rural") == true) {
				variable4 = learningModel.ruralNotEntreprenuer;
				evidence4 = learningModel.pRuralAddress;
			}
			
			/*
			 * calculations for probability the student becomes isnt an entrepreneur given they do or dont srtudy business
			 */
			if (learningModel.studiesBusinessData.get(num-1).contains("Yes") == true) {
				variable5 = learningModel.studiesBusinessNotEntreprenuer;
				evidence5 = learningModel.pStudiesBusiness;
			}
			if (learningModel.studiesBusinessData.get(num-1).contains("No") == true) {
				variable5 = learningModel.noStudiesBusinessNotEntreprenuer;
				evidence5 = learningModel.pNoBusinessStudies;
			}
			
			/*
			 * Calculation for probability of not becoming an entrepreneur
			 */
			probability2 = (variable1 * variable2 * variable3 * variable4 * variable5) * notEntrepreneurPrior;
			
			/*
			 * find which probability is bigger
			 */
			if (probability1 > probability2) {
				current = "Yes";
			}
			else if (probability2 > probability1) {
				current = "No";
			}
			
			/*
			 * Checks if prediction is the same as entreprenuer value in that index
			 * 
			 * If correct the accuracy of the model increases and visa versa
			 */
			if (current == "Yes" && learningModel.entreprenuerData.get(num-1).contains("Yes") == true) {
				correctPrediction++;
			}
			else if (current == "No" && learningModel.entreprenuerData.get(num-1).contains("No") == true) {
				correctPrediction++;
			}
			
			
		}
		
		
		/*
		 * Accuracy of algorithm is calculated and stored
		 */
		if (check == 0) {
			accuracy = correctPrediction / learningModel.testDataIndexes.size();
			accuracy = accuracy * 100;
			check = 1;
		}
		
	}
	
	/*
	 * This method is used to make an estimated guess at student outcome based on data entered by the user
	 */
	public static void enteredData () {
		
		/*
		 * chooses variable to use for liklihood and evidence of student gender
		 */
		if (GUI.genderInput == "Male") {
			variable1 = learningModel.maleGivenEntreprenuer;
			evidence1 = learningModel.pMale;
		}
		if (GUI.genderInput == "Female") {
			variable1 = learningModel.femaleGivenEntreprenuer;
			evidence1 = learningModel.pFemale;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student parent owning business
		 */
		if (GUI.ownBusinessInput == "Yes") {
			variable2 = learningModel.parentBusinessEntrepreneur;
			evidence2 = learningModel.pParentHasBusiness;
		}
		if (GUI.ownBusinessInput == "No") {
			variable2 = learningModel.noParentBusinessEntrepreneur;
			evidence2 = learningModel.pParentHasNoBusiness;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student having part-time job
		 */
		if (GUI.hasJobInput == "Yes") {
			variable3 = learningModel.hasJobEntrepreneur;
			evidence3 = learningModel.pHasJob;
		}
		if (GUI.hasJobInput == "Yes") {
			variable3 = learningModel.hasNoJobEntrepreneur;
			evidence3 = learningModel.pHasNoJob;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student address
		 */
		if (GUI.urbanOrRuralInput == "Urban") {
			variable4 = learningModel.urbanEntreprenuer;
			evidence4 = learningModel.pUrbanAddress;
		}
		if (GUI.urbanOrRuralInput == "Rural") {
			variable4 = learningModel.ruralEntreprenuer;
			evidence4 = learningModel.pRuralAddress;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student studying business subjects
		 */
		if (GUI.studiesBusinessInput == "Yes") {
			variable5 = learningModel.studiesBusinessEntreprenuer;
			evidence5 = learningModel.pStudiesBusiness;
		}
		if (GUI.studiesBusinessInput == "Yes") {
			variable5 = learningModel.noStudiesBusinessEntreprenuer;
			evidence5 = learningModel.pNoBusinessStudies;
		}
		
		/*
		 * Calculation that student becomes an entrepreneur
		 */
		probability1 = (variable1 * variable2 * variable3 * variable4 * variable5) * entrepreneurPrior;
		
		/*
		 * chooses variable to use for liklihood and evidence of student gender
		 */
		if (GUI.genderInput == "Male") {
			variable1 = learningModel.maleGivenEntreprenuer;
			evidence1 = learningModel.pMale;
		}
		if (GUI.genderInput == "Female") {
			variable1 = learningModel.femaleGivenEntreprenuer;
			evidence1 = learningModel.pFemale;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student parent owning business
		 */
		if (GUI.ownBusinessInput == "Yes") {
			variable2 = learningModel.parentBusinessEntrepreneur;
			evidence2 = learningModel.pParentHasBusiness;
		}
		if (GUI.ownBusinessInput == "No") {
			variable2 = learningModel.noParentBusinessEntrepreneur;
			evidence2 = learningModel.pParentHasNoBusiness;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student having part-time job
		 */
		if (GUI.hasJobInput == "Yes") {
			variable3 = learningModel.hasJobNotEntrepreneur;
			evidence3 = learningModel.pHasJob;
		}
		if (GUI.hasJobInput == "Yes") {
			variable3 = learningModel.hasNoJobNotEntrepreneur;
			evidence3 = learningModel.pHasNoJob;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student address
		 */
		if (GUI.urbanOrRuralInput == "Urban") {
			variable4 = learningModel.urbanNotEntreprenuer;
			evidence4 = learningModel.pUrbanAddress;
		}
		if (GUI.urbanOrRuralInput == "Rural") {
			variable4 = learningModel.ruralNotEntreprenuer;
			evidence4 = learningModel.pRuralAddress;
		}
		
		/*
		 * chooses variable to use for liklihood and evidence of student studying business subjects
		 */
		if (GUI.studiesBusinessInput == "Yes") {
			variable5 = learningModel.studiesBusinessNotEntreprenuer;
			evidence5 = learningModel.pStudiesBusiness;
		}
		if (GUI.studiesBusinessInput == "Yes") {
			variable5 = learningModel.noStudiesBusinessNotEntreprenuer;
			evidence5 = learningModel.pNoBusinessStudies;
		}
		
		/*
		 * Calculation that student does not become an entrepreneur
		 */
		probability2 = (variable1 * variable2 * variable3 * variable4 * variable5) * notEntrepreneurPrior;
		
		/*
		 * If the probabilty they will become an entrepreneur is higher
		 * 
		 * Prints a pop-up message displaying probabilities of both entrepreneur and not an entrepreneur 
		 * 
		 * Also dislays they are more likely to become an entrepreneur
		 */
		if (probability1 > probability2) {
			JOptionPane.showMessageDialog(null,"Probability this student is Entrepreneur: "+Math.round(probability1*100000.0)/100000.0+
					"\nProbability the student is not an Entrepreneur: "+Math.round(probability2*100000.0)/100000.0+
					"\n\nBased on the entered details, this student is more likely to become an Entrepreneur");
		}
		
		/*
		 * If the probabilty they will not become an entrepreneur is higher
		 * 
		 * Prints a pop-up message displaying probabilities of both entrepreneur and not an entrepreneur 
		 * 
		 * Also dislays they are more likely to not become an entrepreneur
		 */
		else if (probability2 > probability1) {
			JOptionPane.showMessageDialog(null,"Probability this student is Entrepreneur: "+Math.round(probability1*100000.0)/100000.0+
					"\nProbability the student is not an Entrepreneur: "+Math.round(probability2*100000.0)/100000.0+
					"\n\nBased on the entered details, this student is more likely to not become an Entrepreneur");
		}
	}

	
	
	
	
}




























