public class KnightBoard{
    private int board[][];
    public KnightBoard(int startingRows,int startingCols){
	if (startingRows < 0 && startingCols < 0){
	    throw new IllegalArgumentException("Size cannot be less than 0");
	}
	board = new int [startingRows][startingCols];
    }
    
    // public String toString(){
    // }
    // public boolean solve(int startingRow, int startingCol){
    // }
    // public int countSolutions(int startingRow, int startingCol){
    // }
    // private boolean solveH(int row ,int col, int level){
    // }
    public static void main(String[]args){
	KnightBoard b = new KnightBoard(4,3);
	System.out.println(b);
    }
}
