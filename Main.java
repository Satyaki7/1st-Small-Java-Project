
import java.text.BreakIterator;
import java.util.*;

public class Main {

    private static boolean flag = false;
    private static int turns = 0;
    Player Player_1 = new Player();
    Player Player_2 = new Player();
    private static String[] row1 = {"1", "1", "1"};
    private static String[] row2 = {"2", "2", "2"};
    private static String[] row3 = {"3", "3", "3"};
    private static Character[] letters = {'A', 'B', 'C'};
    private static int player = 1;
    private static String[][] sheet = {
        row1,
        row2,
        row3,};
    private static String[][] winningSheet = {
        {"A1", "A2", "A3"},
        {"B1", "B2", "B3"},
        {"C1", "C2", "C3"},
        {"A1", "B2", "C3"},
        {"C1", "B2", "A3"},
        {"A1", "B1", "C1"},
        {"A2", "B2", "C2"},
        {"A3", "B3", "C3"},};

    public static void display(String[][] a) {
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + "\t");
        }
        System.out.println("");
        for (int i = 0; i < a.length; i++) { //row
            for (int j = 0; j < a[i].length; j++) { //column
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        if (turns != 9 && flag == false) {
            System.out.print("Take this as reference and enter you choice of place: ");
        }
    }

    public static void input(String[][] a) {
        while (turns != 9 && flag == false) {
            Scanner sc = new Scanner(System.in);
            display(a);
            String nextMove = sc.nextLine();
            int n = Character.getNumericValue(nextMove.charAt(1));
            if (nextMove.charAt(0) == 'A') {
                flag = checkingPlace(a, n - 1, 0, nextMove);
            } else if (nextMove.charAt(0) == 'B') {
                flag = checkingPlace(a, n - 1, 1, nextMove);
            } else if (nextMove.charAt(0) == 'C') {
                flag = checkingPlace(a, n - 1, 2, nextMove);
            } else {
                System.out.print("Invalid Choice Try again");
            }
        }
        if (turns == 9 && flag == false) {
            display(a);
            System.out.print("The game is over it is a DRAW!!");
        }
    }





    public static void main(String[] args) {
        input(sheet);
    }
}
