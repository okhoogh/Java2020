package day21_NetPrograming.exp1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12321);
        OutputStream os = socket.getOutputStream();
        os.write("I'am come on".getBytes());

        InputStream is = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = is.read(data);
        System.out.println("反馈是：" + new String(data, 0, len));

        // 不需要，因为Socket释放后，这两个也跟着释放
//        is.close();
//        os.close();
        socket.close();
    }
}
