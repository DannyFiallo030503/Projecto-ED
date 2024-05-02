package Resuourse.Map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Map implements Serializable {

    private static final long serialVersionUID = 11L;

    private ArrayList<Row> map = new ArrayList<Row>();

    private int width; // x
    private int height; // y   
    private Position endPos;

    public Map(int x, int y, int obst) {
        width = x;
        height = y;

        int i;
        int j;

        // genera un mapa vacio lleno de caminos abiertos para caminar
        for (i = 0; i < x; i++) {
            Row row = new Row();
            for (j = 0; j < y; j++) {
                row.addEmptyFirst();
            }
            map.addFirst(row);
        }

        // genera de manera aleatoria la posicion de los obtaculos y cuantos obstaculos van a haber
        for (i = 0; i < obst; i++) {
            generatePosObstacle();
        }

        //genera la posicion de la salida
        generatePosEnd();

        // genera la posicion del robot
        //generatePosRobot();
    }

    public Map() {
        map = null;
    }

    public int getRowSize() {
        return map.size();
    }

    public ArrayList<Row> getRows() {
        return map;
    }

    public boolean eliminateRobot() {
        boolean isDeleter = false;
        Position robot = searchRobot();
        
        if(robot != null) {
            deletPosition(robot);
            isDeleter = true;
        }

        return isDeleter;
    }

    public void setRobot(Position robot) {
        map.get(robot.getX()).setRobot(robot.getY());
    }

    public void deletPosition(Position position) {
        map.get(position.getX()).remuve(position.getY());
    }

    public Position searchRobot() {
        Position robot = null;

        for (int i = 0; i < map.size() && robot == null; i++) {
            for (int j = 0; j < map.get(i).size() && robot == null; j++) {
                if (map.get(i).get(j) instanceof Robot) {
                    robot = new Position(i, j);
                }
            }
        }

        return robot;
    }


    public Position generatePosRobot() {
        Random rand = new Random();
        boolean stop = false;
        int x;
        int y;

        do {

            x = rand.nextInt(width);
            y = rand.nextInt(height);

            if (map.get(x).getPos(y) instanceof Path) {
                stop = true;
            }

        } while(!stop);

        map.get(x).setRobot(y);

        return new Position(x, y);
    }

    public void generatePosEnd() {
        Random rand = new Random();
        boolean stop = false;
        int x;
        int y;

        do {

            x = rand.nextInt(width);
            y = rand.nextInt(height);

            if (map.get(x).getPos(y) instanceof Path) {
                stop = true;
            }

        } while(!stop);

        setPosEnd(x, y);
        this.endPos = new Position(x,y);
    }

    public void setPosEnd(int x, int y) {
        map.get(x).setEnd(y);
    }

    public void generatePosObstacle() {
        Random rand = new Random();
        boolean stop = false;
        int x;
        int y;

        do {

            x = rand.nextInt(width);
            y = rand.nextInt(height);

            if (map.get(x).getPos(y) instanceof Path) {
                stop = true;
            }

        } while(!stop);

        map.get(x).setObstacle(y);

    }

    public void setRoad(Position robot, Position toGo) {
        map.get(robot.getX()).setRoad(robot, toGo);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Box getPosition(Position box) {
        return map.get(box.getX()).getPosition(box);
    }

    public Position getEndPos() {
        return endPos;
    }

    public void setEndPos(Position endPos) {
        this.endPos = endPos;
    }
   
    public ArrayList<Row> getMap() {
        return map;
    }

    public void setMap(ArrayList<Row> map) {
        this.map = map;
    }

    
    public void showInTerminal() {
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).getRow().size(); j++) {
                if (map.get(i).getRow().get(j) instanceof Path)
                    System.out.print("0 ");
                else if (map.get(i).getRow().get(j) instanceof Obstacle)
                    System.out.print("| ");
                else if (map.get(i).getRow().get(j) instanceof Robot) 
                    System.out.print("R ");
                else if (map.get(i).getRow().get(j) instanceof End)
                    System.out.print("E ");
                else if (map.get(i).getRow().get(j) instanceof Road)
                    System.out.print("P ");
            }   
            System.out.println("");
        }
    }
}
