public class MyLinkedList{

    private class Node{
	private Node next, prev;
	private int data;

	public Node(int x){
	    data =x;
	    next = null;
	    prev = null;
	}

	public Node(int x , Node y, Node z){
	    data = x;
	    prev = y;
	    next = z;
	}

	public Node getNext(){
	    return next;
	}

	public void setNext(Node n){
	    next = n;
	}

	public Node getPrev(){
	    return prev;
	}

	public void setPrev(Node n){
	    prev = n;
	}

	public int getValue(){
	    return data;
	}

	public void setValue(int x){
	    data = x;
	}

	public String toString(){
	}
    }

    private int length;
    private Node first;
    private Node last;
    public MyLinkedList(){
	first = null;
	last = null;
	length = 0;
    }
    
    public boolean add(int value){
	data = value;
	length = length + 1;
	return true;
    }

    public int size(){
	return length;
    }
    
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String str = "[";
    }
    
    public int get(int index){
	return index;
    }
    
    public void set(int index,int newValue){
    }
    
    private class Node{
	private Node next,prev;
	private int data;
    }
}
