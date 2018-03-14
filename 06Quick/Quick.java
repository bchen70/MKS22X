import java.util.*;
public class Quick{
    public static int partition(int []data,int start,int end){
	int rand = start + (int)(Math.random() * (end - start + 1));
	int pivot = data[rand];
	
    }
    private static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    } 
}
    
