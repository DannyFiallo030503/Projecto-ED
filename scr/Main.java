package scr;

import scr.Resuourse.HCC;
import scr.Resuourse.HillClimbing.HillClimbing;
import scr.Resuourse.Map.Map;
import scr.Resuourse.Map.Position;

public class Main {

  public static void main(String[] arg) {
    System.out.println("Projecto de ED");
    HCC modul = new HCC();
    modul.setMap(5, 5, 5);
    modul.setRobot(new Position(3, 4));
    boolean search = modul.searchBestWay(robot);
    System.out.println(search);
    modul.showMapInTerminal();
  }
}
