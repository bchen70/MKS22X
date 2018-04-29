public class MyHeap{

    private String[] data;
    private int size;
    private boolean isMax;
    
    public MyHeap(boolean x){
	if (x){
	    isMax = true;
	}
	else{
	    isMax = false;
	}
	data = new String[10];
	size = 0;
    }
    public int size(){
	return size;
    }
}
