import java.util.*;
import java.io.*;

public class MazeSolver{

  public static void main(String[]args){
    try {
      MazeSolver m = new MazeSolver("test1.txt");
      System.out.println(m);
      m.solve();
      System.out.println(m);
    }
    catch (FileNotFoundException e){

    }

  }

  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String fileName) throws FileNotFoundException{
    maze = new Maze(fileName);
  }

  public boolean solve(){
    return solve(0);
  }

  public boolean solve(int mode){
    if (mode == 1){
      frontier = new FrontierStack();
    }
    else if (mode == 0) {
      frontier = new FrontierQueue();
    }
    frontier.add(maze.getStart());
    Location end = maze.getEnd();

    while (frontier.hasNext()){
      Location next = frontier.next();
      maze.set(next.getX(),next.getY(),'.');
      Location[] newLocations = maze.getNeighbors(next);
      for (int i=0; i<newLocations.length; i++){
        Location cur = newLocations[i];
        if (cur != null){
          if (cur.equals(end)){
            maze.end = new Location(maze.end.getX(),maze.end.getY(),cur.getPrev());
            maze.set(maze.getEnd().getX(),maze.getEnd().getY(),'E');
            return true;
          }
          frontier.add(cur);
          maze.set(cur.getX(),cur.getY(),'?');
        }
      }
    }
    return false;
  }

  public String toString(){
    Location cur = maze.getEnd().getPrev();
    while (cur!=null){
      maze.set(cur.getX(),cur.getY(),'@');
      cur = cur.getPrev();
    }
    maze.set(maze.start.getX(),maze.start.getY(),'S');
    return maze.colorize(maze.toString());
  }
}
