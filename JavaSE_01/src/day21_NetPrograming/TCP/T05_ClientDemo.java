package day21_NetPrograming.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class T05_ClientDemo {
    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10000);
        Socket socket = new Socket("127.0.0.1", 11111);
        OutputStream os = socket.getOutputStream();
        os.write("hello TCP".getBytes());
        socket.close();
    }
}
