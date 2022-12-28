package Day2;

import Generals.FileReader;

public class RockPaperScissors1 {

	public static void main(String[] args) throws Exception {
		FileReader fR= new FileReader("C:\\Users\\Owner\\eclipse-workspace\\Advent-of-Code\\src\\Day2\\Input", ',');
		
		String data = fR.data;
		
		//System.out.print(data);
		
		//A - Rock - 1
		//B - Paper - 2
		//C - Scissors - 3
		//Loss - 0
		//Tie - 3
		//Win - 6
		
		//////PART 1//////
		//X - Rock
		//Y - Paper
		//Z - Scissors
		
		//////PART 2//////
		//X - Loss
		//Y - Tie
		//Z - Win
		
		//Answer//
		System.out.println(totalPoints(data, 1));
		
		//Answer//
		System.out.println(totalPoints(data, 2));
		
		
	}
	
	public static int totalPoints(String data, int num) {
		
		int total = 0;
		
		String chunk = data.substring(0, data.indexOf(","));
		data = data.substring(data.indexOf(",") +1);
		
		while(data.indexOf(',') != -1) {
			char opponent = chunk.charAt(0);
			char you = chunk.charAt(2);
			
			//System.out.print(chunk);
			if(num == 1) {
				total += determineWinnerPoints1(opponent, you);
			}
			else if(num == 2) {
				total += determineWinnerPoints2(opponent, you);
			}
			
			
			chunk = data.substring(0, data.indexOf(","));
			data = data.substring(data.indexOf(",") +1);
		}
		
		char opponent = chunk.charAt(0);
		char you = chunk.charAt(2);
		
		//System.out.print(chunk);
		
		if(num == 1) {
			total += determineWinnerPoints1(opponent, you);
		}
		else if(num == 2) {
			total += determineWinnerPoints2(opponent, you);
		}
		
		return total;
	}
	
	public static int determineWinnerPoints2(char a, char b) {
		if(a == 'A') {
			if(b == 'X') return 3 + 0; //Scissors + Loss
			if(b == 'Y') return 1 + 3; //Rock + Tie
			if(b == 'Z') return 2 + 6; //Paper + Win
		}
		if(a == 'B') {
			if(b == 'X') return 1 + 0; //Rock + Loss
			if(b == 'Y') return 2 + 3; //Paper + Tie
			if(b == 'Z') return 3 + 6; //Scissors + Win
		}
		if(a == 'C') {
			if(b == 'X') return 2 + 0; //Paper + Loss
			if(b == 'Y') return 3 + 3; //Scissors + Tie
			if(b == 'Z') return 1 + 6; //Rock + Win
		}
		return 0;
	}
	
	public static int determineWinnerPoints1(char a, char b) {
		if(a == 'A') {
			if(b == 'X') return 1 + 3; //Rock + Tie
			if(b == 'Y') return 2 + 6; //Paper + Win
			if(b == 'Z') return 3 + 0; //Scissors + Loss
		}
		if(a == 'B') {
			if(b == 'X') return 1 + 0; //Rock + Loss
			if(b == 'Y') return 2 + 3; //Paper + Tie
			if(b == 'Z') return 3 + 6; //Scissors + Win
		}
		if(a == 'C') {
			if(b == 'X') return 1 + 6; //Rock + Win
			if(b == 'Y') return 2 + 0; //Paper + Loss
			if(b == 'Z') return 3 + 3; //Scissors + Tie
		}
		return 0;
	}

}
