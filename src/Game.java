import java.util.Scanner;
public class Game {
    private boolean gameOver;
    private boolean player2Turn;
    private int playerWinner;
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




        checkForWin();

        //If somebody won, the current player's turn is the winner
        playerWinner = player;



        //Now change players for next rotation IF the game isn't over
        if(!gameOver) {
            if(!player2Turn) {
                player2Turn = true;
            } else {
                player2Turn = false;
            }
        }

    }

    public void checkForWin() {
        //A win is if you fill up a row, fill up a column, or fill up a diagonal
        boolean rowWin = false; //Default false unless have all same in row
        boolean columnWin = false;
        boolean diagonalWin = false;

        char[][] disBoard  = gameBoard.getBoard(); //disBoard references our 2d array

        //TODO: Remove debugger statement
        System.out.println("State of array");
        for(int i = 0; i < disBoard.length; i++) {
            for(int j = 0; j < disBoard[i].length; j++) {
                System.out.print(disBoard[i][j] + " " );
            }
            System.out.println();
        }

        //Check for row win con
        for(int i = 0; i < disBoard.length; i++) {
            char prevDigit = disBoard[i][0];
            for(int j = 0; j < disBoard[i].length; j++) {
                //Each entry in row must equal the previous
                if(Character.isLetter(prevDigit) && prevDigit == disBoard[i][j]) {
                    rowWin = true;
                } else {
                    //Otherwise, this row is invalid
                    rowWin = false;
                    j = disBoard[i].length - 1;
                }
                prevDigit = disBoard[i][j];
            }
            //We do not need to check other rows if we already have a row win
            if(rowWin) {
                System.out.println("Row win");
                break;
            }
        }

        //Check for column win con
        for(int j = 0; j < disBoard[0].length; j++) {
            char prevDigit = disBoard[0][j];
            for(int i = 0; i < disBoard.length; i++) {
                //Each entry in column must equal the previous
                if(Character.isLetter(prevDigit) && prevDigit == disBoard[i][j]) {
                    columnWin = true;
                } else {
                    //Otherwise, this column is invalid
                    columnWin = false;
                    i = disBoard.length - 1;
                }
                prevDigit = disBoard[i][j];
            }
            //We do not need to check other columns if we already have a column win
            if(columnWin) {
                System.out.println("Column win");
                break;
            }
        }





        //If any of win conditions hold, the game ends
        if(rowWin || columnWin || diagonalWin) {
            gameOver = true;
        }
    }

}
