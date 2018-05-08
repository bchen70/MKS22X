@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

  private T[] data;
  private int size;
  private boolean isMax;

  public MyHeap(){
    this(true);
  }
  public MyHeap(boolean x){
    if (x){
      isMax = true;
    }
    else{
      isMax = false;
    }
    data = (T[])new Comparable[10];
    size = 0;
  }
  public int size(){
    return size;
  }

  public T peek(){
    return data[0];
  }

  private void resize(){
    T[] ary = (T[])new Comparable[data.length * 2];
    for(int x = 0; x < ary.length; x++){
      ary[x] = data[x];
    }
    data = ary;
  }

  public void add(T s){
    if (size == data.length){
      resize();
    }
    if (size == 0){
      data[0] = s;
    }
    else{
      data[size] = s;
      pushUp(size);
    }
    size ++;
  }


  private void pushUp(int index){
    int parent = (index-1)/2;
    if (isMax && data[index].compareTo(data[parent]) > 0 ||
        !isMax && data[index].compareTo(data[parent]) < 0){
      swap(index,parent);
      pushUp(parent);
    }
  }

  public T remove(){
    if (size == 0){
      return null;
    }
    T s = peek();
    swap(0, size()-1);
    size--;
    pushDown(0);
    return s;
  }

  public void pushDown(int index){
    int left = index*2+1;
    int right = index*2+2;
    if (isMax && left < size()&& data[index].compareTo(data[left]) < 0 && (right >= size() || data[right].compareTo(data[left]) <= 0) ||
        !isMax && left < size()&& data[index].compareTo(data[left]) > 0 && (right >= size() || data[right].compareTo(data[left]) >= 0)
        ){
      swap(index, left);
      pushDown(left);
    }

    else if (isMax && right < size() && data[index].compareTo(data[right]) < 0 && (left >= size() || data[left].compareTo(data[right]) <= 0) ||
             !isMax && right < size()&& data[index].compareTo(data[right]) > 0 && (left >= size() || data[right].compareTo(data[left]) >= 0)
             ){
      swap(index, right);
      pushDown(right);
    }

  }
  private void swap(int index1, int index2){
    T temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
