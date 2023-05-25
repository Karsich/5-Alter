public class Board {
    private Quadrant[][] board;
    public Board(){
        board = new Quadrant[2][2];
        for(int x = 0;x<2;x++)
            for(int y = 0;y<2;y++)
                board[x][y]=new Quadrant();
    }
    public Quadrant[][] getBoard(){return board;}

    public void setBoard(Quadrant[][] board) {
        this.board = board;
    }
    public boolean IsFull(){
        for(int x = 0;x<2;x++)
            for(int y = 0;y<2;y++)
                if (!board[x][y].IsFull()) return false;
        return true;
    }
}
