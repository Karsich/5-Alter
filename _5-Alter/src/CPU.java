import java.io.IOException;

public class CPU extends Dummy {
    public CPU(Color color) {
        super(color);
    }

    @Override
    public void PickAction(Board board){
        //System.out.println("1 : Place the ball");
        //System.out.println("2 : Rotate quadrant");
        //System.out.print("Choose your action:");
        int inputChoice=1 + (int) ( Math.random() * 100 );
        if (inputChoice<=50) PickQuadrant(board);
        else PickPosition(board);
    }
    @Override
    public void PickPosition(Board board) {
        int row;
        int column;
        boolean isTrue = false;
        while(!isTrue) {
            try {
                row = 1 + (int) (Math.random() * 6);
                column = 1 + (int) (Math.random() * 6);
                System.out.println("CPU placing the ball at " + row + " row and " + column + " column!");
                if (board.getBoard()[(row - 1) / 3][(column - 1) / 3].getQuadrant()[(row - 1) % 3][(column - 1) % 3].GetStatus() != null)
                    throw new IOException("There already ball at '" + row + "' row and '" + column + "' column, try again");
                PlaceBall(board, row, column, color);
                isTrue=true;
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
                isTrue=false;
            }
        }
    }
    @Override
    public void PickQuadrant(Board board){



        //System.out.println("1. Left top");
        //System.out.println("2. Right top");
        //System.out.println("3. Left bottom");
        //System.out.println("4. Right bottom");
        System.out.print("CPU turning the ");
        Quadrant quadrant = new Quadrant();
        int inputChoice=1 + (int) ( Math.random() * 100 );
        if (inputChoice<=25) {quadrant=board.getBoard()[0][0];System.out.print("Left top quadrant");}
        else if (inputChoice>25 && inputChoice<=50) {quadrant=board.getBoard()[0][1];System.out.print("Right top quadrant");}
        else if (inputChoice>50 && inputChoice<=75) {quadrant=board.getBoard()[1][0];System.out.print("Left bottom quadrant");}
        else {quadrant=board.getBoard()[1][1];System.out.print("Right bottom quadrant");}
        //System.out.println("1. Left");
        //System.out.println("2. Right");
        //System.out.print("Choose a side to rotate:");
        inputChoice = 1 + (int) ( Math.random() * 100 );
        if (inputChoice<=50) {
            RotateToLeft(quadrant);
            System.out.println(" to the left!");
        }
        else {
            RotateToRight(quadrant);
            System.out.println(" to the right!");
        }
    }
}
