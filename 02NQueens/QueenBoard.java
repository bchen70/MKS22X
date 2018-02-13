public class QueenBoard{
  private int [][]board;
  private int size;
  public QueenBoard(int size){
    if (size <= 0){
      throw new IllegalArgumentException("Size cannot be less than 0");
    }
    this.size = size;
    board = new int [size][size];
  }
  public String toString(){
    String str = "";
    for (int r = 0; r < size; r ++){
      for (int c = 0; c < size; c++){
        if (board[r][c] == -1){
          str += "Q ";
        }
        else{
          str += "_ ";
        }
      }
      str += "\n";
    }
    return str;
  }
  private boolean addQueen(int r, int c){
    if (board [r][c] == 0){
      board[r][c] = -1;

      for(int i = c + 1;i < size; i ++){
        board[r][i] += 1;
      }
	    
      for (int i = r+1, x = c+1; i < size && x < size; i++, x++){
        board[i][x] += 1;
      }

      for (int i = r-1, x = c+1; i >= 0 && x < board.length; i--, x++){
        board[i][x] += 1;
      }	    
      return true;
    }
    return false;	
  }


  private boolean removeQueen(int r, int c) {
    if (board[r][c] != -1) {
      return false;
    }
    board[r][c]++;
    for (int i=1; c+i<size; i++){
      board[r][c+i]--;
      if (r+i<size){
        board[r+i][c+i]--;
      }
      if (r-i>=0){
        board[r-i][c+i]--;
      }
    }
    return true;
  }
  public boolean solve(){
     for (int r=0; r<size; r++){
	    for (int c=0; c<size; c++) {
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
	    }
     }
     return solveR(0);
  }

  public boolean solveR(int col){
    if (col ==  size){
	    return true;
    }
    for (int row = 0; row < size; row ++){
	    if(addQueen(row, col)){
        if(solveR(col + 1)){
          return true;
        }
        removeQueen(row,col);
	    }
    }
    return false;
  }

  public static void main(String[]args){
    QueenBoard b = new QueenBoard(4);

    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution


    try{
	    b.solve();
    }catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"
  }
}
