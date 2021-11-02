package UdpEcho;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.25
 */
public class UdpEchoSever {

    private final DatagramSocket socket;

    public UdpEchoSever(int port) throws SocketException {
//        port 是端口号
//        这里用 int 表示
//        实际上是两个字节的无符号整数
//        范围 0 - 65535
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true){
            //////////////////
            //  读取请求
            //  当前服务器不知道客户端什么时候会发来请求  receive 方法也会阻塞
            //  requestPacket 是输入类参数  socket 中读到的数据会设置到这个参数中
            //  DatagramPacket 在构造时 需要设置一个缓冲区（就是一段字节空间，通常使用byte[]）
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);
            //////////////////
            //  读取 requestPacket 中的数据
            String request = new String(requestPacket.getData(),0, requestPacket.getLength());
            //////////////////
            //  根据请求计算响应
            String response = process(request);
            /////////////////
            //  回复客户端
            DatagramPacket responsePacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //////////////////
            //  打印日志
            String log = String.format("[%s:%d] req: %s; resp: %s",
                    responsePacket.getAddress().toString(),
                    requestPacket.getPort(),
                    request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoSever sever = new UdpEchoSever(9090);
        sever.start();
    }
}