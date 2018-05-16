import java.util.*;
import java.io.*;

public class MazeSolver{

    public static void main(String[]args){
      try {
        MazeSolver m = new MazeSolver("test1.txt");
        System.out.println(m);
        m.setAnimate(true);
        m.solve();
        System.out.println(m);
      }
      catch (FileNotFoundException e){

      }

    }

  private Maze maze;
  private Frontier frontier;
  private boolean willAnimate;

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }


  public MazeSolver(String fileName) throws FileNotFoundException{
    maze = new Maze(fileName);
    willAnimate = false;
  }

  public void setAnimate(boolean val){
    willAnimate = val;
  }

  public boolean solve(){
    return solve(1);
  }

  public boolean solve(int mode){
    if (mode == 1){
	    frontier = new FrontierStack();
    }
    else if (mode == 0) {
	    frontier = new FrontierQueue();
    }
    else if (mode == 2){
      frontier = new FrontierPriorityQueue();
    }
    else if (mode == 3){
      frontier = new FrontierPriorityQueue();
      maze.setAStar(true);
    }
    frontier.add(maze.getStart());
    Location end = maze.getEnd();

    while (frontier.hasNext()){
      if (willAnimate){
        System.out.println("\033[2J\033[1;1H");
        System.out.println(this);
        wait(30);
      }
	    Location next = frontier.next();
      if(!next.equals(maze.getStart())){
        maze.set(next.getX(), next.getY(), '.');
      }
      Location[] newLocations = maze.getNeighbors(next);

      for (Location L: newLocations){
        if (L != null){
          if (L.equals(end)){

            while (!next.equals(maze.getStart())){
              maze.set(next.getX(), next.getY(), '@');
              next = next.getPrev();

            }
            return true;
          }
          frontier.add(L);
          maze.set(L.getX(), L.getY(), '?');
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
      if (willAnimate){
        System.out.println("\033[2J\033[1;1H");
        System.out.println(maze.colorize(maze.toString()));
        wait(30);
      }
    }
    maze.set(maze.start.getX(),maze.start.getY(),'S');
    return maze.colorize(maze.toString());
  }
}
