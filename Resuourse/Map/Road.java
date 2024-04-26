package Resuourse.Map;


public class Road extends Box {

    private Position toGo;

    public Road(Position toGo) {
        this.toGo = toGo;
    }

    public Position getToGo() {
        return toGo;
    }

    public void setToGo(Position toGo) {
        this.toGo = toGo;
    }


}
