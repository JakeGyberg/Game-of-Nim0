import java.util.Scanner;

public class Player {
    private String name;
    private int score;

    public Player ()
    {
        System.out.println("Enter player name");
        Scanner sc = new Scanner(System.in);

        name = sc.nextLine();;
        System.out.println("Hello " + name);

        score = 0;
    }

    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }

    public void changeScore(int num)
    {
        score += num;
    }
}
