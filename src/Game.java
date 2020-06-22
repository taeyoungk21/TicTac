import java.util.Scanner;
public class Game {
    private boolean gameOver;
    private boolean player2Turn;
    private Board gameBoard;
    private Scanner in;
    //Constructor
    public Game() {
        in = new Scanner(System.in);
        gameOver = false;
        player2Turn = false; //Starts w/player 1 turn and alternates
        gameBoard = new Board(3);


        while(!gameOver) {
            playGame();
        }

    }

    public void playGame() {
        int xCor = 0;
        int yCor = 0;
        //Take input from player

        //TODO: Check for valid bounds on xCor and yCor, as well as not used already
        if(!player2Turn) {
            //Player 1's turn
            System.out.println("Enter player 1's X coordinate:");
            xCor = in.nextInt();

            System.out.println("Enter player 1's Y coordinate:");
            yCor = in.nextInt();
        } else {
            //Player 2 turn
            System.out.println("Enter player 2's X coordinate");
            xCor = in.nextInt();

            System.out.println("Enter player 2's Y coordinate:");
            yCor = in.nextInt();
        }


        //Mark board - First create point
        BoardPoint newPoint = new BoardPoint(xCor, yCor);
        int player = 0;
        if(!player2Turn) {
            player = 1;
        } else {
            player = 2;
        }

        gameBoard.markBoard(newPoint, player);


        //Now change players for next rotation
        if(!player2Turn) {
            player2Turn = true;
        } else {
            player2Turn = false;
        }

        checkForWin();
    }

    public void checkForWin() {
        //A win is if you fill up a row, fill up a column, or fill up a diagonal

    }

}
