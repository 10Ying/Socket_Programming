import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class SocClient {
    public static void main(String[] args) throws Exception {

        String ip = "localhost";
        int port = 9999;// 0-1023 to 65535
        Socket s = new Socket(ip, port);

        String str = "Hello World.";

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream()); // packages
        PrintWriter out = new PrintWriter(os);
        out.println(str);
        os.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String s1 = br.readLine();

        System.out.println("C: Data from Server: " + s1);

    }
}

