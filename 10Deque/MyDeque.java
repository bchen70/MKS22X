public class MyDeque<E>{
    private E[] data;
    @SupressWarnings("unchecked");
    public MyDeque(){
	data = (E[]) new Object[10];
    }
}
