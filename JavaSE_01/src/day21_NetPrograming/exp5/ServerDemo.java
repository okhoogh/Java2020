package day21_NetPrograming.exp5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(14444);
        Socket accept = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("exp5Output.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        BufferedWriter report = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        report.write("服务器收到消息");
        report.newLine();
        report.close();

        br.close();
        bw.close();
        serverSocket.close();
    }
}
