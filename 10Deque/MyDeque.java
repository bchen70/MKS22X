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
	else if(size() != 0){
	    last = (last + 1) % data.length;
	}
	else if (size() == data.length){
	    resize();
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
    
}
