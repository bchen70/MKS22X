public class Driver{

    public static void main(String[]args){
        Maze f;
	try{
        f = new Maze("data3.dat");//true animates the maze.	
        
        f.setAnimate(true);
        System.out.println(f.solve());
	System.out.println(f);
	
	}catch(Exception e){}

        
    }
}
