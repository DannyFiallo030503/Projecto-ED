package Resuourse.Map;

public abstract class Box {

    protected int x;
    protected int y;

    public float CalcDist(int posX, int posY) {
        float dist = 0;

        dist = (float) Math.sqrt(Math.pow((posX - x), 2) + Math.pow((posY - y), 2));

        return dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}