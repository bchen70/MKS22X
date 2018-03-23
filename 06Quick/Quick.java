import java.util.*;
public class Quick{

    // I AM USING JASON LIN'S DRIVER( THE ONE THAT HE POSTED IN THE GOOGLE GROUPS)
    public static void main(String[]args){
	int[] ary = {9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5};
	System.out.println(Quick.quickselect(ary,5) + " <- Should be 0");
	int[] ary1 = {9,5,8,7,5,6,5,-3,4,5,3,4,5,1,2,3,4,4,3,5,4,3};
	System.out.println(Quick.quickselect(ary1,19) + " <- Should be 7");
	System.out.println(Quick.quickselect(ary1,13) + " <- Should be 5");
	System.out.println(Quick.quickselect(ary1,0) + " <- Should be -3");
	System.out.println(Quick.quickselect(ary1,ary1.length-1) + " <- Should be 9");
	int[] ary2 = {3,6,1,2,4,6,8,99,1,2,32,45,123,-23,12,-30,-12,-3};
	Quick.quicksort(ary2);
	System.out.println("Your sorted array" + "\n" + Arrays.toString(ary2));
	System.out.println("The correct array\n[-30, -23, -12, -3, 1, 1, 2, 2, 3, 4, 6, 6, 8, 12, 32, 45, 99, 123]");
    }
    
    
    public static int[] partition(int []data,int start,int end){
	int rand = (int)(Math.random() * (end - start + 1)+ start);
	int pivot = data[rand];
	swap (start, rand,data);
	
	int i = start + 1;
	int lt = start;
	int gt = end;
	
	while (i <= gt) {
	    if (data[i] == pivot) {
		i++;
	    }
	    else if (data[i] > pivot) {
		swap(i, gt,data);
		gt--;
	    }
	    else{
		swap(i, lt,data);
		i++;
		lt++;
	    }
	}
	int[] x = {lt,i};
	return x;
    }
    

    public static int quickselect(int[]data,int k){
	int start = 0;
	int end = data.length-1;
	int []x=partition(data,start,end);
	while (x[0] > k || x[1]< k){   
			      
	    if (x[0] < k){
		start = x[1]+1;
	    }
	    else if (x[1] > k) {
		end = x[0]-1;
	    }
	    x = partition(data, start, end);
	}
	return data[x[0]];
    }
    
    public static void quicksort(int [] data){
	quicksortH(data,0,data.length - 1);
    }
    public static void quicksortH(int []data,int start, int end){
	if(start < end){
	    int[] div = partition(data,start,end);
	    quicksortH(data,start,div[0]-1);
	    quicksortH(data,div[1],end);
	}
    }
    
    public static void swap(int x, int y, int[] ary) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
