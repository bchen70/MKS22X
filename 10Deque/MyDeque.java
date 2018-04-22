import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int length;
    private int first,last;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[]) new Object[10];
	length = 0;
	first = 0;
	last = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity){
	if (capacity < 0){
	    throw new IllegalArgumentException();
	}
	data = (E[]) new Object[capacity];
	length = 0;
	first = 0;
	last= 0;
    }

    public int size(){
	return length;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] temp = (E[])new Object[size() * 2];
	for (int i = 0; i < data.length; i++){
	    temp[i] = data[(i + first)% data.length];
	}
	data = temp;
	first = 0;
	last = length - 1;
    }
    
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	if (size() == data.length){
	    resize();
	}
	if(size() != 0){
	    first = (first - 1 + data.length) % data.length;
	}
	data[first] = element;
	length ++;
    }

    public E removeFirst(){
	if (length < 1) {
	    throw new NoSuchElementException();
	}
	E cur = data[first];
	data[first] = null;
	if (length > 1){
	    first = (first+1) % data.length;
	}
	length--;
	return cur;
    }

    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if (length == data.length){
	    resize();
	}
	if (length != 0){
	    last = (last + 1)% data.length;
	}
	data[last] = element;
	length++;
    }

    public E removeLast() {
	if (length < 1) {
	    throw new NoSuchElementException();
	}
	E cur = data[last];
	data[last] = null;
	if (length > 1){
	    last  = (last-1+data.length) % data.length;
	}
	length--;
	return cur;
    }

    public E getFirst(){
	if (length < 1){
	    throw new NoSuchElementException();
	}
	return data[first];
    }

    public E getLast() {
	if (length < 1) {
	    throw new NoSuchElementException();
	}
	return data[last];
    }

    /// using Crystal's driver
    public String toString(){
    String ans = "[";
    if(first < last){
      for (int i = first; i <= last; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = first; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= last; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
    }
}
