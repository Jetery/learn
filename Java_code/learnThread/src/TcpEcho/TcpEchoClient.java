package TcpEcho;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.28
 */
public class TcpEchoClient {

    private final String serverIp;
    private final int serverPort;
    private Socket socket;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        //  消除了
        //   Socket clientSocket = listenSocket.accept();
        //  的阻塞
        this.socket = new Socket(serverIp, serverPort);
    }

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            while (true){
                System.out.print("->");
                //  读取请求
                String request = sc.next();
                if (request.equals("exit")){
                    break;
                }
                //  构造请求并发送
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(request);
                writer.flush();
                //  读取响应
                Scanner repScanner = new Scanner(inputStream);
                String response = repScanner.next();
                //  打印日志
                String log = String.format("req: %s; resp: %s;", request, response);
                System.out.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }

}
