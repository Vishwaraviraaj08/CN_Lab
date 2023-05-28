import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket s=new ServerSocket(4000);
        Socket soc=s.accept();
        DataOutputStream out=new DataOutputStream(soc.getOutputStream());
        out.writeBytes( new Date().toString() + "\n");
        out.close();
        soc.close();
    }
}
 