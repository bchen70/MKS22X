import java.util.*;
public class Quick{

    public static void main(String[] args){
	int[] ary = {5,3,7,5,34,3,765};

	
	System.out.println(Quick.quickselect(ary,0));
	System.out.println(Quick.quickselect(ary,1));
	System.out.println(Quick.quickselect(ary,2));
	System.out.println(Quick.quickselect(ary,3));
	System.out.println(Quick.quickselect(ary,4));
    }
    public static int partition(int []data,int start,int end){
	int rand = start + (int)(Math.random() * (end - start + 1));
	int pivot = data[rand];
	swap(rand,start,data);

	int s = start + 1;
	int e = end;

	while (s <= e){
	    if (data[s] <= pivot){
		s++;
	    }
	    else{
		swap(s,e,data);
		e -- ;
	    }
	}
	swap(start,e,data);
	return e;
	
    }

    public static int quickselect(int[]data,int k){
	int start = 0;
	int end = data.length-1;
	for(int i =0;i<data.length; i++){
	    if (partition(data,start,end) == k){
		return data[(partition(data,start,end))];
	    }
	    if (partition(data,start,end) < k){
		start = partition(data,start,end) + 1;
	    }
	    else{
		end = partition(data,start,end) - 1;
	    }
	}
	return -1;	    
    }
    public static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    } 
}
    
