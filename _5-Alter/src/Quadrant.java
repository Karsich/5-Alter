public class Quadrant {
    private Ball[][] quadrant;


    public Quadrant() {
        quadrant = new Ball[3][3];
        for(int x = 0;x<3;x++)
            for(int y = 0;y<3;y++)
                quadrant[x][y]=new Ball();
    }

    public Ball[][] getQuadrant() {
        return quadrant;
    }
    public void setQuadrant(Ball[][] quadrant) {
        this.quadrant= quadrant ;
    }
    public boolean IsFull(){
        for(int x = 0;x<3;x++)
            for(int y = 0;y<3;y++)
                if (quadrant[x][y].GetStatus()==null) return false;
        return true;
    }

}
