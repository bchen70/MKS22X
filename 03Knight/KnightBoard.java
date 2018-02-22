public class KnightBoard{
    private int board[][];
    private int rows;
    private int cols;
    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 && startingCols < 0){
	    throw new IllegalArgumentException("Size cannot be less than 0");
	}
	rows = startingRows;
	cols = startingCols;
	board = new int [startingRows][startingCols];
    }
    
    public String toString(){
	String str = "";
	for (int r = 0; r < rows; r ++){
	    for (int c = 0; c < cols; c++){
		if (board[r][c] == 0){
		    str += "_";
		    //need to fix this part?? or idk??
		    // blank boards display 0's as underscores 
		    // you get a blank board if you never called solve or 
		    // when there is no solution  			 
		}
		else{
		    str += board[r][c]+ " ";
		}
	    }
	    str += "\n";
	}
	return str;
    }
    public boolean solve(int startingRow, int startingCol){
	if (startingRow >= rows || startingRow < 0){
	    throw new IllegalArgumentException();
	}
	if (startingCol >= cols || startingCol < 0){
	    throw new IllegalArgumentException();
	}
	for (int r=0; r < rows ; r++){
	    for (int c=0; c< cols; c++) {
		if (board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow,startingCol,1);
    }
    // public int countSolutions(int startingRow, int startingCol){
    // }
    private boolean solveH(int row ,int col, int level){
	if (col == cols){
	    return true;
	}
	return false;
    }
    public static void main(String[]args){
	KnightBoard b = new KnightBoard(4,3);
	System.out.println(b);
    }
    //5x5 = 304
    //add all count soltuions 1728
}
