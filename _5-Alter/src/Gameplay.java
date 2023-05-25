import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gameplay {
    public static void Menu(Dummy[] players){
        Board board = new Board();
        Drawable driver = PickDrawDriver();
        boolean isEnd = false;
        int countRound = 1;
        driver.Draw(board);
        while(!isEnd){
            for(Dummy player : players){
                System.out.println("Round №" + countRound);
                System.out.println("Move for " + player.color.name() + " player");
                player.PickAction(board);
                driver.Draw(board);
                countRound=countRound+1;
                CheckHorizontalWin(board);
                CheckDiagonalWin(board);
                CheckVerticalWin(board);
                CheckDraw(board);
            }
        }
    }
    private static void CheckHorizontalWin(Board board){
        for (int x = 0;x<6;x++)
           for (int y = 0;y<2;y++){
               Color trueColor = board.getBoard()[x/3][y/3].getQuadrant()[x%3][y%3].GetStatus();
               int countTrueColor=1;
               for(int z = 1;z<5;z++){
                   if (board.getBoard()[x/3][(y+z)/3].getQuadrant()[x%3][(y+z)%3].GetStatus()==trueColor) countTrueColor+=1;
               }
               if (countTrueColor==5&&trueColor!=null) WinnerCongrats(trueColor);
           }

    }
    private static void CheckVerticalWin(Board board){
        for (int x = 0;x<2;x++)
            for (int y = 0;y<6;y++){
                Color trueColor = board.getBoard()[x/3][y/3].getQuadrant()[x%3][y%3].GetStatus();
                int countTrueColor=1;
                for(int z = 1;z<5;z++){
                    if (board.getBoard()[(x+z)/3][y/3].getQuadrant()[(x+z)%3][y%3].GetStatus()==trueColor) countTrueColor+=1;
                }
                if (countTrueColor==5&&trueColor!=null) WinnerCongrats(trueColor);
            }
    }
    private static void CheckDiagonalWin(Board board){
        for (int x = 0;x<2;x++)
            for (int y = 0;y<2;y++){
                Color trueColor = board.getBoard()[x/3][y/3].getQuadrant()[x%3][y%3].GetStatus();
                int countTrueColor=1;
                for(int z = 1;z<5;z++){
                    if (board.getBoard()[(x+z)/3][(y+z)/3].getQuadrant()[(x+z)%3][(y+z)%3].GetStatus()==trueColor) countTrueColor+=1;
                }
                if (countTrueColor==5&&trueColor!=null) WinnerCongrats(trueColor);
            }
    }
    private static void CheckDraw(Board board){
        if(board.IsFull()){
            WinnerCongrats(null);
        }
    }
    private static void WinnerCongrats(Color winner){
        String coolWinner = "\n" +
                "██████╗░██████╗░░█████╗░░██╗░░░░░░░██╗██╗\n" +
                "██╔══██╗██╔══██╗██╔══██╗░██║░░██╗░░██║██║\n" +
                "██║░░██║██████╔╝███████║░╚██╗████╗██╔╝██║\n" +
                "██║░░██║██╔══██╗██╔══██║░░████╔═████║░╚═╝\n" +
                "██████╔╝██║░░██║██║░░██║░░╚██╔╝░╚██╔╝░██╗\n" +
                "╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝";
        if (winner==Color.BLACK) coolWinner ="\n" +
                "██████╗░██╗░░░░░░█████╗░░█████╗░██╗░░██╗  ░██╗░░░░░░░██╗██╗███╗░░██╗\n" +
                "██╔══██╗██║░░░░░██╔══██╗██╔══██╗██║░██╔╝  ░██║░░██╗░░██║██║████╗░██║\n" +
                "██████╦╝██║░░░░░███████║██║░░╚═╝█████═╝░  ░╚██╗████╗██╔╝██║██╔██╗██║\n" +
                "██╔══██╗██║░░░░░██╔══██║██║░░██╗██╔═██╗░  ░░████╔═████║░██║██║╚████║\n" +
                "██████╦╝███████╗██║░░██║╚█████╔╝██║░╚██╗  ░░╚██╔╝░╚██╔╝░██║██║░╚███║\n" +
                "╚═════╝░╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝";
        else if(winner==Color.WHITE) coolWinner= "\n" +
                "░██╗░░░░░░░██╗██╗░░██╗██╗████████╗███████╗  ░██╗░░░░░░░██╗██╗███╗░░██╗\n" +
                "░██║░░██╗░░██║██║░░██║██║╚══██╔══╝██╔════╝  ░██║░░██╗░░██║██║████╗░██║\n" +
                "░╚██╗████╗██╔╝███████║██║░░░██║░░░█████╗░░  ░╚██╗████╗██╔╝██║██╔██╗██║\n" +
                "░░████╔═████║░██╔══██║██║░░░██║░░░██╔══╝░░  ░░████╔═████║░██║██║╚████║\n" +
                "░░╚██╔╝░╚██╔╝░██║░░██║██║░░░██║░░░███████╗  ░░╚██╔╝░╚██╔╝░██║██║░╚███║\n" +
                "░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░░╚═╝░░░╚══════╝  ░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚══╝";
        System.out.println(coolWinner);
        System.exit(0);

    }
    private static Drawable PickDrawDriver(){
        Scanner sc= new Scanner(System.in);
        int inputChoice = 0;
        try {
            System.out.println("1 : Use old graphic driver");
            System.out.println("2 : Use new graphic driver");
            System.out.print("Choose your driver:");
            inputChoice= sc.nextInt();
            if (inputChoice==1) { return new UglyDraw();}
            else if (inputChoice==2) { return new FineDraw();}
            else throw new IOException("Wrong input '"+inputChoice +"', try again");
        }
        catch(IOException exception){exception.getMessage();}
        catch (InputMismatchException exception){System.out.print("This is not a number. Try again");}
        return new FineDraw();
    }
}
