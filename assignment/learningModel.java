package assignment;

public class learningModel {
	
	int probability;
	
	public learningModel(int probability) {
		
		this.probability = probability;
		
	}
	
	public static void trainingModel() {
		fileInputAndOutput file = new fileInputAndOutput("/Users/35385/MLdata.csv");
		file.openFile();
		file.readFile(0);
		
		System.out.println(fileInputAndOutput.data[4]);
	}
}
