package Resuourse.Map;

public class Position {

    private int x;  
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public Position incrX() {
        return new Position(x++, y);
    }

    public Position decrX() {
        return new Position(x--, y);
    }

    public Position incrY() {
        return new Position(x, y++);
    }
    
    public Position decrY() {
        return new Position(x, y--);
    }
}
