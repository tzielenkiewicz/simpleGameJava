import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String answer;
        Scanner initialQuestion = new Scanner(System.in);
        do {

            do {
                System.out.print("Do you want to play with computer ('c') or with a partner ('p')?: ");
                answer = initialQuestion.nextLine();
            }
            while (!answer.equalsIgnoreCase("c") && !answer.equalsIgnoreCase("p"));
            System.out.println(answer);

            char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
            displayBoard(board);

            char currentPlayer = 'O';
            int round = 0;

            if (answer.equals("p")) {
                while (!checkWinner(board, currentPlayer) && round < 9) {

                    currentPlayer = switchPlayer(currentPlayer);

                    Scanner fieldNumber = new Scanner(System.in);
                    System.out.println();
                    System.out.print("Hello " + currentPlayer + ", it is time to make your move! Choose 1-9: ");
                    String chosenFieldNumber = fieldNumber.nextLine();

                    while (!chosenFieldNumber.equals("1") && !chosenFieldNumber.equals("2")
                            && !chosenFieldNumber.equals("3") && !chosenFieldNumber.equals("4")
                            && !chosenFieldNumber.equals("5") && !chosenFieldNumber.equals("6")
                            && !chosenFieldNumber.equals("7") && !chosenFieldNumber.equals("8")
                            && !chosenFieldNumber.equals("9") || board[Integer.parseInt(chosenFieldNumber) - 1] != ' ') {
                        System.out.print("You have entered invalid position! Choose another one (1-9): ");
                        chosenFieldNumber = fieldNumber.nextLine();
                    }

                    board[Integer.parseInt(chosenFieldNumber) - 1] = currentPlayer;

                    displayBoard(board);

                    round += 1;
                }
                System.out.println();
                if (round == 9) System.out.println("Seems like nobody wins this time...");
                else System.out.println("Congratulations " + currentPlayer + ", you win!");

            }
            else if (answer.equals("c")) {
                while (!checkWinner(board, currentPlayer) && round < 9) {
                    currentPlayer = switchPlayer(currentPlayer);

                    if (currentPlayer == 'X') {
                        Scanner fieldNumber = new Scanner(System.in);
                        System.out.println();
                        System.out.print(currentPlayer + ", it is time to make your move! Choose 1-9: ");
                        String chosenFieldNumber = fieldNumber.nextLine();


                        while (!chosenFieldNumber.equals("1") && !chosenFieldNumber.equals("2")
                                && !chosenFieldNumber.equals("3") && !chosenFieldNumber.equals("4")
                                && !chosenFieldNumber.equals("5") && !chosenFieldNumber.equals("6")
                                && !chosenFieldNumber.equals("7") && !chosenFieldNumber.equals("8")
                                && !chosenFieldNumber.equals("9") || board[Integer.parseInt(chosenFieldNumber) - 1] != ' ') {
                            System.out.print("You have entered invalid position! Choose another one (1-9): ");
                            chosenFieldNumber = fieldNumber.nextLine();
                        }

                        board[Integer.parseInt(chosenFieldNumber) - 1] = currentPlayer;

                        displayBoard(board);

                        round += 1;
                    }
                     else {
                        System.out.println("Let me think...");
                        Thread.sleep(2000);
                        for (int i = 0; i < 9; i++) {
                            if (board[i] == ' ') {
                                board[i] = currentPlayer;
                                break;
                            }
                        }
                        displayBoard(board);

                        round += 1;
                    }

                }
                System.out.println();
                if (round == 9) System.out.println("Seems like nobody wins this time...");
                else System.out.println("Congratulations " + currentPlayer + ", you win!");

            }
        }
        while (doYouWantToPlayAgain().equalsIgnoreCase("y"));

    }

    public static char switchPlayer(char currentPlayer) {
        if (currentPlayer != 'O') currentPlayer = 'O';
        else currentPlayer = 'X';
        return currentPlayer;

    }


    public static void displayBoard(char[] board) {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + "     1 | 2 | 3");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + "     4 | 5 | 6");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + "     7 | 8 | 9");
    }

    public static String doYouWantToPlayAgain() {
        String playAgain;
        do {
            System.out.print("Do you wish to play again? (y/n): ");
            Scanner decision = new Scanner(System.in);
            playAgain = decision.nextLine();
        }
        while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n"));
        return playAgain;
    }
    public static boolean checkWinner(char[] board, char player) {
        return (board[0] == player && board[1] == player && board[2] == player)
                || (board[3] == player && board[4] == player && board[5] == player)
                || (board[6] == player && board[7] == player && board[8] == player)
                || (board[0] == player && board[4] == player && board[8] == player)
                || (board[2] == player && board[4] == player && board[6] == player)
                || (board[0] == player && board[3] == player && board[6] == player)
                || (board[1] == player && board[4] == player && board[7] == player)
                || (board[2] == player && board[5] == player && board[8] == player);
    }
}
