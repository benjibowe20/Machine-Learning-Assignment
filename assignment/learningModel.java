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
	double yesPrior;
	double noPrior;
	
	public learningModel(int probability) {
		
		this.probability = probability;
		
	}
	
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
			//System.out.println(fileInputAndOutput.data[i]);
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
		
		//System.out.println(randomArrayIndexes);
		
		
	}
	
	public static void priorProbability () {
		
		double yesPrior = 0;
		double noPrior = 0;
		double totalCount = randomArrayIndexes.size();
		double yesCount = 0;
		double noCount = 0;
		
		//System.out.println("Number of entries: "+totalCount);
		
		for (int a = 0; a < totalCount ; a++) {
			int num = randomArrayIndexes.get(a);
			if (entreprenuerData.get(num) == "Yes") {
				yesCount = yesCount + 1;
			}
			if (entreprenuerData.get(num) == "No") {
				noCount = noCount + 1;
			}
		}
		
		yesPrior = yesCount/totalCount;
		noPrior = noCount/totalCount;
		
		System.out.println("Prior probability of Yes: "+yesPrior);
		System.out.println("Prior probability of No: "+noPrior);
	}
	
	public static void evidentialProbability() {
		
		double totalCount = randomArrayIndexes.size();
		double pMale = 0;
		double pFemale = 0;
		double pParentHasBusiness = 0;
		double pParentHasNoBusiness = 0;
		double maleCount = 0;
		double parentHasBusinessCount = 0;
		double hasJobCount = 0;
		double urbanAddressCount = 0;
		double studiesBusinessCount = 0;
		
		for (int a = 0; a < totalCount ; a++) {
			int num = randomArrayIndexes.get(a);
			if (genderData.get(num) == "Male") {
				maleCount = maleCount + 1;
			}
		}
		
		for (int a = 0; a < totalCount ; a++) {
			int num = randomArrayIndexes.get(a);
			if (parentBusinessData.get(num) == "Yes") {
				parentHasBusinessCount = parentHasBusinessCount + 1;
				System.out.println("meowwwwww"+parentHasBusinessCount);
			}
		}
		for (int a = 0; a < totalCount ; a++) {
			int num = randomArrayIndexes.get(a);
			if (jobData.get(num) == "Yes") {
				hasJobCount = hasJobCount + 1;
			}
		}
		for (int a = 0; a < totalCount ; a++) {
			int num = randomArrayIndexes.get(a);
			if (addressData.get(num) == "Urban") {
				urbanAddressCount = urbanAddressCount + 1;
			}
		}
		for (int a = 0; a < totalCount ; a++) {
			int num = randomArrayIndexes.get(a);
			if (studiesBusinessData.get(num) == "Yes") {
				studiesBusinessCount = studiesBusinessCount + 1;
			}
		}
		
		pMale = maleCount/totalCount;
		pFemale = 1-pMale;
		System.out.println(parentBusinessData);
		pParentHasBusiness = parentHasBusinessCount/totalCount;
		pParentHasNoBusiness = 1-pParentHasBusiness;
		
		System.out.println("Male Probability: "+pMale);
		System.out.println("Female Probability: "+pFemale);
		System.out.println("Parent has Business probability: "+pParentHasBusiness);
		System.out.println("Parent doesnt have Business probability: "+pParentHasNoBusiness);
		
		
	}
}




















