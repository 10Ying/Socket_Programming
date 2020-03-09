import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
    public static void main(String[] args) throws Exception {

        System.out.println("S: Server is started");
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("S: Server is waiting for client request");
        Socket s = ss.accept();

        System.out.println("S: Client Connected");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = br.readLine();

        System.out.println("S: Client Data: " + str);

        String s1 = str.substring(0, 5);

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream()); // packages
        PrintWriter out = new PrintWriter(os);
        out.println(s1);
        os.flush();

        System.out.println("S: Data sent from Server to Client");
    }
}

