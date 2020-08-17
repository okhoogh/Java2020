package day21_NetPrograming.exp6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(15555);

        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(new SocketThread(accept)).start();
        }
    }
}
