public class Merge{
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
    }
}
