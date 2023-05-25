import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Dummy {
    public Player(Color color) {
        super(color);
    }

    @Override
    public void PickAction(Board board){
        Scanner sc= new Scanner(System.in);
        int inputChoice = 0;
        System.out.println("1 : Place the ball");
        System.out.println("2 : Rotate quadrant");
        try {
            System.out.print("Choose your action:");
            inputChoice= sc.nextInt();
            switch (inputChoice){
                case 1:
                    PickPosition(board);
                    break;
                case 2:
                    PickQuadrant(board);
                    break;
                default:
                    throw new IOException("Wrong input '"+inputChoice +"', try again");
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
        catch (InputMismatchException exception){System.out.print("This is not a number. Try again");}

    }
    @Override
    public void PickPosition(Board board) {
        Scanner sc= new Scanner(System.in);
        int row;
        int column;
        boolean isTrue = false;
        while(!isTrue) {
            try {
                System.out.print("Choose a row:");
                row = sc.nextInt();
                if (row < 1 && row > 6) throw new IOException("Wrong input '" + row + "', try again");
                System.out.print("Choose a column:");
                column = sc.nextInt();
                if (column < 1 && column > 6) throw new IOException("Wrong input '" + row + "', try again");
                if (board.getBoard()[(row - 1) / 3][(column - 1) / 3].getQuadrant()[(row - 1) % 3][(column - 1) % 3].GetStatus() != null)
                    throw new IOException("There already ball at '" + row + "' row and '" + column + "' column, try again");
                PlaceBall(board, row, column, color);
                isTrue=true;
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
                isTrue=false;
            } catch (InputMismatchException exception) {
                System.out.println("This is not a number. Try again");
                sc = new Scanner(System.in);
                isTrue=false;
            }
        }
    }
    @Override
    public void PickQuadrant(Board board){
        Scanner sc= new Scanner(System.in);
        int inputChoice;
        Quadrant quadrant = new Quadrant();
        boolean isTrue = false;
        while(!isTrue) {
            try {
                System.out.println("1. Left top");
                System.out.println("2. Right top");
                System.out.println("3. Left bottom");
                System.out.println("4. Right bottom");
                System.out.print("Choose a quadrant to rotate:");
                inputChoice = sc.nextInt();
                if (inputChoice < 1 && inputChoice > 4)
                    throw new IOException("Wrong input '" + inputChoice + "', try again");
                else quadrant = board.getBoard()[(inputChoice - 1) / 2][(inputChoice - 1) % 2];
                System.out.println("1. Left");
                System.out.println("2. Right");
                System.out.print("Choose a side to rotate:");
                inputChoice = sc.nextInt();
                if (inputChoice == 1) RotateToLeft(quadrant);
                else if (inputChoice == 2) RotateToRight(quadrant);
                else throw new IOException("Wrong input '" + inputChoice + "', try again");
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
