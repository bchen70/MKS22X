import java.util.*;
public class MyDeque<E>{
    private E[] data;
    private int length;
    private int first,last;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[]) new Object[10];
	length = 0;
	
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int capacity){
	data = (E[]) new Object[capacity];
	length = 0;
    }

    public int size(){
	return length;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] temp = (E[])new Object[size() * 2];

	int index = first;
	int x = 0;
	while(index != last){
	    temp[x] = data[index];
	    index = Math.floorMod(index+1, data.length);
	    x++;
	}
	temp[x] = data[index];
	data = temp;
	first = 0;
	last = size()-1;   
    }
    
    public void addFirst(E element){
	if (element == null){
	    throw new NullPointerException();
	}
	else if(size() == 0){
	    data[first] = element;
	}
	else if (size() == data.length){
	    resize();
	}
    }
}
