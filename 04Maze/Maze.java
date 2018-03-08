import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int[][]x = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	int row = 0;
	int col = 0;
	String str = "";
	
	File text = new File(filename);
	Scanner inf = new Scanner(text);
	while (inf.hasNextLine()){
	    String line = inf.nextLine();
	    col = line.length();
	    row ++;
	    str += line;
	}
	maze = new char[row][col];

	int num = 0;
	int countS = 0;
	int countE = 0;
	for (int r = 0; r < row ; r++){
	    for (int c = 0; c < col ; c ++){
		maze[r][c] = str.charAt(num);
		if (str.charAt(num) == 'S'){
		    countS ++;
		}
		if (str.charAt(num) == 'E'){
		    countE ++;
		}
		num ++;
	    }
	}
	if (countS !=  1 || countE != 1){
	    throw new IllegalStateException("Only use exactly one S and exactly one E");
	}
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
	int row = 0;
	int col = 0;
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[0].length; c++){
		if (maze [r][c] == 'S'){
		    return solve(row,col,0);
		}
	    }
	}

	//erase the S
	maze[row][col] = ' ';
	
	return -1;
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int count){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

        //COMPLETE SOLVE
	if (maze [row][col] == 'E'){
	    return count;
	}

	for (int i[]:x){
	    int nrow = row + i[0];
	    int ncol = col + i[1];
	    char nloc = maze[nrow][ncol];
	    if (nloc == ' ' || nloc == 'E'){
		maze[row][col] = '@';
		int psol = solve(nrow, ncol, count + 1);
		if (psol == -1 ) maze[nrow][ncol] = '.';
		else return psol;
	    }
	}
	return -1;
    }
    public String toString(){
	
	String ans="";
	for(int r=0;r<maze.length;r++){
	    for(int c=0;c<maze[0].length;c++){
		ans+=maze[r][c];
	    }
	    ans+= "\n";
	}
	return ans;
    }
}
