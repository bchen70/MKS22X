public class Eval{

  public static double eval(String eq){
    Stack<String> stack = new Stack();
    String temp = "";
    
  }
  public static String solve(String operator, double num1, double num2){
    if (operator.equals("+")){
      return (num1 + num2) + "";
    }

    else if (operator.equals("-")){
      return (num1 - num2) + "";
    }

    else if (operator.equals("*")){
      return (num1 * num2) + "";
    }

    else if (operator.equals("/")){
      return (num2 / num1) + "";
    }

    else{
      return (num1 % num2) + "";
    }
  }
}
