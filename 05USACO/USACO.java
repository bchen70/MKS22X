import java.io.*;
import java.util.*;

public class USACO{
    public static int bronze(String filename){
	File line = new File(filename);
	try {
	    Scanner input = new Scanner(line);
	    
	    int row = input.nextInt();
	    int cols = input.nextInt();
	    int depth = input.nextInt();
	    int com = input.nextInt();

	    int[][] lake  = new int[row][cols];
	    for (int i = 0; i <rows;i++){
		for (int x = 0; x < cols; x ++){
		    lake[i][x] = input.nextInt();
		}
	    }
	    for (int x= 0; x< com; x++){
		stomp(input.nextInt(),input.nextInt(),input.netInt());
	    }

	}
	catch (FileNotFoundException e){
	    System.out.println("File not found.");
	}
    }
    
    public void stomp(int row,int col, int level){
	int max = lake[row- 1][col - 1];
	for (int i = row; i < row + 3; i ++){
	    for (int j = col; j < col +3; j++){
		if (lake[i - 1][j-1] > max){
		    max = lake[i - 1][j - 1];
		}
	    }
	}
	for (int x = row; x < row + 3; x++){
	    for (int y = col; y < col + 3; y++){
		if(lake[x - 1][y - 1] > max - level){
		    lake [x-1][y-1] = max - level;
		}
	    }
	}
    }
    
    public static int silver(String filename){
	
    }
}
