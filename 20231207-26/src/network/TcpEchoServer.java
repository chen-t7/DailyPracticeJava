package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -12 -08
 * Time: 18:53
 */
public class TcpEchoServer {
    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("启动服务器");
        //此处使用 CachedThreadPool, 使用 FixedThreadPool不太合适（线程数不太应该是有固定的.....)
        ExecutorService threadPool = Executors.newCachedThreadPool();
        while (true) {
            //使用这个clientSocket来和具体的客户端进行交流
            Socket clientSocket = serverSocket.accept();
            //此处使用多线程来处理
//            //如果客户端特别多，很多客户端频繁的来建立连接，就需要频繁创建/销毁线程了；
//            Thread thread = new Thread(() -> {
//                processConnection(clientSocket);
//            });
//            thread.start();
            // 进一步优化：使用线程池
            threadPool.submit(() -> {
                processConnection(clientSocket);
            });
        }
    }
    //使用这个方法来处理一个连接
    //这一个连接对应一个客户端，但是这里可能会涉及到多次交互
    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线！\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        //基于上述socket对象和客户端进行通信
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            //由于要处理多个请求和响应，也是使用循环来进行
            while (true) {
                //1.读取请求
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    //没有下个数据，说明读完了，（客户端关闭了连接）
                    System.out.printf("[%s:%d] 客户端下线\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
                    break;
                }
                //此处使用next读取，一直读取到换行符/空格/其他空白符结束，但是最终返回结果不包含上述空白符
                String request = scanner.next();
                //2.根据请求计算响应
                String response = process(request);
                //3.返回响应结果
                //  OutputStream没有write String 这样的功能，可以把String 里的字节数组拿出来，进行写入；
                //  也可以用字符流转换一下
                PrintWriter printWriter = new PrintWriter(outputStream);
                //此处使用println来写入，让结果中带有一个 \n 换行，方便对端来接收解析
                printWriter.println(response);
                //flush 用来刷新缓冲区，保证当前写入的数据，确实是发送出去了
                printWriter.flush();

                System.out.printf("[%s:%d req:%s; res:%s \n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }
            //clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //更合适的做法，把close放到finally里面，保证一定能够执行到。
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
