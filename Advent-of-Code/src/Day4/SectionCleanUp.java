package Day4;

import Generals.FileReader;

public class SectionCleanUp {

	public static void main(String[] args) throws Exception {
		FileReader fR = new FileReader("C:\\Users\\Owner\\eclipse-workspace\\Advent-of-Code\\src\\Day4\\Input", ' ');
		
		String[] data = fR.explode();
		
		//////Part 1//////
		
		int count = 0;
		
		for(String line : data) {
			if(isContained(makeRange(line))) count++;
		}
		
		//Answer
		System.out.println(count);
		
		//////Part 2//////
		
		count = 0;
		
		for(String line : data) {
			if(isOverLap(makeRange(line))) count++;
		}
		
		System.out.println(count);
	}
	
	//Makes the given string line into a an integer array containing the ranges
	public static int[] makeRange(String ln) {
		int[] ranges = new int[4];
		
		String firstR = ln.substring(0, ln.indexOf(','));
		String secondR = ln.substring(ln.indexOf(',') +1, ln.length());
		
		int firstFR = Integer.parseInt(firstR.substring(0, firstR.indexOf('-')));
		int secondFR = Integer.parseInt(firstR.substring(firstR.indexOf('-') +1, firstR.length()));
		
		int firstSR = Integer.parseInt(secondR.substring(0, secondR.indexOf('-')));
		int secondSR = Integer.parseInt(secondR.substring(secondR.indexOf('-') +1, secondR.length()));
		
		ranges[0] = firstFR;
		ranges[1] = secondFR;
		ranges[2] = firstSR;
		ranges[3] = secondSR;
		
		return ranges;
	}
	
	//Returns true if one side is contained in the other
	public static boolean isContained(int[] ranges) {
		return ( ranges[0] <= ranges[2] && ranges[1] >= ranges[3] ) || ( ranges[2] <= ranges[0] && ranges[3] >= ranges[1] );
	}
	
	//Returns true if one range over laps the other
	public static boolean isOverLap(int[] ranges) {
		for(int f = ranges[0]; f <= ranges[1]; f++) {
			for(int s = ranges[2]; s <= ranges[3]; s++) {
				if(f == s) return true;
			}
		}
		
		return false;
	}

}
