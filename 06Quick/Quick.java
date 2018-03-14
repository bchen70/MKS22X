import java.util.*;
public class Quick{
    public static int partition(int []data,int start,int end){
	int rand = start + (int)(Math.random() * (end - start + 1));
	int pivot = data[rand];
	swap(rand,start,data);

	int s = start + 1;
	int e = end;

	while (s <= e){
	    if (data[s] < pivot){
		s++;
	    }
	    else if (data[s] > pivot){
		swap(s,e,data);
		e -- ;
	    }
	}
	swap(start,e,data);
	return e;
	
    }
    private static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    } 
}
    
