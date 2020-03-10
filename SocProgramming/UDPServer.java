import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: ying
 * Date: 3/10/20
 * Time: 15:50
 * Description: No Description
 */
public class UDPServer {
    public static void main(String[] args) throws Exception{

        DatagramSocket ds = new DatagramSocket(9999);

        byte[] b1 = new byte[1024];

        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println("str " + str);
        int num = Integer.parseInt(str.trim());
        System.out.println("num " + num);
        int result = num * num;

        byte[] b2 = String.valueOf(result).getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
        ds.send(dp1);

    }
}

