package Generals;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	
	public String data;
	private char seperator;

	public FileReader(String fP, char sep) throws Exception {
		this.seperator = sep;
		this.data = Reader(fP);
	}
	
	public String Reader(String filePath) throws Exception {
		
		String result = "";
		
		char sep = this.seperator;
		
		File file = new File(filePath);
		
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			result += sc.nextLine() + sep;
		}
		
		return result;
	}
	
	//Makes an array with each separate line of the input as a point in the array
	public String[] explode(){
		
		String[] data = new String[this.numOfIndexes()];
		
		String tempData = this.data;
		
		for(int i = 0; i < data.length; i++) {
			data[i] = tempData.substring(0, tempData.indexOf(this.seperator));
			
			tempData = tempData.substring(tempData.indexOf(this.seperator) +1);
		}
		
		return data;
	}
	
	//Checks how many instances of the separator there are
	public int numOfIndexes() {
		int total = 0;
		
		String tempData = this.data;
		
		while(tempData.indexOf(this.seperator) != -1) {
			
			total++;
			
			tempData = tempData.substring(tempData.indexOf(this.seperator) +1);
			
		}
		
		return total;
	}

}
