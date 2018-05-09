import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze{
  private static final String CLEAR_SCREEN =  "\033[2J";
  private static final String HIDE_CURSOR =  "\033[?25l";
  private static final String SHOW_CURSOR = "\033[?25h";
  Location start,end;
  private char[][]board;

  public Location[] getNeighbors(Location L){

    Location[] neighbors = new Location[4];
    int x = L.getX();
    int y = L.getY();
    int size = 0;
    if (isValid(x-1,y)){
      neighbors[size] = new Location(x-1,y,L);
      size++;
    }
    if (isValid(x+1,y)){
      neighbors[size] = new Location(x+1,y,L);
      size++;
    }
    if (isValid(x,y-1)){
      neighbors[size] = new Location(x,y-1,L);
      size++;
    }
    if (isValid(x,y+1)){
      neighbors[size] = new Location(x,y+1,L);
      size++;
    }
    return neighbors;
  }

  private boolean isValid (int x, int y){
    return x>=0 && x<board.length && y>=0 && y<board[0].length &&
      (board[x][y] == ' ' || board[x][y] == 'E');
  }

  public Location getStart(){
    return start;
  }
  public Location getEnd(){
    return end;
  }


  private static String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
  }
  private static String color(int foreground,int background){
    return ("\033[0;" + foreground + ";" + background + "m");
  }

  public void clearTerminal(){
    System.out.println(CLEAR_SCREEN+"\033[1;1H");
}

  public Maze(String filename) throws FileNotFoundException{

    String str = "";
    int col = 0;
    int row = 0;
    int startX = 0;
    int startY = 0;
    int endX = 0;
    int endY = 0;

    File text = new File(filename);
    Scanner inputFile = new Scanner(text);
    while(inputFile.hasNextLine()){
      String line = inputFile.nextLine();
      str += line + "\n";
      col = line.length();
      row++;
    }


    board = new char[row][col];

    int charNum = 0;
    int SCount = 0;
    int ECount = 0;
    for (int r = 0; r < row; r++){
      for (int c = 0; c < col; c++){
        if (str.charAt(charNum)=='S'){
          startX = c;
          startY = r;
          SCount++;
        }
        if (str.charAt(charNum)=='E'){
          startY = c;
          startX = r;
          ECount++;
        }

        if (str.charAt(charNum)=='\n'){
          charNum++;
        }
        board[r][c] = str.charAt(charNum);
        charNum++;
      }
    }

    start = new Location(startX, startY, null);
    end = new Location(endX, endY, null);
    if (SCount != 1 || ECount != 1){
      throw new IllegalArgumentException();
    }
  }

   public String toStringColor(){
    return toStringColor(50);
  }

  public String toStringColor(int delay){
    try{
      Thread.sleep(delay);
    }catch(InterruptedException e){

    }
    return HIDE_CURSOR+CLEAR_SCREEN+go(1,1)+colorize(toString())+SHOW_CURSOR;
  }

  public String toString(){
    int maxr = board.length;
    int maxc = board[0].length;
    String ans = "";
    for(int i = 0; i < maxr * maxc; i++){
      int row = i/maxc;
      int col = i%maxc;

      char c =  board[row][col];
      ans+=c;
      if( col == maxc-1 ){
        ans += "\n";
      }

    }
    return ans + "\n";
  }

  public char get(int row,int col){
    return board[row][col];
  }
  public void set(int row,int col, char n){
    board[row][col] = n;
  }
  public static String colorize(String s){
    String ans = "";
    Scanner in = new Scanner(s);
    while(in.hasNext()){
      String line ="";
      for(char c : in.nextLine().toCharArray()){
        if(c == '#'){
          line+= color(37,47)+c;
        }
        else if(c == '@'){
          line+= color(33,40)+c;
        }
        else if(c == '?'){
          line+= color(37,42)+c;
        }
        else if(c == '.'){
          line+= color(36,40)+c;
        }
        else if(c == ' '){
          line+= color(35,40)+c;
        }else{
          line+=color(37,40)+c;
        }

      }
      ans += line+color(37,40)+"\n";
    }
    return ans;
}
}
