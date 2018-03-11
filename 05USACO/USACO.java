import java.io.*;
import java.util.*;

public class USACO{
    public static void main(String[] args){
	System.out.println(USACO.bronze("bronze1.dat"));	
    }
    public static int bronze(String filename){
	File line = new File(filename);
	int lake[][];
	int row,col,depth,com;
	try {
	    Scanner input = new Scanner(line);
	    row = input.nextInt();
	    col = input.nextInt();
	    depth = input.nextInt();
	    com = input.nextInt();
	    lake  = new int[row][col];
	    
	    for (int i = 0; i <row;i++){
		for (int x = 0; x < col; x ++){
		    if(input.hasNextInt()){
			lake[i][x] = input.nextInt();
		    }
		}		
	    }
	    for (int x= 0; x< com; x++){
		if (input.hasNextInt()){
		    stomp(input.nextInt()-1,input.nextInt()-1,input.nextInt(),lake);
		}
	    }
	    
	    int aggDepth = 0;
	    for (int i=0; i<row; i++){
		for (int j=0; j<col; j++){
		    if (lake[i][j] < depth){
			aggDepth +=  depth - lake[i][j];
		    }
		}
	    }
	    return aggDepth * 72 * 72;
	    
	}catch (FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(1);
	}
	return 0;
    }
    
    public static void stomp(int row,int col, int depth, int[][]lake){
	int max = 0;
	for (int i = row; i < row + 3; i ++){
	    for (int j = col; j < col +3; j++){
		if (lake[i][j] > max){
		    max =lake[i][j];
		}
	    }
	}
	for (int x = row; x < row + 3; x++){
	    for (int y = col; y < col + 3; y++){
		if(lake[x][y] > max - depth){
		    lake [x][y] = max - depth;
		}
	    }
	}
    }
  

    public static int silver(String filename){
	return 0;
    }
}
