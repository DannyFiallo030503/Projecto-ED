package Resuourse.Map;

import java.util.LinkedList;

public class Row {
    
    public LinkedList<Box> row;


    public void addEmptyLast(int x, int y) {
        row.addLast(new Path(x, y));
    }

}
