import java.util.Scanner;

public class Nim {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean playAgain;
    private boolean playing;
    private Player activePlayer;

    public Nim ()
    {
        player1 = new Player();
        player2 = new Player();
        playAgain = false;
    }

    public void play()
    {
        Scanner input = new Scanner(System.in);

        board = new Board();

        //Select player to start
        activePlayer = player1;
        if (Math.random() > 0.5)
        {
            activePlayer = player2;
        }

        //Game loop
        playing = true;
        while(playing)
        {
            //prompt player for move
            System.out.println(activePlayer.getName() + ", the pile has " + board.getPieces() + " pieces. How many will you remove?");
            
            board.removePieces(input.nextInt());
            
            //switch players
            if (activePlayer.equals(player1))
            {
                activePlayer = player2;
            } else
            {  
                activePlayer = player1;
            }
        }
    }
}
