public class Ball {
    private Color color;
    public Ball(){
        color =null;}
    public Ball(Color color){this.color =color;}
    public Color GetStatus(){
        return color;
    }
    public void SetStatus(Color color){
        this.color =color;
    }
}
