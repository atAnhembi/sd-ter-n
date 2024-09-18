import java.net.Socket;
import java.util.HashMap;

public class Attendant extends Thread {
    private Communication communication;

    public Attendant(Socket client) {
        communication = new Communication(client);
    }

    @Override
    public void run() {
        Tranlation request = (Tranlation) communication.receive();

        String response = translate(request.getWord());

        if(response != null) {
            communication.send(new Tranlation(response, Status.SUCCESS));
        } else {
            communication.send(new Tranlation(response, Status.NOT_FOUND));
        }
    }

    private String translate(String word) {
        HashMap<String, String> dictionayIngPort = new HashMap<>();

        dictionayIngPort.put("red", "vermelho");
        dictionayIngPort.put("blue", "azul");
        dictionayIngPort.put("white", "branco");
        dictionayIngPort.put("black", "preto");

        return dictionayIngPort.get(word);
    }
}
