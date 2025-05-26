
import java.text.BreakIterator;
import java.util.*;

public class Main {
    static Player Player_1;
    static Player Player_2;
    private static boolean flag = false;
    private static int turns = 0;
    private static final Character[] letters = {'A', 'B', 'C'};
    private static int player = 1;
    private static String[][] sheet = {
            {"1", "1", "1"},
            {"2", "2", "2"},
            {"3", "3", "3"}};
    private static final String[][] winningSheet = {
        {"A1", "A2", "A3"},
        {"B1", "B2", "B3"},
        {"C1", "C2", "C3"},
        {"A1", "B2", "C3"},
        {"C1", "B2", "A3"},
        {"A1", "B1", "C1"},
        {"A2", "B2", "C2"},
        {"A3", "B3", "C3"}
    };

    public static void display() {
        for (Character letter : letters) {
            System.out.print(letter + "\t");
        }
        System.out.println();
        for (String[] strings : sheet) { //row
            for (String string : strings) { //column
                System.out.print(string + "\t");
            }
            System.out.println();
        }
        if (turns != 9 && !flag) {
            System.out.print("Take this as reference and enter you choice of place: ");
        }
    }
    public static boolean sendingData() {
        for (String[] a : winningSheet) {
            if (player == 1 && Player_1.checkWin(a)) {
                return true;  // Player 1 wins
            } else if (player == 2 && Player_2.checkWin(a)) {
                return true;  // Player 2 wins
            }
        }
        return false;  // No win found
    }

    public static void changingDisplay(String a){
        char[] move = a.toCharArray();
        if (player == 1) {
            if (Character.toUpperCase(move[0]) == 'A') {
                sheet[Character.getNumericValue(move[1]) - 1][0] = "*";
            } else if (Character.toUpperCase(move[0]) == 'B') {
                sheet[Character.getNumericValue(move[1]) - 1][1] = "*";
            } else if (Character.toUpperCase(move[0]) == 'C') {
                sheet[Character.getNumericValue(move[1]) - 1][2] = "*";
            }
        } else {
            if (Character.toUpperCase(move[0]) == 'A') {
                sheet[Character.getNumericValue(move[1]) - 1][0] = "^";
            } else if (Character.toUpperCase(move[0]) == 'B') {
                sheet[Character.getNumericValue(move[1]) - 1][1] = "^";
            } else if (Character.toUpperCase(move[0]) == 'C') {
                sheet[Character.getNumericValue(move[1]) - 1][2] = "^";
            }
        }
    }
    public static void input() {
        while (turns != 9 && !flag) {
            display();
            Scanner sc = new Scanner(System.in);
            String nextMove = sc.nextLine();
            if(Player_1.checkMoveValidity(nextMove,letters) == false){
                changingDisplay(nextMove);
                if (player == 1){
                    Player_1.storeHistory(nextMove);
                    if(sendingData()){ //checks if the player won or not
                        Player_1.winner();
                        flag = true;
                        break;
                    }else{
                        player = 2;
                    }
                }else{
                    Player_2.storeHistory(nextMove);
                    if (sendingData()){
                        Player_2.winner();
                        flag = true;
                        break;
                    }else{
                        player = 1;
                    }
                }
                ++turns;
            }else System.out.println("This is not a valid move");
        }
        if (turns == 9 && !flag) {
            display();
            System.out.print("The game is over it is sheet DRAW!!");
        }
    }
    public static void main(String[] args) {
        Player_1 = new Player();
        Player_1.create();
        Player_2 = new Player();
        Player_2.create();
        input();
    }

}