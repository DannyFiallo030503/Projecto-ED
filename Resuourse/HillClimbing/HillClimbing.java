package Resuourse.HillClimbing;

import java.util.ArrayList;

import Resuourse.Map.Box;
import Resuourse.Map.Map;

public class HillClimbing {
    
    private Map map;
    
    public ArrayList<Box> getNeighour(Box box) {
        ArrayList<Box> neighour = new ArrayList<Box>();

        if (box.getX() > 0) 
            neighour.addFirst(null);

        return neighour;
    }
}
