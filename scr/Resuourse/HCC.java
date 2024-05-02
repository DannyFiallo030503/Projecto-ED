package scr.Resuourse;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import scr.Resuourse.HillClimbing.HillClimbing;
import scr.Resuourse.Map.Map;
import scr.Resuourse.Map.Position;

public class HCC {

    HillClimbing hillClim = new HillClimbing();
    File fileDirectory;

    public void HCC() {

    }

    public void setMap(int h, int w, int obst) {
        Map map =  new Map(w, h, obst);
        hillClim.setMap(map);
    }


    public void setRobot(Position Robot) {
        hillClim.eliminateRobot();

        hillClim.setRobot(Robot);
    }
    public boolean saveMap(String name) {
        boolean save = true;
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(name))) {
            fileDirectory = new File(name);
            // se guardan los datos
            hillClim.saveMap(fileDirectory);
        } catch(IOException e) {
            save = false;
        }

        return save;
    }

    public boolean searchBestWay() {
        Position robot = hillClim.searchRobot();
        boolean search = false;
        if (robot != null) {
            search = hillClim.searchBestWay(robot);
        }
        return search;
    }

    public void showMapInTerminal() {
        hillClim.showMapInTerminal();
    }
}
