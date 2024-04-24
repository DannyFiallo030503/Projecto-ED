package Resuourse.Map;

import java.util.ArrayList;
import java.util.Random;

public class Map {

    private ArrayList<Row> map;

    private int width;
    private int height;

    public Map(int x, int y) {
        width = x;
        height = y;

        for (int i = 0; i < x; i++) {
            Row row = new Row();

            for (int j = 0; j < y; j++) {
                
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
        int x;
        int y;

        do {

            x = rand.nextInt(width);
            y = rand.nextInt(height);

            if (map.get(x).getPos(y) instanceof Path) {
                stop = true;
            }

        } while(!stop);

        map.get(x).getPos(y).
    }


}
