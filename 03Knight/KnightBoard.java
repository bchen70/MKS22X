public class KnightBoard{
    private int board[][];
    private int startingRows;
    private int startingCols;
    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 && startingCols < 0){
	    throw new IllegalArgumentException("Size cannot be less than 0");
	}
	this.startingRows = startingRows;
	this.startingCols = startingCols;
	board = new int [startingRows][startingCols];
    }
    
    public String toString(){
	String str = "";
	for (int r = 0; r < startingRows; r ++){
	    for (int c = 0; c < startingCols; c++){
		if (board[r][c] == -1){
		    str += "0";
		    //need to fix this part?? or idk??
		    // blank boards display 0's as underscores 
		    // you get a blank board if you never called solve or 
		    // when there is no solution  			 
		}
		else{
		    str += "_";
		}
	    }
	    str += "\n";
	}
	return str;
    }
    public boolean solve(int startingRow, int startingCol){
	for (int r=0; r < startingRows ; r++){
	    for (int c=0; c< startingCols; c++) {
		if (board[r][c] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(0,0,0);
    }
    // public int countSolutions(int startingRow, int startingCol){
    // }
    private boolean solveH(int row ,int col, int level){
	if (col == startingCols){
	    return true;
	}
	return false;
    }
    public static void main(String[]args){
	KnightBoard b = new KnightBoard(4,3);
	System.out.println(b);
    }
}
