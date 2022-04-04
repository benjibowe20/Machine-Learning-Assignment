package assignment;

public class dataAnalysis {

	double probabilityOfEntrepreneur = 0;
	double probabilityOfNotEntrepreneur = 0;
	
	static double entrepreneurPrior = learningModel.yesPrior;
	
	static double probability1;
	
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
	
	public static void testData () {
		
		//System.out.println(learningModel.testDataIndexes.size());
		
		for (int i = 0 ; i < learningModel.testDataIndexes.size() ; i++) {
			int num = learningModel.testDataIndexes.get(i);
			
			//calculations for probability the student is an entreprenuer
			//gender
			if (learningModel.genderData.get(num-1).contains("Male") == true) {
				variable1 = learningModel.maleGivenEntreprenuer;
				evidence1 = learningModel.pMale;
			}
			if (learningModel.genderData.get(num-1).contains("Female") == true) {
				variable1 = learningModel.femaleGivenEntreprenuer;
				evidence1 = learningModel.pFemale;
			}
			
			//parent owns business
			if (learningModel.parentBusinessData.get(num-1).contains("Yes") == true) {
				variable2 = learningModel.parentBusinessEntrepreneur;
				evidence2 = learningModel.pParentHasBusiness;
			}
			if (learningModel.parentBusinessData.get(num-1).contains("No") == true) {
				variable2 = learningModel.noParentBusinessEntrepreneur;
				evidence2 = learningModel.pParentHasNoBusiness;
			}
			
			//part time job
			if (learningModel.jobData.get(num-1).contains("Yes") == true) {
				variable3 = learningModel.hasJobEntrepreneur;
				evidence3 = learningModel.pHasJob;
			}
			if (learningModel.jobData.get(num-1).contains("No") == true) {
				variable3 = learningModel.hasNoJobEntrepreneur;
				evidence3 = learningModel.pHasNoJob;
			}
			
			//address
			if (learningModel.addressData.get(num-1).contains("Urban") == true) {
				variable4 = learningModel.urbanEntreprenuer;
				evidence4 = learningModel.pUrbanAddress;
			}
			if (learningModel.addressData.get(num-1).contains("Rural") == true) {
				variable4 = learningModel.ruralEntreprenuer;
				evidence4 = learningModel.pRuralAddress;
			}
			
			//studies business
			if (learningModel.studiesBusinessData.get(num-1).contains("Yes") == true) {
				variable5 = learningModel.studiesBusinessEntreprenuer;
				evidence5 = learningModel.pStudiesBusiness;
			}
			if (learningModel.studiesBusinessData.get(num-1).contains("No") == true) {
				variable5 = learningModel.noStudiesBusinessEntreprenuer;
				evidence5 = learningModel.pNoBusinessStudies;
			}
			
//			System.out.println("Index: "+num+"   Gender: "+learningModel.genderData.get(num-1)+"    variable1: "+variable1);
//			System.out.println("Index: "+num+"   Parent owns business: "+learningModel.parentBusinessData.get(num-1)+"    variable2: "+variable2);
//			System.out.println("Index: "+num+"   Has part-time job: "+learningModel.jobData.get(num-1)+"    variable3: "+variable3);
//			System.out.println("Index: "+num+"   Address: "+learningModel.addressData.get(num-1)+"    variable4: "+variable4);
//			System.out.println("Index: "+num+"   Studies Business: "+learningModel.studiesBusinessData.get(num-1)+"    variable5: "+variable5);
			
			probability1 = (variable1 * variable2 * variable3 * variable4 * variable5) * entrepreneurPrior / (evidence1 * evidence2 * evidence3 * evidence4 * evidence5);
			
			System.out.println("Index: "+num+"    Probability they are entreprenuer: "+probability1); 
			System.out.println(variable1);
			System.out.println(variable2);
			System.out.println(variable3);
			System.out.println(variable4);
			System.out.println(variable5);
			System.out.println(entrepreneurPrior);
			System.out.println(evidence1);
			System.out.println(evidence2);
			System.out.println(evidence3);
			System.out.println(evidence4);
			System.out.println(evidence5);
			
		}
		
		
		
	}

	
	
	
	
}




























