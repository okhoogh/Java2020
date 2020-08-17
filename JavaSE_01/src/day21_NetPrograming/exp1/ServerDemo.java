package day21_NetPrograming.exp1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12321);
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();

        byte[] data = new byte[1024];
        int len = is.read(data);
        System.out.println("数据是：" + new String(data, 0, len));

        OutputStream os = accept.getOutputStream();
        os.write("服务器收到消息".getBytes());

        serverSocket.close();
    }
}
