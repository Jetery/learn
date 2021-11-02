package UdpDic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.28
 */
public class UdpDicServer {
    DatagramSocket socket;
    HashMap<String, String> map;

    public UdpDicServer(int port) throws SocketException {
        this.map = new HashMap<>();
        //  添加词汇
        map.put("hello", "你好");
        map.put("你好", "hello");
        map.put("dog", "小狗");
        map.put("小狗","dog");
        map.put("cat","小猫");
        map.put("小猫", "cat");
        this.socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
     //  创建接受数据报并接受
            DatagramPacket requestPacket =  new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);
            //  读取请求构造响应
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String response = process(request);
            //  构造响应数据报并发送
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //  打印日志
            String log = String.format("[%s:%d] req: %s; resp: %s",
                    responsePacket.getAddress().toString(),
                    requestPacket.getPort(),
                    request, response);
            System.out.println(log);
        }
    }

    private String process(String request) {
        if (map.containsKey(request)) return map.get(request);
        return "词典中未添加该词";
    }

    public static void main(String[] args) throws IOException {
        UdpDicServer server = new UdpDicServer(9090);
        server.start();
    }
}
