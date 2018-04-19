import java.util.*;
public class Stack<String>{

    public LinkedList<String> list;

    @SuppressWarnings("unchecked")
    public Stack(){
  list = new LinkedList();
    }

    public void push(String value){
  list.add(value);
    }

    public String pop(){
  return list.remove(list.size()-1);
    }

}
