package Day3;

import Generals.FileReader;

public class RuckSack {

	public static void main(String[] args) throws Exception {
		FileReader fR = new FileReader("C:\\Users\\Owner\\eclipse-workspace\\Advent-of-Code\\src\\Day3\\Input", ','); 
		
		String[] data = fR.explode();
		
		//////Part 1//////
		int total = 0;
		
		for(String line : data) {
			total += getPriority(findCommonOnLine(line));
		}
		
		//Answer//
		System.out.println(total);

		///////Part 2///////
		total = 0;
		
		int numLines = 3;
		String[] lines = new String[numLines];
		
		for(int i = 0; i < data.length; i++) {		
			
			
			
			if(i != 0 && i % numLines == 0) total += getPriority(findCommonOnLines(lines));
			
			lines[i % numLines] = data[i];
			//System.out.println(lines[i % numLines]);
		
		}
		
		lines[(data.length-numLines) % (numLines)] = data[data.length - numLines];
		lines[(data.length-numLines) % (numLines + 1)] = data[data.length - numLines + 1];
		lines[(data.length-numLines) % (numLines + 2)] = data[data.length - numLines + 2];
		
		total += getPriority(findCommonOnLines(lines));
		
		//Answer//
		System.out.println(total);
	}
	
	//Gets the priority value of the char being sent
	public static int getPriority(char c) {
		
		int priority= c - 'a';
		
		if(priority >= 0) return priority +1;
		else return priority + 59;
	}
	
	//Finds common char on both sides of a lines input
	public static char findCommonOnLine(String ln) {
		
		String first = ln.substring(0, ln.length()/2);
		String second = ln.substring(ln.length()/2);
		
		for (int f = 0; f < first.length(); f++) {
			for(int s = 0; s < second.length(); s++) {
				if(first.charAt(f) == second.charAt(s)) return first.charAt(f);
			}
		}
		
		return '?';
	}
	
	//Finds common char on the number of a lines from the input
	public static char findCommonOnLines(String[] lns) {
		
		for(int f = 0; f < lns[0].length(); f++) {
			
			for(int s = 0; s < lns[1].length(); s++) {
				
				for(int t = 0; t < lns[2].length(); t++) {
					
					if(lns[0].charAt(f) == lns[1].charAt(s) && lns[1].charAt(s) == lns[2].charAt(t)) 
						return lns[1].charAt(s);
				}
			}
		}
		
		return '?';
	}

}
