import java.util.*;

public class Sort{
  public static void radixsort(MyLinkedListImproved<Integer> data){
    if (data.size() != 0){
      @SuppressWarnings("unchecked")
        MyLinkedListImproved<Integer>[] pos = new MyLinkedListImproved[10];
      @SuppressWarnings("unchecked")
        MyLinkedListImproved<Integer>[] neg = new MyLinkedListImproved[10];
      for(int i = 0; i < 10; i++){
        pos[i] = new MyLinkedListImproved<Integer>();
        neg[i] = new MyLinkedListImproved<Integer>();
      }

      int maxNum = (Math.max(Math.abs(data.get(data.max())), Math.abs(data.get(data.min()))) + "").length();

      for(int i = 0; i < maxNum ; i++){
        for (Integer x : data){
          if (x >= 0){
            pos[(int)(x / Math.pow(10, i)) % 10].add(x);
        }
        else{
          neg[Math.abs(9-(int)(x*-1 / Math.pow(10, i)) % 10)].add(x);
        }
        }
        data.clear();
        for (int y = 0; y < neg.length; y++){
        data.extend(neg[y]);
        }
        for (int z = 0; z < pos.length; z++){
        data.extend(pos[z]);
        }
      }
    }
  }
}
    
  
