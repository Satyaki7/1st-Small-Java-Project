import java.util.*;

public class Player {
    public Set<String> totalMove = new TreeSet<>();
    public Set<String> moveHistory = new TreeSet<String>();
    private String playerName = "";

    public Player(){
        this.moveHistory = new TreeSet<>();
    }
    public void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the player: ");
        this.playerName = sc.nextLine();

    }
    public void storeHistory(String move){
        moveHistory.add(move.toUpperCase());
        totalMove.add(move.toUpperCase());
    }
    public boolean checkMoveValidity(String move,Character[] letters){
        char[] m = move.toCharArray();
        if(Arrays.asList(letters).contains(m[0]) && Character.getNumericValue(m[1])<=3 && Character.getNumericValue(m[1])>0 && Character.getNumericValue(m[1]) == (int)Character.getNumericValue(m[1])){
            if(totalMove.contains(move) == false){
                return false;
            }else return true;
        }else return true;
    }
    public boolean checkWin(String[] a) {
        return moveHistory.containsAll(List.of(a));
    }

    public void winner(){
        System.out.println(playerName +" won the game !!");
    }

}
