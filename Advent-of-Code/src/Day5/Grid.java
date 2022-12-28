package Day5;

import java.util.ArrayList;

//An object to help organize the grid used in this problem
public class Grid {
	
	public ArrayList<String[]> board;
	
	public Grid(String[] lines, int boxNum, char sep) {
		this.board = makeGrid(lines, boxNum, sep);
	}
	
	//Makes a 2D array from a give array
	public ArrayList<String[]> makeGrid(String[] data, int boxNum , char sep){
			
		ArrayList<String[]> grid = new ArrayList<String[]>();
			
		int boxLength = data[0].length() / boxNum;
		

		for(int row = 0; row < data.length; row++) {
			
			String[] columns = new String[boxNum];
			
			for(int col = 0; col < boxNum; col++) {
				
				columns[col] = data[row].substring(0, boxLength);
				
				if(data[row].length() > boxLength) data[row] = data[row].substring(boxLength +1);
			
			}
			grid.add(columns);
		}
		
		return grid;
	}
	
	//Prints out the grid for debugging
	public void printGrid() {
		for(int row = 0; row < this.board.size(); row++) {
			
			for(int col = 0; col < this.board.get(row).length; col++){
				
				System.out.print(this.board.get(row)[col] + " ");
			}
			
			System.out.println("");
		}
	}
	
	//Moves boxes on the grid based on the instruction line provided
	public void moveGrid(Integer[] line){
		
		for(int i = 0; i < line[0]; i++) {
			
			
			//New Coordinates in computer terms
			int newCol = line[2] -1;
			int newRow = highestInCol(newCol) -1;
			
			//Old spot coordinates in computer terms
			int oldCol = line[1] -1;
			int oldRow = highestInCol(oldCol);
			
			String crate = this.board.get(oldRow)[oldCol];
			
			//System.out.println(crate);
			
			this.board.set(oldRow, removeCrate(this.board.get(oldRow), oldCol));
			
			if(this.checkTopRow()) {
				this.board.remove(0);
				newRow--;
			}
			
			if(newRow == -1) {
				this.board.add(0, emptyStringArray());
				newRow++;
			}
			
			this.board.set(newRow, this.addCrate(this.board.get(newRow), crate, newCol));
			
			this.printGrid();
			System.out.println("");
			
		}
		
		System.out.println("");
		
	}
	
	//Finds highest position of a crate in the grid
	public int highestInCol(int column) {
		
		for(int i = 0; i < this.board.size(); i++) {
			//System.out.println(i);
			//System.out.println(this.board.size() + " Size");
			if(this.board.get(i)[column].indexOf("[") != -1) return i;
		}
		
		return this.board.size();
	}
	
	//Checks if the top row in the grid is empty
	public boolean checkTopRow() {

		boolean check = true;
		
		for(int i = 0; i < this.board.get(0).length; i++) {
			if(this.board.get(0)[i].indexOf("[") != -1) check = false;
		}
		
		return check;
		
	}

	//Creates an empty String array if the grid increases
	public String[] emptyStringArray() {
		String[] newRow = new String[this.board.get(0).length];
		
		for(int i = 0; i < newRow.length; i++) {
			newRow[i] = "   ";
		}
		
		return newRow;
	}

	//Removes a crate at the given position
	public String[] removeCrate(String[] line, int col) {
		
		line[col] = "   ";
		
		return line;
	}
	
	//Adds a crate to the given position
	public String[] addCrate(String[] line, String crate, int col) {
		
		line[col] = crate;
		
		return line;
	}

	//Moves boxes from one column all at once
	public void multiMoveGrid(Integer[] nums) {
		
		for(int i = 0; i < nums[0]; i++) {
			
			//New Coordinates in computer terms
			int newCol = nums[2] -1;
			int newRow = highestInCol(newCol) -1;
			
			//Old spot coordinates in computer terms
			int oldCol = nums[1] -1;
			int oldRow = highestInCol(oldCol) + nums[0]-1 - i;
			
			String crate = this.board.get(oldRow)[oldCol];
			
			//System.out.println(crate);
			
			this.board.set(oldRow, removeCrate(this.board.get(oldRow), oldCol));
			
			if(this.checkTopRow()) {
				this.board.remove(0);
				newRow--;
			}
			
			if(newRow == -1) {
				this.board.add(0, emptyStringArray());
				newRow++;
			}
			
			this.board.set(newRow, this.addCrate(this.board.get(newRow), crate, newCol));
			
			this.printGrid();
			System.out.println("");
			
		}
		
		System.out.println("");
	}
}
