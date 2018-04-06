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
	    return String.valueOf(data);
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

    public void clear(){
	first = null;
	last = null;
	length = 0;
    }
    
    public boolean add(int value){
	return true;
    }

    public int size(){
	return length;
    }
    
    public String toString(){
	if (length == 0){
	    return "[]";
	}
	String str = "[";
	Node cur = first;
	while (cur.getNext() != null){
	    str = str + cur.toString() + ", ";
	    cur = cur.getNext();
	}
	return str + cur.toString() + "]";
    }

    private Node getNode(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	Node cur = first;
	while (index >0){
	    cur = cur.getNext();
	    index = index - 1;
	}
	return cur;
    }
    public Integer get(int index){
	Node x = getNode(index);
	return x.getValue();
    }
    
    public Integer set(int index,int newValue){
	Node cur = getNode(index);
	int n = cur.getValue();
	cur.setValue(newValue);
	return n;
    }
    
}
