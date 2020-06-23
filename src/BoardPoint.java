// A point consists of an X coordinate and a Y coordinate
public class BoardPoint {
    private int xCoordinate;
    private int yCoordinate;

    public BoardPoint() {
        xCoordinate = 0;
        yCoordinate = 0;
    }

    //Constructor
    public BoardPoint(int xCor, int yCor) {
        xCoordinate = xCor;
        yCoordinate = yCor;
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }



}
