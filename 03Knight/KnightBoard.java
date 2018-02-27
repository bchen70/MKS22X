public class KnightBoard{
  private int board[][];
  private int rows;
  private int cols;
  private final int[][] move = {{-1,-2}, {-1,2}, {1,-2}, {1,2}, {-2,-1}, {-2,1}, {2,-1}, {2,1}};
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
          str += "_ ";
        }
        else if (board[r][c] < 10){
          str += " "+ board[r][c] + " ";
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

  private boolean solveH(int row ,int col, int level){
    if (level > rows * cols ){
	    return true;
    }
    for (int i[]: move){
	    try{
        if (board[row][col] == 0){
          board[row][col] = level;
          if(solveH(row+i[0],col+i[1], level + 1)){
            return true;
          }

          else{
            board[row][col] = 0;
          }
        }		
	    }catch(Exception e){}
    }
    return false;
  }
  
  public int countSolutions(int startingRow, int startingCol) {
    if (startingRow < 0 || startingCol < 0) {
 	    throw new IllegalArgumentException();
    }
    
    for(int x = 0; x < board.length; x++) {
	    for(int y = 0; y < board[x].length; y++){
        if(board[x][y] != 0){
          throw new IllegalStateException();
        }
	    }
    }
	
    return countSolutionsH(startingRow, startingCol, 1);
  }

  public int countSolutionsH(int row, int col, int level){
    int total = 0;
    if (rows * cols == level){
      return 1;
    }
    for (int i[]: move){
      if (board[row+i[0]][col+i[1]] == 0){
		    board[row][col] = level;
		    total += countSolutionsH(row+i[0],col+i[1], level + 1);
        board[row][col] = 0; 
      }
    }
    return total;
  }
  
  public static void main(String[] args){
  }
 

  
  //5x5 = 304
  //add all count soltuions 1728
}
