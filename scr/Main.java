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
    boolean search = modul.searchBestWay();
    System.out.println(search);
    boolean isSave = modul.saveMap("hola");
    System.out.println(isSave);
    modul.showMapInTerminal();
  }
}
