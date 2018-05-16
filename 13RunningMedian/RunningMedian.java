public class RunningMedian{

  private MyHeap<Double> min;
  private MyHeap<Double> max;
  public int size;

  @SuppressWarnings("unchecked")
  public RunningMedian(){
    min = new MyHeap<>();
    max = new MyHeap<>(false);
  }

  public void add(double n){
    if (min.size() == 0 || n < min.peek()){
      min.add(n);
    }
    else{
      max.add(n);
    }

    if(min.size() - max.size() > 1){
      max.add(min.remove());
    }

    else if(max.size() - min.size() > 1){
      min.add(max.remove());
    }
  }

  public double getMedian(){
    if (min.size()>max.size()){
      return min .peek();
    }

    else if(max.size()> min.size()){
      return max.peek();
    }

    return (min.peek() + max.peek()) / 2;
  }

  public int size(){
    return size;
  }

  public static void main(String[]args){

    RunningMedian x = new RunningMedian();

    x.add(1);
    x.add(2);
    x.add(10);
    x.add(7);
    x.add(0);
    x.add(5);
    System.out.println("median: " + x.getMedian());
    System.out.println(x);
  }

}
