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
    HillClimbing hillClimbing = new HillClimbing(map);
    boolean search = hillClimbing.searchBestWay(robot);
    System.out.println(search);
    hillClimbing.showMapInTerminal();
  }
}
