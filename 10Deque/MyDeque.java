public class MyDeque<E>{
    private E[] data;
    private int length;
    
    @SupressWarnings("unchecked")
    public MyDeque(){
	data = (E[]) new Object[10];
	
    }

    @SupressWarnings("unchecked")
    public MyDeque(int capacity){
	data = (E[]) new Object[capcity];
    }

    public int size(){
	return length;
    }
}
