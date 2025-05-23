import java.util.Set;
import java.util.TreeSet;

public class Player {
    private static Set<String> moveHistory = new TreeSet<String>();

    public Player(){
        this.moveHistory = new TreeSet<>();
    }
    public void storeHistory(String move){
        moveHistory.add(move);
    }
    public boolean checkingPlace(String[][] a, int row, int column, String nm) {
        if (row >= 0 && row < 3 && column >= 0 && column < 3 && !moveHistory_Player1.contains(nm) && !moveHistory_Player2.contains(nm)) {
            if (player == 1) {
                sheet[row][column] = "*";
                player = 2;
                moveHistory_Player1.add(nm);
                turns++;
                if (check(1)) {
                    display(a);
                    System.out.println("Player 1 won");
                    return true;
                } else {
                    return false;
                }
            } else if (player == 2) {
                sheet[row][column] = "^";
                player = 1;
                moveHistory_Player2.add(nm);
                turns++;
                if (check(2)) {
                    display(a);
                    System.out.println("Player 2 won");
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            System.out.println("Invalid Move try again");
        }
        return false;
    }
}
