package day21_NetPrograming.UDP;

import java.io.IOException;
import java.net.*;

public class T02_SendDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        byte[] data = "Hello World".getBytes();
        int length = data.length;
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 12345;
//        DatagramPacket dp = new DatagramPacket(data, length, address, port);
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 10086);

        socket.send(dp);

        socket.close();
    }
}
