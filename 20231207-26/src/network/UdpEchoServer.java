package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -12 -07
 * Time: 17:14
 */
//UDP版本的回显服务器
//请求是啥，就返回啥。（这个代码没有实际的业务，这个代码也没啥太大作用和意义，只是使用了socket api的基本用法）
public class UdpEchoServer {
    //网络编程，本质上是要操作网卡
    //但是网卡不方便直接操作，在操作系统内核中，使用了一种特殊的叫做“socket"这样的文件来抽象表示网卡
    //因此进行网络通信，势必要先有一个socket对象
    private DatagramSocket socket = null;

    //对于服务器来说，创建socket对象的同时，要让他绑定上一个具体的端口号。
    //服务器一定要关联上一个具体的端口
    //服务器是网络传输中，被动的一方，如果是操作系统随机分配的端口，此时客户端就不知道这个端口是啥了，也就无法通信了。
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动！");
        //服务器不是只给一个客户端提供服务就完了，需要服务很多客户端
        while (true) {
            //只要有客户端过来，就可以提供服务
            //1.读取客户端发来的请求是啥
            //receive方法参数是一个输出型参数，需要先构造好一个空白的DatagramPacket对象，交给receive来进行填充
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            //receive内部会针对 参数 对象填充数据，填充的数据来自于网卡。
            socket.receive(requestPacket);
            //此时这个DatagramPacket 是一个特殊的对象，并不方便进行处理，可以把这里包含的数据拿出来，构造成一个字符串。
            //字节数组作为存储数据的缓冲区。此处给的最大长度是4096，但是这里的空间不一定满了，可能只使用了一小部分
            //因此构造字符串，哪些用了就构造哪部分，就通过getLength获取到实际的数据报的长度，只把实际的有效部分给构造成字符串即可
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2.根据请求计算响应，此处有浴室回显服务器，响应和请求相同
            String response = process(request);
            //3.把响应写回到客户端，send的参数也是DatagramPacket，需要把这个Packet对象构造好。
            //  此处构造的响应对象不能使用空的字节数组构造，而是要用相应数据来构造。
            //  response.getBytes()是把string底层包含的字节数组给获取到
            //  构造长度response.length()不能写成这个写法，一个是字节数的个数，一个是字符串的长度。这两个操作的计量单位不同。
            //  requestPacket.getSocketAddress()这个操作是获取到客户端的ip和端口号（这两个信息本身就在requestPacket中
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);
        }
    }

    //这个方法表示“根据请求计算响应”
    private String process(String request) {
        return request;
    }
}
