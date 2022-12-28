package Day5;

import Generals.FileReader;

public class CraneMovement {

	public static void main(String[] args) throws Exception {
		FileReader fRF = new FileReader("C:\\Users\\Owner\\eclipse-workspace\\Advent-of-Code\\src\\Day5\\BoxGrid", ',');
		FileReader fRS = new FileReader("C:\\Users\\Owner\\eclipse-workspace\\Advent-of-Code\\src\\Day5\\MovementInput", ',');
		
		Grid crateBoard = new Grid(fRF.explode(), 9, ' ');
		Integer[][] data = makeInstructions(fRS.explode());
		
		////Part 1/////
		
		/*
		for(int i = 0; i < data.length; i++) {
			
			//Last board is the answer
			crateBoard.printGrid();
			System.out.println(i +1);

			crateBoard.moveGrid(data[i]);
			
			System.out.println("");
		}
		*/
		
		////Part 2////
		
		
		crateBoard = new Grid(fRF.explode(), 9, ' ');
		
		for(int i = 0; i < data.length ; i++) {
			//Last board is the answer
			crateBoard.printGrid();
			
			System.out.println(i +1);
			
			crateBoard.multiMoveGrid(data[i]);
			
			System.out.println("");
			
		}
	}

	//Creates a 2D array of numbers containing movement instructions
	public static Integer[][] makeInstructions(String[] data){
		Integer[][] instructions = new Integer[data.length][3];
		
		for(int row = 0; row < instructions.length; row++) {
			instructions[row] = convertInstructions(data[row]);
		}
		
		return instructions;
	}
	
	//Makes a instruction line into a single integer array
	public static Integer[] convertInstructions(String line) {
		Integer[] nums = new Integer[3];
		
		String howMany = line.substring(line.indexOf(" ") +1, line.indexOf(" from"));
		line = line.substring(line.indexOf("from"));
		
		String fColumn = line.substring(line.indexOf(" ") +1, line.indexOf(" to"));
		line = line.substring(line.indexOf("to"));
		
		String sColumn = line.substring(line.indexOf(" ") +1);
		
		nums[0] = Integer.parseInt(howMany);
		nums[1] = Integer.parseInt(fColumn);
		nums[2] = Integer.parseInt(sColumn);
		
		return nums;
	}

}
