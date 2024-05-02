package scr.Resuourse.Map;

import java.io.Serializable;

public abstract class Box implements Serializable {

    public float CalcDist(int posX, int posY, int x, int y) {
        float dist = 0;

        dist = (float) Math.sqrt(Math.pow((posX - x), 2) + Math.pow((posY - y), 2));

        return dist;
    }
}