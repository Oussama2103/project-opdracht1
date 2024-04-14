import java.util.ArrayList;

public class Aanmaken {
    public static ArrayList<Game> games = new ArrayList<>();
    private static Aanmaken aanmaken = new Aanmaken();
    private static int runTimes = 1;
    private Aanmaken(){}

    public static Aanmaken getAanmaken(){
        return aanmaken;
    }
    public void run(){
        if(runTimes != 0){
            games.add(new Game("Space invaders", 20));






            runTimes = 0;
        }
    }
}
