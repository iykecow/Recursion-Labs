import java.util.Scanner;

public class Main 
{
    public static void main(String [] args)
    {
        System.out.println("Please enter board dimensions: ");
        System.out.println("Please note that it is impossible to solve the Knight's tour for boards of less than 5x5");

        Scanner in = new Scanner(System.in);

        System.out.println("X: ");
        String choiceX = in.nextLine();
        while(Integer.parseInt(choiceX) <= 4)
        {
            System.out.println("Invalid");
            choiceX = in.nextLine();
        }

        System.out.println("Y: ");
        String choiceY = in.nextLine();
        while(Integer.parseInt(choiceY) <= 4)
        {
            System.out.println("Invalid");
            choiceY = in.nextLine();
        }
        // System.out.println(Integer.parseInt(choiceX));
        // System.out.println(Integer.parseInt(choiceY));

        int [][] data = new int[Integer.parseInt(choiceX)][Integer.parseInt(choiceY)];
        
        
        new KnightsTour(data);
    }
}