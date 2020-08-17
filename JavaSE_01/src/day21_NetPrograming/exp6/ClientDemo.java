package day21_NetPrograming.exp6;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 15555);
        BufferedReader br = new BufferedReader(new FileReader("exp5Input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        socket.shutdownOutput();

        BufferedReader report = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String text = report.readLine();
        System.out.println("接受服务器反馈:" + text);

        br.close();
        bw.close();
        socket.close();
    }
}
