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
		stomp(input.nextInt(),input.nextInt(),input.netInt()));
	    // need to write stomp btw
	}
	catch (FileNotFoundException e){
	    System.out.println("File not found.");
	}
    }
	       

    public static int silver(String filename){
	
    }
}
