package TcpThread;

import TcpEcho.TcpEchoClient;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.11.05
 */
public class TcpThreadEchoClient extends TcpEchoClient {

    public TcpThreadEchoClient(String serverIp, int serverPort) throws IOException {
        super(serverIp, serverPort);
    }

}
