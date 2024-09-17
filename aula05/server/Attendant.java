import java.net.Socket;

public class Attendant extends Thread {
    private Communication communication;

    public Attendant(Socket client) {
        communication = new Communication(client);
    }

    @Override
    public void run() {
        
    }
}
