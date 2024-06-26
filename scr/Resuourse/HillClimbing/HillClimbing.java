package scr.Resuourse.HillClimbing;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

import scr.Resuourse.Map.End;
import scr.Resuourse.Map.Map;
import scr.Resuourse.Map.Path;
import scr.Resuourse.Map.Position;
import scr.Resuourse.Map.Row;
import scr.Resuourse.Map.Box;
import Resuourse.Data.Convert;


public class HillClimbing {
    
    private Map map;

    public HillClimbing() {

    }

    public HillClimbing(Map map) {
        this.map = map;
    }

    public void saveMap(File fileDirectory) {
        try {
            // abro fichero
            RandomAccessFile file = new RandomAccessFile(fileDirectory, "rw");

            file.writeInt(map.getRowSize());
            ArrayList<Row> rows = map.getRows();

            for (Row r : rows) {
                file.writeInt(r.getBoxsSize());

                ArrayList<Box> boxs = r.getRow();
                for (Box b : boxs) {
                    byte[] bb = Convert.toBytes(b);
                    file.writeInt(bb.length);
                    file.write(bb);
                }
            }
            file.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
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

    public boolean eliminateRobot() {
        boolean isDeleter = false;
        isDeleter = map.eliminateRobot();
        return isDeleter;
    }

    public void setRobot(Position position) {
        map.setRobot(position);
    }

    public Position searchRobot() {
        return map.searchRobot();
    }
}
