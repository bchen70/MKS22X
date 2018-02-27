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
      try{
        if (board[row+i[0]][col+ i[1]] == 0){
          board[row][col] = level;
          total += countSolutionsH(row+i[0],col+i[1], level + 1);
          board[row][col] = 0; 
        }
      }
        catch (Exception e){}
    }
    
    return total;
  }
  
 public static void main(String[] args){
    KnightBoard a = new KnightBoard(3,3);

    System.out.println(a);
    /* Prints
      _ _ _
      _ _ _
      _ _ _
    */

    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (a.solve(i,j)){
          System.out.println("There is an error with your solve method");
        }
      }
    } //prints nothing

    System.out.println(a.countSolutions(0,0)); //prints 0



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"



    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
    }
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        totalSol += c.countSolutions(i,j);
      }
    }

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
    System.out.println(d.countSolutions(0,0)); //prints 304

  }
}
