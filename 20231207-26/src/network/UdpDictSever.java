package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -12 -08
 * Time: 17:51
 */
//对于DictServer来说， 和EchoServer相比， 大部分东西都是一样的
    //主要就是“根据请求计算响应”这个步骤不太一样。
public class UdpDictSever extends UdpEchoServer{
    private Map<String, String> dict = new HashMap<>();

    public UdpDictSever(int port) throws SocketException {
        super(port);

        //给这个dict设置一下内容
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("handsome", "帅气的");
    }

    @Override
    public String process(String request) {
        //查词典的过程
        return dict.getOrDefault(request, "没有收录此单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDictSever udpDictSever = new UdpDictSever(9090);
        udpDictSever.start();
    }
}
