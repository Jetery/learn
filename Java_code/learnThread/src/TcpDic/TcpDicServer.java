package TcpDic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.04
 */
public class TcpDicServer {

    final private ServerSocket listenSocket;
    private HashMap<String, String> map;

    public TcpDicServer(int port) throws IOException {
        this.listenSocket = new ServerSocket(port);
        map = new HashMap<>();
        map.put("cat", "猫");
        map.put("猫", "cat");
        map.put("dog", "狗");
        map.put("狗", "dog");
        map.put("hello", "你好");
        map.put("你好", "hello");
    }

    public void start() throws IOException {
        //  显式 启动
        System.out.println("服务器启动!");
        while (true){
            Socket clientSocket = listenSocket.accept();
            connection(clientSocket);
        }
    }

    private void connection(Socket clientSocket) throws IOException {
        String log = String.format("[%s:%d]客户端上线",
                clientSocket.getInetAddress().toString(), clientSocket.getPort());
        System.out.println(log);
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                //  客户端下线
                if (!scanner.hasNext()){
                    log = String.format("[%s:%d]客户端下线", clientSocket.getInetAddress().toString(),
                            clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                //  读取请求
                String request = scanner.next();
                //  构造响应并发送
                String response = process(request);
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();
                //  打印日志
                log = String.format("[%s:%d] req: %s; resp: %s", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
                System.out.println(log);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            //  防止内存泄漏
            clientSocket.close();
        }
    }

    private String process(String request) {
        return map.getOrDefault(request, "[该词未加入词典]");
    }

    public static void main(String[] args) throws IOException {
        TcpDicServer server = new TcpDicServer(9090);
        server.start();
    }
}
