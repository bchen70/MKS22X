import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Maze{
  Location start,end;
  private char[][]board;

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
}
