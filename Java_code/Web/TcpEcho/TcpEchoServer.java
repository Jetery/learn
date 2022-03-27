package TcpEcho;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.10.28
 */

public class TcpEchoServer {
    //  TCP 使用 ServerSocket
    private final ServerSocket listenSocket;

    public TcpEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
            //  TCP 是可靠传输, 有连接, 故第一步为建立连接
            //  但是当服务器运行时, 是否有客户端建立连接, 不可以确定
            //  当客户端没有建立连接, accept 方法会阻塞
            //  当建立连接时, accept 返回一个 Socket 对象
            //  进一步的交互, 交给 clientSocket
            Socket clientSocket = listenSocket.accept();
            //  处理客户端和服务器的多次交互
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        //  打印建立连接日志
        String log = String.format("[%s:%d]客户端上线",
                clientSocket.getInetAddress().toString(), clientSocket.getPort());
        System.out.println(log);
        //  处理输入输出数据
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            while(true){
                Scanner sc = new Scanner(inputStream);
                //  客户端退出情况
                if (!sc.hasNext()){
                    //  显式退出
                    log = String.format("[%s:%d]客户端下线!",
                            clientSocket.getInetAddress().toString(), clientSocket.getPort());
                    System.out.println(log);
                    break;
                }
                //  接受客户端请求
                String request = sc.nextLine();
                //  构造响应
                String response = process(request);
                //  发送给客户端
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(response);
                //  刷新缓冲区内存, 使数据手动发送
                writer.flush();
                //  打印 发送和请求 日志
                log = String.format("[%s:%d] req:%s; resp:%s",
                        clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),
                        request, response);
                System.out.println(log);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //  clientSocket 的生命周期 和 连接 相关, 而不是整个程序
            //  为了防止资源泄漏, 我们需要手动进行关闭
            clientSocket.close();
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
