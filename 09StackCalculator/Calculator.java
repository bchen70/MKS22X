import java.io.*;
import java.util.*;

public class Calculator{

  public static double eval(String eq){
    String[] ary = eq.split(" ");
    LinkedList<Double> x = new LinkedList<>();

    for (String ah : ary){
      char y = ah.charAt(0);
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
}
