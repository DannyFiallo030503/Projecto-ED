package Resuourse.Map;

import java.util.LinkedList;
import java.util.Random;

public class Map {

    private LinkedList<Row> map;

    private int width;
    private int height;

    public Map(int x, int y) {
        width = x;
        height = y;

        for (int i = 0; i < x; i++) {
            Row row = new Row();

            for (int j = 0; j < y; j++) {
                row.addEmptyLast(i, j);
            }

            map.addLast(row);
        }

    }

    public Map() {
        map = null;
    }

    public void generatePosRobot() {
        Random rand = new Random();
        boolean stop = false;

        do {

            int x = rand.nextInt(width);
            int y = rand.nextInt(height);

            if (map.get(x).row.get(y) instanceof Path) {
                map.get(x).row.set(y, new Robot(x, y));
                stop = true;
            } 

        } while(!stop);
    }

}
