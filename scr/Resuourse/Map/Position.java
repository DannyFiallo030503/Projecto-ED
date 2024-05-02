package scr.Resuourse.Map;

import java.io.Serializable;

public class Position implements Serializable{

    private static final long serialVersionUID = 12L;

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
        return new Position(x + 1, y);
    }

    public Position decrX() {
        return new Position(x - 1, y);
    }

    public Position incrY() {
        return new Position(x, y + 1);
    }
    
    public Position decrY() {
        return new Position(x, y - 1);
    }
}
