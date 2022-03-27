package UdpCalc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.09
 */
public class UdpCalcServer {
    private DatagramSocket socket;

    public UdpCalcServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true){
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);

            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String response = process(request);

            DatagramPacket respPacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());  // 相应返回的网络地址不能忘记
            socket.send(respPacket);

            String log = String.format("[%s:%d] req:%s; resp:%s", respPacket.getAddress().toString(),
                    requestPacket.getPort(),
                    request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        String[] orders = request.split(";");
        if (orders.length != 3){
            return "error!";
        }
        int x = Integer.parseInt(orders[0]);
        int y = Integer.parseInt(orders[1]);
        String o = orders[2];
        int ans;
        switch (o) {
            case "+":
                ans = x + y;
                break;
            case "-":
                ans = x - y;
                break;
            case "*":
                ans = x * y;
                break;
            case "/":
                ans = x / y;
                break;
            default:
                return "error!";
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) throws IOException {
        UdpCalcServer server = new UdpCalcServer(9090);
        server.start();
    }
}




