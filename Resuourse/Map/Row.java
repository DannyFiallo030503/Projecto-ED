package Resuourse.Map;

import java.util.ArrayList;

public class Row {
    
    private ArrayList<Box> row;


    public void addEmptyLast() {

    }


    public Box getPos(int x) {
        return row.get(x);
    }

}
