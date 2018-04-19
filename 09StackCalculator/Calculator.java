import java.io.*;
import java.util.*;

public class Calculator{

  public static double eval(String eq){
    String[] ary = eq.split(" ");
    LinkedList<Double> x = new LinkedList<>();

    for (String ah : ary){
      char y = ah.charAt(0);
      if(Character.isDigit(y)){
        double i = Double.parseDouble(ah);
        x.push(i);
      }
      if (y == '+'){
        double a = x.pop();
        double b = x.pop();
        x.push(b+a);
      }
      if (y == '-'){
        double a = x.pop();
        double b = x.pop();
        x.push(b - a);
      }
      if (y == '*'){
        double a = x.pop();
        double b = x.pop();
        x.push(b * a);
      }
      if(y == '/'){
        double a = x.pop();
        double b = x.pop();
        x.push(b / a);
      }
      if(y == '%'){
        double a = x.pop();
        double b = x.pop();
        x.push(b % a);
      }
    }
    return x.pop();
  }
  public static void main(String[] args){
    System.out.println(eval("10 2.0 +"));// is 12.0
    System.out.println(eval("11 3 - 4 + 2.5 *"));// is 30.0
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //is 893.0
}
}
