public class Board {
    private char[][] board;
    //Constructor
    public Board(int size) {
        board = new char[size][size];
    }


    //Marks the board with a player's input
    public void markBoard(BoardPoint input, int player) {
        if(player == 1) {
            //Mark with X
            board[input.getY()][input.getX()] = 'X';
        } else {
            //Mark with O
            board[input.getY()][input.getX()] = 'O';
        }
    }


    public char[][] getBoard() {
        return board;
    }
}
