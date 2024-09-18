import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final int PORT = 4567;
        final String serverName = "localhost";
        Socket socket = null;
        Communication communication = null;
        Tranlation request, response;

        try {
            socket = new Socket(serverName, PORT);
            communication = new Communication(socket);

            request = new Tranlation("blue", Language.ING_PORT);
            communication.send(request);

            response = (Tranlation) communication.receive();

            if (response.getStatus() == Status.SUCCESS) {
                System.out.println("Tradução: " + response.getWord());
            } else {
                System.out.println("Não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
