package Resuourse.HillClimbing;

import java.util.ArrayList;

import Resuourse.Map.End;
import Resuourse.Map.Map;
import Resuourse.Map.Path;
import Resuourse.Map.Position;

public class HillClimbing {
    
    private Map map;

    public HillClimbing() {

    }

    public HillClimbing(Map map) {
        this.map = map;
    }

    public boolean searchBestWay(Position robot) {
        double minDistEclidian = Double.MAX_VALUE;
        Position temp = null;
        double euclid = 0;
            
        if (map.getPosition(robot) instanceof End) {
            return true;
        }

        // tomo todos los vecinos de una posicion
        ArrayList<Position> neighour = getNeighour(robot);

        if (neighour.isEmpty()) {
            return false;
        }

        // calculo la distancia euclidiana de los datos t 
        for (int i = 0; i < neighour.size(); i++) {
            euclid = calcDistanceEuclidian(neighour.get(i));
            if (euclid < minDistEclidian) {
                temp = neighour.get(i);
                minDistEclidian = euclid;
            }
        }

        map.setRoad(robot, temp);

        return searchBestWay(temp);
    }

    public double calcDistanceEuclidian(Position robot) {
        return Math.sqrt( Math.pow( (((double)robot.getX()) - ((double)map.getEndPos().getX())), 2)  + Math.pow( ((double)robot.getY() - ((double)map.getEndPos().getY())), 2 ) );
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public ArrayList<Position> getNeighour(Position boxPos) {
        ArrayList<Position> neighour = new ArrayList<Position>();

        if (boxPos.getX() > 0)
            if (this.map.getPosition(boxPos.decrX()) instanceof Path)
                neighour.add(boxPos.decrX());         

        if (boxPos.getX() < map.getWidth())
            if (this.map.getPosition(boxPos.incrX()) instanceof Path)
                neighour.add(boxPos.incrX());

        if (boxPos.getY() > 0)
            if (this.map.getPosition(boxPos.decrY()) instanceof Path)
                neighour.add(boxPos.decrY());

        if (boxPos.getY() < map.getHeight())
            if (this.map.getPosition(boxPos.incrY()) instanceof Path)
                neighour.add(boxPos.incrY());

        return neighour;
    }
}
