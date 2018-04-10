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
	if (length == 0){
	    Node x = new Node(value);
	    first = x;
	    last = x;
	}
	else{
	    Node x = new Node(value);
	    x.setPrev(last);
	    last.setNext(x);
	    last = x;
	}
	length = length + 1;
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
    public int indexOf(Integer value){
	int x= 0;
	Node cur = first;
	while (cur != null){
	    if (cur.getValue() == value){
		return x;
	    }
	    x = x+1;
	    cur = cur.getNext();
	}
	return -1;
    }
    public void add(int index ,Integer value){
	if (index < 0 || index > length){
	    throw new IndexOutOfBoundsException();
	}
	Node x = new Node(value);
	if (index == length){
	    add(value);
	}
	else if (index == 0){
	    x.setNext(first);
	    first.setPrev(x);
	    first = x;
	    length = length + 1;
	}
	else{
	    Node after = getNode(index);
	    Node before = after.getPrev();
	    x.setNext(after);
	    x.setPrev(before);
	    before.setNext(x);
	    after.setPrev(x);
	    length = length + 1;
	}
    }
    public boolean remove(Integer value){
	int x = indexOf(value);
	if (x == -1){
	    return false;
	}
	else if (x== 0){
	    first = first.getNext();
	    first.setPrev(null);
	    length = length - 1;
	}
	else if(x== length - 1){
	    last = last.getPrev();
	    last.setNext(null);
	    length = length - 1;
	}
	else{
	    Node before = getNode(x - 1);
	    Node after = getNode(x + 1);
	    before.setNext(after);
	    after.setPrev(before);
	    length = length - 1;
	}
	return true;
    }

    public Integer remove(int index){
	if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
	}
	int x = get(index);
	if (index == 0){
	    first = first.getNext();
	    first.setPrev(null);
	    length = length - 1;
	}
	else if (index == length -1){
	    last = last.getPrev();
	    last.setNext(null);
	    length = length - 1;
	}
	else{
	    Node before = getNode(index - 1);
	    Node after = getNode(index + 1);
	    before.setNext(after);
	    after.setPrev(before);
	    length = length - 1;
	}
	return x;
    }
}
