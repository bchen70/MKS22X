public class Merge{
    /// FIX THE CODE
    public static void merge(int[] data, int[] temp, int lo, int hi,int lo2, int hi2){
	int first = lo;

	while(lo <= hi && lo2 <= hi2){
	    if(temp[lo] <= temp[lo2]){
		data[first] = temp[lo];
		first ++;
		lo ++;
	    }
	    else if(temp[lo] > temp[lo2]){
		data[first] = temp[lo2];
		first ++;
		lo2++;
	    }
	}

	while (lo <= hi){
	    data[first] = temp[lo];
	    first ++;
	    lo++;
	}
	while (lo2 <= hi2){
	    data[first] = temp[lo2];
	    first++;
	    lo2++;
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
	msort(temp,data,lo,mid);
	msort(temp,data,mid + 1,hi);
	merge(data,temp,lo,mid,mid + 1,hi);
	}
    }
}
