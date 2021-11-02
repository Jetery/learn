package UdpDic;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.28
 */
public class UpdDicClient {
    private final String serverIp;
    private final int serverPort;
    DatagramSocket socket;

    public UpdDicClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("->");
            String request = sc.nextLine();
            if (request.equals("exit")){
                System.out.println("goodbye");
                return;
            }
            //  构造数据报并发送
            DatagramPacket requestPacket = new DatagramPacket(
                    request.getBytes(),
                    request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            //  构造数据报并接受响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            //  读取响应
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            //  打印日志
            String log = String.format("req: %s; res: %s", request, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UpdDicClient client = new UpdDicClient("127.0.0.1", 9090);
        client.start();
    }
}
