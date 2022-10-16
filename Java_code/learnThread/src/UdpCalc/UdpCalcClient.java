package UdpCalc;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.09
 */
public class UdpCalcClient {

    private DatagramSocket socket;
    private String serverIp;
    private int serverPort;

    public UdpCalcClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        System.out.println("客户端上线");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("->");
            String request = sc.nextLine();
            if (request.equals("exit")){
                System.out.println("程序退出!");
                break;
            }

            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);

            DatagramPacket respPacket = new DatagramPacket(new byte[1024] , 1024);
            socket.receive(respPacket);

            String response = new String(respPacket.getData(), 0, respPacket.getLength());

            String log = String.format("req:%s; resp:%s", request, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpCalcClient client = new UdpCalcClient("127.0.0.1", 9090);
        client.start();;
    }

}
