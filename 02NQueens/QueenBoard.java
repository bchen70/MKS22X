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
		if (board[r][c] == 1){
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
    // private boolean addQueen(int r, int c){
    // }
    //  private boolean removeQueen(int r, int c){
    // }

    public static void main(String[] args){
	QueenBoard x = new QueenBoard(3);
	System.out.println(x);
    }
}
