import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int serverPort = 8100;

        try (
                Socket socket = new Socket(serverAddress, serverPort);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)
        ) {
            String inputLine;
            System.out.println("Enter command (type 'exit' to quit):");

            while (true) {
                System.out.print("> ");
                inputLine = scanner.nextLine();

                if (Objects.equals(inputLine, "exit")) {
                    break;
                }

                out.println(inputLine);
                String response = in.readLine();
                System.out.println("Server: " + response);
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
