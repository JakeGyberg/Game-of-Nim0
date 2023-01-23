public class Board {
    private int pieces;

    public Board()
    {
        pieces = (int) (Math.random() * 40) + 10;
    }

    public int getPieces()
    {
        return pieces;
    }

    public void removePieces (int num)
    {
        pieces -= num;
    }
}
