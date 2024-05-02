package Resuourse.Map;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {

    private static final long serialVersionUID = 19L;
    
    private ArrayList<Box> row = new ArrayList<Box>();


    public void addEmptyFirst() {
        row.add(new Path());
    }

    public int size() {
        return row.size();
    }

    public Box get(int x) {
        return row.get(x);
    }

    public void remuve(int x) {
        row.set(x, new Path());
    }

    public void setRobot(int x) {
        row.set(x, new Robot());
    }

    public int getBoxsSize() {
        return row.size();
    }

    public Box getPos(int x) {
        return row.get(x);
    }


    public void setRoad(Position robot, Position toGo) {
        row.set(robot.getY(), new Road(toGo));
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

    public Box getPosition(Position box) {
        return row.get(box.getY());
    }
}
