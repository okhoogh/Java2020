package day21_NetPrograming.exp6;

import java.io.*;
import java.net.Socket;

public class SocketThread implements Runnable {
    private Socket s;

    public SocketThread(Socket accept) {
        this.s = accept;
    }

    @Override
    public void run() {
        //接受数据写到文本文件
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            BufferedWriter bw = new BufferedWriter(new FileWriter("exp6Output.txt"));

            int count = 0;
            File file = new File("exp6Output" + count);
            while (file.exists()) {
                ++count;
                file = new File("exp6Output" + count);
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            BufferedWriter report = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            report.write("服务器收到数据！！！");
            report.newLine();
            report.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
