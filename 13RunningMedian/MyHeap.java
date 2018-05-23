@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

  private T[] data;
  private int size;
  private boolean isMax;

  public MyHeap(){
    this(true);
  }
  @SuppressWarnings("unchecked")
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
    T[] ary = (T[])new Comparable[size() * 2];
    for(int x = 0; x < ary.length; x++){
      ary[x] = data[x];
    }
    data = ary;
  }

   @SuppressWarnings("unchecked")
  public void add(T s){
    if (size == data.length){
      resize();
    }
    data[size] = s;
    pushUp(size);
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
    swap(0, size()-1);
    size--;
    pushDown(0);
    return data[size];
  }

  public void pushDown(int index){
    int left = index*2+1;
    int right = index*2+2;
    if (left >= size){
      return ;
    }
    if (right >= size){
      if (isMax && data[index].compareTo(data[left]) < 0 ||
          !isMax && data[index].compareTo(data[left]) > 0){
        swap(index, left);
        pushDown(left);
      }
    }

    else if (isMax && data[index].compareTo(data[left]) < 0 ||
             !isMax && data[index].compareTo(data[left]) > 0) {
      if (isMax && data[left].compareTo(data[right]) >= 0 ||
          !isMax && data[left].compareTo(data[right]) <= 0){
        swap(index, left);
        pushDown(left);
      }
      else{
        swap(index,right);
        pushDown(right);
      }
    }
  }

  private void swap(int index1, int index2){
    T temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }

  public String toString(){
  String str = "";
  for (int i = 0; i < size(); i++){
      str += data[i] + "  ";
  }
  return str;
}
  @SuppressWarnings("unchecked")
    public static void main(String[] args){
        MyHeap<Integer>  x = new MyHeap<>();
  for(int i = 0; i < 10; i++){
      int temp = (int)(Math.random() * 10);
      x.add( temp);
      System.out.println(x);
      //System.out.println("------------------------------------");
  }
  for(int i = x.size(); i>0; i--){
      x.remove();
      System.out.println(x);

      //System.out.println("done");
  }
  }
}
