package assignment;

import java.util.ArrayList;
import java.util.Random;

public class learningModel {
	
	int probability;
	int i = 0;
	static ArrayList<String> studiesBusinessData = new ArrayList<String>();
	static ArrayList<String> genderData = new ArrayList<String>();
	static ArrayList<String> parentBusinessData = new ArrayList<String>();
	static ArrayList<String> jobData = new ArrayList<String>();
	static ArrayList<String> addressData = new ArrayList<String>();
	static ArrayList<String> entreprenuerData = new ArrayList<String>();
	static ArrayList<Integer> randomArrayIndexes = new ArrayList<Integer>();
	static ArrayList<Integer> testDataIndexes = new ArrayList<Integer>();
	
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
	
	
	
	public static void collectData() {
		fileInputAndOutput file = new fileInputAndOutput("/Users/35385/MLdata.csv");
		file.openFile();
		file.readFile(0);
		
		
		for (int i = 5; i < fileInputAndOutput.data.length;) {
			//System.out.println(fileInputAndOutput.data[i]);
			studiesBusinessData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
		for (int i = 6; i < fileInputAndOutput.data.length;) {
			//System.out.println(fileInputAndOutput.data[i]);
			if (fileInputAndOutput.data[i].contains("Yes")) {
				entreprenuerData.add("Yes");
			}
			if (fileInputAndOutput.data[i].contains("No")) {
				entreprenuerData.add("No");
			}
			i = i+5;
		}
		for (int i = 1; i < fileInputAndOutput.data.length;) {
			//System.out.println(fileInputAndOutput.data[i]);
			if (fileInputAndOutput.data[i].contains("Female")) {
				genderData.add("Female");
			}
			if (fileInputAndOutput.data[i].contains("Male")) {
				genderData.add("Male");
			}
			i = i+5;
		}
		
		for (int i = 2; i < fileInputAndOutput.data.length;) {
			parentBusinessData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
		for (int i = 3; i < fileInputAndOutput.data.length;) {
			//System.out.println(fileInputAndOutput.data[i]);
			jobData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
		
		for (int i = 4; i < fileInputAndOutput.data.length;) {
			//System.out.println(fileInputAndOutput.data[i]);
			addressData.add(fileInputAndOutput.data[i]);
			i = i+5;
		}
			
//		System.out.println("Studies business data: "+studiesBusinessData);
//		System.out.println("Becomes Entreprenuer data: "+entreprenuerData);
//		System.out.println("Gender data: "+genderData);
//		System.out.println("Parent business data: "+parentBusinessData);
//		System.out.println("Address data: "+addressData);
//		System.out.println("Part-time job data: "+jobData);
		
	}
	
	public static void getEntriesForTraining() {
		
		double numberOfEntries = entreprenuerData.size();
		double get70Percent = numberOfEntries * 0.7;
		int rounded = (int) get70Percent;
		int num;
		
//		System.out.println("Number of entries: "+numberOfEntries);
//		System.out.println("70% of entries: "+get70Percent);
//		System.out.println("Rounded 70%: "+rounded);
		
		for (int i = 1; i <= rounded ;i ++) {
			num = (int) (Math.floor(Math.random()*numberOfEntries));
			while (randomArrayIndexes.contains(num)==true ) {
				num = (int) (Math.floor(Math.random()*numberOfEntries));
			}
			randomArrayIndexes.add(num);
			
		}
		
		for (int i = 1; i <= numberOfEntries; i++) {
			if (randomArrayIndexes.contains(i) == false) {
				testDataIndexes.add(i);
			}
		}
		
//		System.out.println(randomArrayIndexes);
//		System.out.println(testDataIndexes);
		
		
	}
	
	public static void priorProbability () {
		
		double countAll = randomArrayIndexes.size();
		
//		System.out.println("Number of entries: "+countAll);
		
		for (int a = 0; a < countAll ; a++) {
			int num = randomArrayIndexes.get(a);
			if (entreprenuerData.get(num) == "Yes") {
				yesCount = yesCount + 1;
			}
			if (entreprenuerData.get(num) == "No") {
				noCount = noCount + 1;
			}
		}
		
//		System.out.println(yesCount);
		
		yesPrior = yesCount/countAll;
		noPrior = noCount/countAll;
		
//		System.out.println("Prior probability of Yes: "+yesPrior);
//		System.out.println("Prior probability of No: "+noPrior);
	}
	
	public static void evidentialProbability() {
		
		double totalCount = randomArrayIndexes.size();
		double maleCount = 0;
		double parentHasBusinessCount = 0;
		double hasJobCount = 0;
		double urbanAddressCount = 0;
		double studiesBusinessCount = 0;
		for (int a = 0; a < totalCount ; a++) {
			int num1 = randomArrayIndexes.get(a);
			if (genderData.get(num1).contains("Male") == true) {
				maleCount = maleCount + 1;
			}
		}
		
		for (int b = 0; b < totalCount ; b++) {
			int num2 = randomArrayIndexes.get(b);
			if (parentBusinessData.get(num2).contains("Yes") == true) {
				parentHasBusinessCount = parentHasBusinessCount + 1;
			}
		}
		for (int c = 0; c < totalCount ; c++) {
			int num3 = randomArrayIndexes.get(c);
			if (jobData.get(num3).contains("Yes") == true) {
				hasJobCount = hasJobCount + 1;
			}
		}
		for (int d = 0; d < totalCount ; d++) {
			int num4 = randomArrayIndexes.get(d);
			if (addressData.get(num4).contains("Urban") == true) {
				urbanAddressCount = urbanAddressCount + 1;
			}
		}
		for (int f = 0; f < totalCount ; f++) {
			int num5 = randomArrayIndexes.get(f);
			if (studiesBusinessData.get(num5).contains("Yes") == true) {
				studiesBusinessCount = studiesBusinessCount + 1;
			}
		}
		
		pMale = maleCount/totalCount;
		pFemale = 1-pMale;
		
		System.out.println(maleCount);
		
		pParentHasBusiness = parentHasBusinessCount/totalCount;
		pParentHasNoBusiness = 1-pParentHasBusiness;
		
		pHasJob = hasJobCount/totalCount;
		pHasNoJob = 1 - pHasJob;
		
		pUrbanAddress = urbanAddressCount/totalCount;
		pRuralAddress = 1 - pUrbanAddress;
		
		pStudiesBusiness = studiesBusinessCount/totalCount;
		pNoBusinessStudies = 1 - pStudiesBusiness;
		
//		System.out.println("Male Probability: "+pMale);
//		System.out.println("Female Probability: "+pFemale);
//		System.out.println("Parent has Business probability: "+pParentHasBusiness);
//		System.out.println("Parent doesnt have Business probability: "+pParentHasNoBusiness);
//		System.out.println("Has a part-time job probability: "+pHasJob);
//		System.out.println("Doesnt have a part time job probability: "+pHasNoJob);
//		System.out.println("Urban Address Probability: "+pUrbanAddress);
//		System.out.println("Rural Address Probability: "+pRuralAddress);
//		System.out.println("Studies business probability: "+pStudiesBusiness);
//		System.out.println("No business studies: "+pNoBusinessStudies);
		
		//System.out.println("Male Count: "+maleCount);
	}
	
	public static void computeLiklihoods() {
		
		double totalCount = randomArrayIndexes.size();
		
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
		
//		System.out.println("Probability male given entreprenuer: "+maleGivenEntreprenuer);
//		System.out.println("Probability female given entreprenuer: "+femaleGivenEntreprenuer);
//		System.out.println("\n");
//		System.out.println("Probability studies business given entreprenuer: "+studiesBusinessEntreprenuer);
//		System.out.println("Probability doesnt study business given entreprenuer: "+noStudiesBusinessEntreprenuer);
//		System.out.println("\n");
//		System.out.println("Probability urban address given entreprenuer: "+urbanEntreprenuer);
//		System.out.println("Probability rural address given entreprenuer: "+ruralEntreprenuer);
//		System.out.println("\n");
//		System.out.println("Probability has job given entreprenuer: "+hasJobEntrepreneur);
//		System.out.println("Probability has no job given entreprenuer: "+hasNoJobEntrepreneur);
//		System.out.println("\n");
//		System.out.println("Probability parent has business given entreprenuer: "+parentBusinessEntrepreneur);
//		System.out.println("Probability parent has no business given entreprenuer: "+noParentBusinessEntrepreneur);
//		System.out.println("\n");
		
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
		
//		System.out.println("------------------------------------------------------------------------------");
//		System.out.println("\n");
//		System.out.println("Probability male given not entreprenuer: "+maleGivenNotEntreprenuer);
//		System.out.println("Probability female given not entreprenuer: "+femaleGivenNotEntreprenuer);
//		System.out.println("\n");
//		System.out.println("Probability studies business given not entreprenuer: "+studiesBusinessNotEntreprenuer);
//		System.out.println("Probability doesnt study business given not entreprenuer: "+noStudiesBusinessNotEntreprenuer);
//		System.out.println("\n");
//		System.out.println("Probability urban address given not entreprenuer: "+urbanNotEntreprenuer);
//		System.out.println("Probability rural address given not entreprenuer: "+ruralNotEntreprenuer);
//		System.out.println("\n");
//		System.out.println("Probability has job given not entreprenuer: "+hasJobNotEntrepreneur);
//		System.out.println("Probability has no job given not entreprenuer: "+hasNoJobNotEntrepreneur);
//		System.out.println("\n");
//		System.out.println("Probability parent has business given not entreprenuer: "+parentBusinessNotEntrepreneur);
//		System.out.println("Probability parent has no business given not entreprenuer: "+noParentBusinessNotEntrepreneur);
		
		
	}
	
}




















