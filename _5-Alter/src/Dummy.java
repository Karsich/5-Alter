public abstract class Dummy {
    public Color color;
    public Dummy(Color color){this.color = color;}
    public abstract void PickAction(Board board);
    public abstract void PickQuadrant(Board board);
    public abstract void PickPosition(Board board);

    public void RotateToRight(Quadrant quadrant) {
        Ball[][] resultArray = new Ball[quadrant.getQuadrant()[0].length][quadrant.getQuadrant().length];
        for (int  i =0;i<quadrant.getQuadrant().length; i++) {
            for (int j = 0; j < quadrant.getQuadrant()[i].length; j++) {
                resultArray[j][quadrant.getQuadrant().length - i - 1] = quadrant.getQuadrant()[i][j];
            }
        }
        quadrant.setQuadrant(resultArray);
    }

    public void RotateToLeft(Quadrant quadrant) {
        Ball[][] resultArray = new Ball[quadrant.getQuadrant()[0].length][quadrant.getQuadrant().length];
        for (int i = 0; i < quadrant.getQuadrant().length; i++) {
            for (int j = 0; j < quadrant.getQuadrant()[i].length; j++) {
                resultArray[quadrant.getQuadrant()[i].length - j - 1][i] = quadrant.getQuadrant()[i][j];
            }
        }
        quadrant.setQuadrant(resultArray);
    }
    public void PlaceBall(Board board, int row, int column, Color status){
        board.getBoard()[(row-1)/3][(column-1)/3].getQuadrant()[(row-1)%3][(column-1)%3].SetStatus(status);
    }
}
