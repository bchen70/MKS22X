public class MyLinkedList{
    int length;
    Node first;
    Node last;
    public MyLinkedList(){
	
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
	return "x";
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
