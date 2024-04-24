package Resuourse.Map;

public abstract class Box {

    public float CalcDist(int posX, int posY, int x, int y) {
        float dist = 0;

        dist = (float) Math.sqrt(Math.pow((posX - x), 2) + Math.pow((posY - y), 2));

        return dist;
    }
}