package Day1;

import java.util.ArrayList;

import Generals.FileReader;

public class Calories1 {

	public static void main(String[] args) throws Exception {
		FileReader fR= new FileReader("C:\\Users\\Owner\\eclipse-workspace\\Advent-of-Code\\src\\Day1\\Input", ',');
		
		String data = fR.data;
		
		//System.out.println(data);
		
		ArrayList<Integer> sortedData = sort(data);
		
		//System.out.print(sortedData);
		
		int index = findMax(sortedData);
		
		//Answer//
		System.out.println(index);
		System.out.println(sortedData.get(index));
		
		/////For part 2
		sortedData.remove(index);
		
		index = findMax(sortedData);
		
		//Answer//
		System.out.println(index);
		System.out.println(sortedData.get(index));
		
		sortedData.remove(index);
		
		index = findMax(sortedData);
		
		//Answer//
		System.out.println(index);
		System.out.println(sortedData.get(index));
	
	}
	
	public static ArrayList<Integer> sort(String data) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//Keeps checking data string until it is empty
		while(data != ""){
			//System.out.print(data);
			
			//Every first chunk of a new section will be taken out of the data
			String chunk = data.substring(0, data.indexOf(","));
			data = data.substring(data.indexOf(",") +1);
			
			int total = 0;
			
			//Checks until the chunk becomes an empty string
			//This means its the end of a section
			while(chunk != "") {
				
				
				total += Integer.parseInt(chunk);
				
				if(data.indexOf(",") != -1) {
					chunk = data.substring(0, data.indexOf(","));
					data = data.substring(data.indexOf(",") +1);
				}
				else {
					chunk = "";
				}
			}
			
			
			result.add(total);
			
		}
		
		
		return result;
	}

	public static int findMax(ArrayList<Integer> data) {
		int index = 0;
		
		int maxNum = data.get(0);
		
		for(int i = 0; i < data.size(); i++) {
			if(data.get(i) > maxNum) {
				index = i;
				maxNum = data.get(i);
			}
		}
		
		return index;
	}
}
