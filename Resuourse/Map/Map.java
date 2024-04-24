package Resuourse.Map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Map implements Serializable {

    private ArrayList<Row> map = new ArrayList<Row>();

    private int width;
    private int height;

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
        generatePosRobot();
    }

    public Map() {
        map = null;
    }

    public void generatePosRobot() {
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
            }
            System.out.println("");
        }
    }
}
