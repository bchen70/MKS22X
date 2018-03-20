public class Merge{
    public static void mergesort(int []data){
    }
    
    public static void merge(int[] aryA, int[] aryB, int[] destination)
    {
        int a = 0, b = 0;
        while (a < aryA.length && b < aryB.length) {
            if (aryA[a] < aryB[b]) {
                destination[a + b] = aryA[a];
                a++;
            } else {
                destination[a + b] = aryB[b];
                b++;
            }
        }
    }
    private static void msort(int[]data, int[]temp,int lo, int hi){
	int mid = (lo+hi)/ 2;
	int a = 0;
	int b = 0;
	while (a < data.length){
	    
	    if (lo >= hi){
		return;
	    }
	    temp = data;
	    if (data[lo]>=data[lo + 1]){
		temp[a] = data[lo + 1];
		a++;
	    }
	    else{
		temp[a] = data[lo];
		a++;
	    }
	}
	    
	    
	msort(temp,data,lo,mid);
	msort(temp,data,mid + 1,hi);
    }
}
