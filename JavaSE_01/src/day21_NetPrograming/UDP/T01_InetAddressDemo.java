package day21_NetPrograming.UDP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class T01_InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
//        InetAddress address = InetAddress.getByName("Windows");
        InetAddress address = InetAddress.getByName("192.168.68.2");
        String hostName = address.getHostName();
        String hostAddress = address.getHostAddress();
        System.out.println(hostName + " " + hostAddress);
    }
}
