public class Recursion{
  //1.1a factorial
  public int fact(int n){
    if (n < 0){
      throw new IllegalArgumentException();
    }
    if (n == 0){
      return 0;
    }
    return n + fact(n-1);
  }

  public static void main(String[] args){
    Recursion x = new Recursion();
    // System.out.println(x.fact(-1));returns exception
    System.out.println(x.fact(0));
    System.out.println(x.fact(1));
    System.out.println(x.fact(7));
      }
}
