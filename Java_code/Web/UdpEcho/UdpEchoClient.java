package UdpEcho;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.25
 */
public class UdpEchoClient {

    DatagramSocket socket;
    private final String serverIp;
    private final int serverPort;

    public UdpEchoClient(String severIp, int severPort) throws SocketException {
        this.serverIp = severIp;
        this.serverPort = severPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("->");
            // get the client's request
            String request = sc.nextLine();
            //  the case to EXIT the client
            if (request.equals("exit")) {
                System.out.println("程序退出!");
                return;
            }
            // the case to call the sever
            // first we create the requestPacket ::
            //       (get byte not String, get the byte[] length, the serverIp to send, the severPort to send)
            // 构造 requestPacket 时, 我们要注入数据, 要明确明确数据报的发送IP和端口
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                  InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
            //  服务器会回应客户端，这里构造 responsePacket 来接受
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024); // 同样是设置一个缓冲区
            //  接受服务器数据报
            socket.receive(responsePacket);
            //  读取响应中的数据
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            //  打印日志
            String log = String.format("req: %s ; resp: %s", request, response);
            System.out.println(log);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }

}


