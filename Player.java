import java.util.Set;
import java.util.TreeSet;

public class Player {
    private Set<String> totalMove = new TreeSet<>();
    private Set<String> moveHistory = new TreeSet<String>();

    public Player(){
        this.moveHistory = new TreeSet<>();
    }
    public void storeHistory(String move){
        moveHistory.add(move);
        totalMove.add(move);
    }
    public boolean checkMove(String move){
        return !totalMove.contains(move);
    }

}
