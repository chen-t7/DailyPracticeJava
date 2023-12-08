package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -12 -07
 * Time: 17:13
 */
//UDP 版本的 回显客户端
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP = null;
    private int serverPort = 0;

    //一次通信，需要两个ip，两个端口
    //客户端的ip是127.0.0.1已知
    //客户端的port是系统自动分配的
    //服务器ip 和 端口 也需要告诉客户端，才能顺利把消息发给服务器
    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        //并不需要显示的绑定一个端口号（让操作系统自动分配一个端口号
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    //客户端启动
    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //1.控制台读取一个要发送的数据
            System.out.print("> ");
            String request = scanner.next();
            if (request.equals("exit")) {
                System.out.println("goodbye");
                break;
            }

            //2.构造成UDP请求，并发送
            //  构造这个Packet的时候，要把serverIP和serverPort逗传入过来，但是此处的IP地址需要填写的是一个32位的整数，
            //  上述的IP地址是一个字符串，需要使用InetAddress.getByName来进行一个转换
            DatagramPacket requestPocket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPocket);

            //3.读取服务器的UDP响应，并解析
            DatagramPacket responsePocket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePocket);
            String response = new String(responsePocket.getData(), 0, responsePocket.getLength());

            //4.把解析好的结果展示出来
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
        udpEchoClient.start();
    }
}
