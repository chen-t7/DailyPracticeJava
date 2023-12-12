package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -12 -09
 * Time: 15:13
 */
public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        //socket 构造方法，能够识别点分十进制格式的IP地址
        //new这个对象的同时，就会进行TCP连接操作
        socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        System.out.println("客户端启动 ");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            while (true) {
                //1.先从键盘上读取用户输入的内容
                System.out.printf("> ");
                String request = scanner.next();
                if (request.equals("exit")) {
                    System.out.println("goodbye");
                    break;
                }
                //2.把读到的内容构造成请求，发送给服务器
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                //此处加上flush 保证数据确实发送出去了
                printWriter.flush();
                //3.读取服务器的响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                //4.把响应的内容显示到界面上
                System.out.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
