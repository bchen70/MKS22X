import java.util.*;

public class Sorts{

  public static void main(String[]args){
    int[] ary = {2,3,1,14,5,38,4,-8683,-123};
    Sorts.heapsort(ary);
    System.out.println(Arrays.toString(ary));
  }

  public static void heapsort(int[] ary){
    for (int i=ary.length-1; i>=0; i--){
      pushDown(i,ary,ary.length);
    }
    System.out.println(Arrays.toString(ary));

    for (int i=0; i<ary.length; i++){
      int maxValue = ary[0];
      int sortedIndex = ary.length-1-i;
      ary[0] = ary[sortedIndex];
      pushDown(0,ary,sortedIndex);
      ary[sortedIndex] = maxValue;
    }
  }

  public static void pushUp(int index, int[]data){
    int parent = (index - 1)/2;
    if (data[index] > data[parent]){
      swap(index,parent,data);
      pushUp(parent,data);
    }
  }

  private static void pushDown(int index, int[] data, int size){
    int L = 2*index + 1;
    int R = 2*index + 2;
    int swapIndex = index;
    if (L < size && data[swapIndex] < data[L]){
      swapIndex = L;
    }
    if (R < size && data[swapIndex] < data[R]){
      swapIndex = R;
    }
    if (swapIndex == index){
      return;
    }
    swap(index,swapIndex,data);
    pushDown(swapIndex,data,size);
  }

  public static void swap(int index1, int index2, int[]data){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
