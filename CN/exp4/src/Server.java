

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server listening on port 1234...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("receivedText.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();

            System.out.println("Data transferred successfully.");

    }
}
