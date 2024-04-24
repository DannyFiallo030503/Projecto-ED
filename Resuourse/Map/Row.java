package Resuourse.Map;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {
    
    private ArrayList<Box> row = new ArrayList<Box>();


    public void addEmptyFirst() {
        row.add(new Path());
    }


    public Box getPos(int x) {
        return row.get(x);
    }

    public void setRobot(int x) {
        row.set(x, new Robot());
    }

    public void setObstacle(int x) {
        row.set(x, new Obstacle());
    }

    public void setEnd(int x) {
        row.set(x, new End());
    }

    public ArrayList<Box> getRow() {
        return row;
    }
}
