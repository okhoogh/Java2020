package day21_NetPrograming.UDP.T04_CommunicationProgram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(12345);

        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            System.out.println("数据为：" + new String(dp.getData(), 0, dp.getLength()));
        }
    }
}
