
import area.Area;
import robos.Robo;
import robos.RoboSimples;

public class App {
    public static void main(String[] args) {
        Area area = new Area(100, 100);
        Robo robo = new RoboSimples(10, 10, area);

        System.out.println(robo.getPosX() + "," + robo.getPosY());
        if (robo.moverNorte(5)) {
            System.out.println("Andou");
        } else {
            System.out.println("Não andou");
        }
        System.out.println(robo.getPosX() + "," + robo.getPosY());
    }

}