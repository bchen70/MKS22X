import java.util.*;
import java.io.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{

  private class Node{
    private Node next, prev;
    private T data;

    public Node(T x){
	    data =x;
	    next = null;
	    prev = null;
    }

    public Node(T x , Node y, Node z){
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

    public T getValue(){
	    return data;
    }

    public void setValue(T x){
	    data = x;
    }

    public String toString(){
	    return String.valueOf(data);
    }
  }

  private int length;
  private Node first;
  private Node last;
  public MyLinkedListImproved(){
    first = null;
    last = null;
    length = 0;
  }

  public void clear(){
    first = null;
    last = null;
    length = 0;
  }
    
  public boolean add(T value){
    if (length == 0){
      first = new Node(value);
		  last = first;
    }
    else{
      Node newNode = new Node(value);
      newNode.setPrev(last);
      last.setNext(newNode);
      last = newNode;
    }
    length++;
    return  true;
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
  public T get(int index){
    Node x = getNode(index);
    return x.getValue();
  }
    
  public T set(int index,T newValue){
    Node cur = getNode(index);
    T n = cur.getValue();
    cur.setValue(newValue);
    return n;
  }
  public int indexOf(T value){
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
  public void add(int index ,T value){
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
  public boolean remove(T value){
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

  public T remove(int index){
    if (index < 0 || index >= length){
	    throw new IndexOutOfBoundsException();
    }
    T x = get(index);
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

  public int max(){
    if(length == 0){
	    return -1;
    }
    Node node = first;
    int maxIndex = 0;
    int i = 0;
    T max = node.getValue();
    while(node != null){
	    if(node.getValue().compareTo(max) > 0){
        maxIndex = i;
        max = node.getValue();
	    }
	    i++;
	    node = node.getNext();
    }
    return maxIndex;
  }

  public int min(){
    if(length == 0){
	    return -1;
    }
    Node node = first;
    int minIndex = 0;
    int i = 0;
    T min = node.getValue();
    while(node != null){
	    if(node.getValue().compareTo(min) < 0){
        minIndex = i;
        min = node.getValue();
	    }
	    i++;
	    node = node.getNext();
    }
    return minIndex;
  }
  
  public void extend(MyLinkedListImproved<T> other){
    if(other.size() != 0 && size() == 0){
	    first = other.first;
      last= other.last;
      other.first=null;
      other.last=null;
      length=other.size();
      other.length=0;
    }
    else if (other.size() != 0){
      int s = this.size() +other.size();
      last.setNext(other.first);
      other.first.setPrev(last);
    }
  }

  public Iterator<T>iterator(){
    return new LLIterator(first);
  }
  public class LLIterator implements Iterator<T>{
    public Node curNode;

    public LLIterator(Node yab){
	    curNode = yab;
    }
	  
    public boolean hasNext(){
	    if (curNode == null){
        return false;
	    }
	    return true;
    }

    public T next(){
	    T res = curNode.getValue();
	    curNode = curNode.getNext();
	    return res;
    }
	  
  }
}
