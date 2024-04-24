package Resuourse.Map;

import java.io.Serializable;

public class Road implements Serializable {

    private int toX;  
    private int toY;

    public Road(int toX, int toY) {
        this.toX = toX;
        this.toY = toY;
    }

    public int getToX() {
        return toX;
    }

    public void setToX(int toX) {
        this.toX = toX;
    }

    public int getToY() {
        return toY;
    }

    public void setToY(int toY) {
        this.toY = toY;
    }

}
