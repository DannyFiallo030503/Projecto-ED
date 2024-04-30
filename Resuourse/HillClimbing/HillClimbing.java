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
        double minDistEclidian;
        Position temp = null;
        double euclid = 0;
        boolean finish = false;
        boolean found = false;
            
        while (!finish) {
            minDistEclidian = Double.MAX_VALUE;
            euclid = 0;
            // condicion de parada por si llega al final
            if (map.getPosition(robot) instanceof End) {
                found = true;
                finish = true;
            }

            // tomo todos los vecinos de una posicion
            ArrayList<Position> neighour = getNeighour(robot);

            // condicion de parada si no hay mas camino
            if (neighour.isEmpty()) {
                finish = true;
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
            robot = temp;
            System.out.println();
            showMapInTerminal();
        }

        return found;
    }

    public double calcDistanceEuclidian(Position robot) {
        return Math.sqrt( Math.pow( (((double)robot.getX()) - ((double)map.getEndPos().getX())), 2)  + Math.pow( ((double)robot.getY() - ((double)map.getEndPos().getY())), 2 ) );
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public ArrayList<Position> getNeighour(Position boxPos) {
        ArrayList<Position> neighour = new ArrayList<Position>();

        // reviso si tiene vecinos arriba abajo a la dereecha y la izquierda
        isUp(boxPos, neighour);
        isDown(boxPos, neighour);
        isLeft(boxPos, neighour);
        isRigth(boxPos, neighour);

        return neighour;
    }

    private boolean isUp(Position boxPos, ArrayList<Position> neighour) {
        boolean have = true;

        try {
            if (this.map.getPosition(boxPos.decrX()) instanceof Path || this.map.getPosition(boxPos.decrX()) instanceof End) {
                neighour.add(boxPos.decrX());    
            } 
        } catch (IndexOutOfBoundsException e) {
            have = false;
        }

        return have;
    }

    private boolean isDown(Position boxPos, ArrayList<Position> neighour) {
        boolean have = true;

        try {
            if (this.map.getPosition(boxPos.incrX()) instanceof Path || this.map.getPosition(boxPos.incrX()) instanceof End) {
                neighour.add(boxPos.incrX());
            }
        } catch (IndexOutOfBoundsException e) {
            have = false;
        }

        return have;
    }

    private boolean isLeft(Position boxPos, ArrayList<Position> neighour) {
        boolean have = true;

        try {
            if (this.map.getPosition(boxPos.decrY()) instanceof Path || this.map.getPosition(boxPos.decrY()) instanceof End) {
                neighour.add(boxPos.decrY());
            }
        } catch (IndexOutOfBoundsException e) {
            have = false;
        }

        return have;
    }

    private boolean isRigth(Position boxPos, ArrayList<Position> neighour) {
        boolean have = true;

        try {
            if (this.map.getPosition(boxPos.incrY()) instanceof Path || this.map.getPosition(boxPos.incrY()) instanceof End) {
                neighour.add(boxPos.incrY());
            }
        } catch (IndexOutOfBoundsException e) {
            have = false;
        }

        return have;
    }    

    public void showMapInTerminal() {
        map.showInTerminal();
    }
}
