
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader reader = new BufferedReader(new FileReader("sampleText.txt"));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            writer.close();
            reader.close();
            socket.close();

            System.out.println("Data sent successfully.");
    }
}

