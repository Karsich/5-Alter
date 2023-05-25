public class UglyDraw implements Drawable{
    // / Т \
    // | + | - |
    // \ | /
    String UPPER_LEFT_CORNER= "/";
    String UPPER_TRANSVERSAL= "Т";
    String UPPER_RIGHT_CORNER= "\\";
    String MIDDLE_LEFT_CORNER= "|";
    String MIDDLE_TRANSVERSAL= "+";
    String MIDDLE_RIGHT_CORNER= "|";
    String LOWER_LEFT_CORNER= "\\";
    String LOWER_TRANSVERSAL= "|";
    String LOWER_RIGHT_CORNER= "/";
    String VERTICAL_BAR ="|";
    String HORIZONTAL_BAR="-";
    String BLANK=" ";
    String WHITE="W";
    String BLACK="B";

    public void Draw(Board board)
    {
        for(int x = 0;x<13;x++) {
            for (int y = 0; y < 13; y++) {
                if(x==0) {
                    if (y == 0) System.out.print(UPPER_LEFT_CORNER);
                    else if (y == 12) System.out.println(UPPER_RIGHT_CORNER);
                    else if (y%2==0) System.out.print(UPPER_TRANSVERSAL);
                    else System.out.print(HORIZONTAL_BAR);
                }
                else if (x==12)
                {
                    if (y == 0) System.out.print(LOWER_LEFT_CORNER);
                    else if (y == 12) System.out.println(LOWER_RIGHT_CORNER);
                    else if (y%2==0) System.out.print(LOWER_TRANSVERSAL);
                    else System.out.print(HORIZONTAL_BAR);
                }
                else if (x%2==0){
                    if (y == 0) System.out.print(MIDDLE_LEFT_CORNER);
                    else if (y == 12) System.out.println(MIDDLE_RIGHT_CORNER);
                    else if (y%2==0) System.out.print(MIDDLE_TRANSVERSAL);
                    else System.out.print(HORIZONTAL_BAR);
                }
                else {
                    if (y%2==0) System.out.print(VERTICAL_BAR);
                    else {
                        if (board.getBoard()[x/6][y/6].getQuadrant()[(x/2)%3][(y/2)%3].GetStatus()== null)
                            System.out.print(BLANK);
                        else if(board.getBoard()[x/6][y/6].getQuadrant()[(x/2)%3][(y/2)%3].GetStatus()== Color.BLACK)
                            System.out.print(BLACK);
                        else if(board.getBoard()[x/6][y/6].getQuadrant()[(x/2)%3][(y/2)%3].GetStatus()== Color.WHITE)
                            System.out.print(WHITE);
                    }
                    if (y==12) System.out.println("");
                }
            }
        }

    }

}
