package day21_NetPrograming.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class T03_ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        byte[] data = packet.getData();
        int len = packet.getLength();
        String s = new String(data, 0, len);
        System.out.println("Ъ§ОнЪЧ" + s);

        socket.close();
    }
}
