import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + "     1 | 2 | 3");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + "     4 | 5 | 6");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + "     7 | 8 | 9");

        char currentPlayer = 'X';

        Scanner fieldNumber = new Scanner(System.in);
        System.out.println();
        System.out.print("Hello, " + currentPlayer + ", it is time to make your move! Choose 1-9: ");
        int chosenFieldNumber = fieldNumber.nextInt();
        board[chosenFieldNumber - 1] = currentPlayer;

    }


}
