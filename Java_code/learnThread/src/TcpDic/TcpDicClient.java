package TcpDic;

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
 * Date: 2021.11.04
 */
public class TcpDicClient {

    private final String serverIp;
    private final int serverPort;
    private final Socket socket;

    public TcpDicClient(String serverIp, int serverPort) throws IOException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.socket = new Socket(serverIp, serverPort);
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            while (true){
                System.out.print("->");
                String request = scanner.next();
                //  退出情况
                if (request.equals("exit")){
                    break;
                }
                //  发送请求
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();
                //  接收响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                //   打印结果
                String log = String.format("req: %s ; resp: %s", request, response);
                System.out.println(log);

            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpDicClient client = new TcpDicClient("127.0.0.1", 9090);
        client.start();
    }

}
