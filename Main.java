import Resuourse.HillClimbing.HillClimbing;
import Resuourse.Map.Map;
import Resuourse.Map.Position;

public class Main {

  public static void main(String[] arg) {
    System.out.println("Projecto de ED");

    Map map = new Map(5,5,5);
    Position robot = map.generatePosRobot();
    map.showInTerminal();
    System.out.println("");
    HCC modul = new HCC();
    modul.setMap(5, 5, 5);
    modul.setRobot(new Position(3, 4));
    boolean search = hillClimbing.searchBestWay(robot);
    System.out.println(search);
    hillClimbing.showMapInTerminal();
  }
}
