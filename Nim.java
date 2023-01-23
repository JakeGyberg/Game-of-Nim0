/* 
 * Jake Gyberg
 * Game of Nim
 * 1/22/23
 */

import java.util.Scanner;

public class Nim {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean playing;
    private Player activePlayer;
    private int playerInput;
    private boolean invalid;

    public Nim ()
    {
        player1 = new Player();
        player2 = new Player();
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
            //Validate input
            invalid = true;
            while (invalid)
            {
                playerInput = input.nextInt();

                if (0 < playerInput && playerInput <= (int) (board.getPieces() / 2))
                {
                    invalid = false;
                } else {
                    System.out.println("Invalid input. Please enter a whole numebr from 1 to half the pile size");
                }
            }
            //change pile
            board.removePieces(playerInput);
            //check for winners
            if (board.getPieces() == 1)
            {
                activePlayer.changeScore(1);
                playing = false;
                System.out.println(activePlayer.getName() + " won that round. " + player1.getName() + " has " + player1.getScore() + " wins. " + player2.getName() + " has " + player2.getScore() + " wins. Play again? '1' = yes '2' = no");
                invalid = true;
                while (invalid)
                {
                    playerInput = input.nextInt();

                    if (1 == playerInput || playerInput == 2)
                    {
                        invalid = false;
                    } else {
                        System.out.println("Invalid input. Please enter 1 to play again or 2 to quit.");
                    }
                }
                if (playerInput == 1)
                {
                    play();
                }

            }
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
