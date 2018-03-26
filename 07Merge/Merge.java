public class Merge{
    public static void merge(int[] data, int[] temp, int lo, int hi,int lo2, int hi2){
	int mid = (lo+hi)/ 2;
	for (int i = lo; i <= hi2 ; i++){
	    if (lo <= hi && (lo2 > hi2 || temp[lo] <= temp[lo2])){
		data[i] = temp[lo];
		lo ++;
	    }
	    else{
		data[i] = temp[lo2];
		lo2++;
	    }
	}
    }
    
    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[]data, int[]temp,int lo, int hi){
	int mid = (lo+hi)/ 2;
	if (lo <  hi){
	    for (int i = lo; i<= hi; i++){
		temp[i] = data [i];
	    }
	}
	msort(temp,data,lo,mid);
	msort(temp,data,mid + 1,hi);
	merge(data,temp,lo,mid,mid + 1,hi);
    }
}
