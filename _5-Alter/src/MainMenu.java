import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public static void Menu()
    {
        Scanner sc= new Scanner(System.in);
        int inputChoice = 0;
        System.out.println("\n" +
                "██████╗░███████╗███╗░░██╗████████╗░█████╗░░██████╗░░█████╗░\n" +
                "██╔══██╗██╔════╝████╗░██║╚══██╔══╝██╔══██╗██╔════╝░██╔══██╗\n" +
                "██████╔╝█████╗░░██╔██╗██║░░░██║░░░███████║██║░░██╗░██║░░██║\n" +
                "██╔═══╝░██╔══╝░░██║╚████║░░░██║░░░██╔══██║██║░░╚██╗██║░░██║\n" +
                "██║░░░░░███████╗██║░╚███║░░░██║░░░██║░░██║╚██████╔╝╚█████╔╝\n" +
                "╚═╝░░░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═╝░░╚═╝░╚═════╝░░╚════╝░");
        boolean isTrue = false;
        while(!isTrue) {
            try {
                System.out.println("1 : Play against human");
                System.out.println("2 : Play against CPU");
                System.out.print("Choose your enemy:");
                inputChoice = sc.nextInt();
                if (inputChoice == 1) {
                    Dummy[] players = new Dummy[2];
                    players[0] = new Player(Color.WHITE);
                    players[1] = new Player(Color.BLACK);
                    Gameplay.Menu(players);
                } else if (inputChoice == 2) {
                    System.out.println("1 : Play as black");
                    System.out.println("2 : Play as white");
                    System.out.print("Choose your color:");
                    inputChoice = sc.nextInt();
                    Dummy[] players = new Dummy[2];
                    if (inputChoice == 1) {
                        players[0] = new CPU(Color.WHITE);
                        players[1] = new Player(Color.BLACK);
                        Gameplay.Menu(players);
                    } else if (inputChoice == 2) {
                        players[0] = new Player(Color.WHITE);
                        players[1] = new CPU(Color.BLACK);
                        Gameplay.Menu(players);
                    }
                } else throw new IOException("Wrong input '" + inputChoice + "', try again");
                isTrue=true;
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
                isTrue = false;
            } catch (InputMismatchException exception) {
                System.out.println("This is not a number. Try again");
                sc = new Scanner(System.in);
                isTrue = false;
            }
        }
    }
}

