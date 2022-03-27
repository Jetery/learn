package TcpThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.06
 */
public class TcpThreadPoolEchoServer {

    private ServerSocket listenSocket;

    public TcpThreadPoolEchoServer(int serverPort) throws IOException {
        listenSocket = new ServerSocket(serverPort);
    }

    public void start() throws IOException {
        System.out.println("服务器上线");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true){
            Socket clientSocket = listenSocket.accept();
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        String log = String.format("[%s:%d]客户端上线", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        System.out.println(log);

        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            Scanner scanner = new Scanner(inputStream);
            while (true) {
                if (!scanner.hasNext()){
                    log = String.format("[%s:%d]客户端下线", clientSocket.getInetAddress().toString(),
                            clientSocket.getPort());
                    System.out.println(log);
                    break;
                }

                String request = scanner.next();
                String response = process(request);

                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();

                log = String.format("[%s:%d] req: %s ; resp : %s", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),
                        request, response);
                System.out.println(log);
            }


        } catch (IOException e){
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer server = new TcpThreadEchoServer(9090);
        server.start();
    }
}
