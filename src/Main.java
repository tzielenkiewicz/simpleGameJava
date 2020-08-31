import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain) {

            char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
            displayBoard(board);

            char currentPlayer = 'X';
            int round = 0;

            while (!checkWinner(board, currentPlayer) && round < 9) {
                if (currentPlayer != 'O') currentPlayer = 'O';
                else currentPlayer = 'X';

                Scanner fieldNumber = new Scanner(System.in);
                System.out.println();
                System.out.print("Hello " + currentPlayer + ", it is time to make your move! Choose 1-9: ");
                int chosenFieldNumber = fieldNumber.nextInt();

                while (board[chosenFieldNumber - 1] != ' ') {
                    System.out.print("This position is already occupied! Choose another one: ");
                    chosenFieldNumber = fieldNumber.nextInt();
                }

                board[chosenFieldNumber - 1] = currentPlayer;

                displayBoard(board);

                round += 1;
            }
            System.out.println();
            if (round == 9) System.out.println("Seems like nobody wins this time...");
            else System.out.println("Congratulations " + currentPlayer + ", you win!");
            System.out.print("Do you wish to play again? (true/false): ");
            Scanner decision = new Scanner(System.in);
            playAgain = decision.nextBoolean();
        }

    }


    private static boolean checkWinner(char[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
                || (board[0] == player && board[4] == player && board[8] == player)
                || (board[2] == player && board[4] == player && board[6] == player)
                || (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player);
            }

    private static void displayBoard(char[] board) {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + "     1 | 2 | 3");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + "     4 | 5 | 6");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + "     7 | 8 | 9");
    }


}
