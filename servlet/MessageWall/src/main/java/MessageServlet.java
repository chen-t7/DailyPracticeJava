import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -02 -29
 * Time: 18:34
 */
class Message {
    public String from;
    public String to;
    public String message;
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

    //使用这个List变量保存所有信息。
    ///private List<Message> messageList = new ArrayList<Message>();
    private ObjectMapper objectMapper = new ObjectMapper();
    //向服务器提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //把body中的内容读出来了，解析成了个Message对象
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        //此处通过一个简单粗暴的方式来完成保存
        //messageList.add(message);
        save(message);
        //此处的设定状态码可以省略，不设置默认也是200.
        resp.setStatus(200);
    }

    //从服务器获取数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //显示告诉浏览器，数据是json格式的，字符集是utf8的
        resp.setContentType("application/json;charset=utf8");
        //objectMapper.writeValue(resp.getWriter(), messageList);

        List<Message> messageList = load();
        String jsonResp = objectMapper.writeValueAsString(messageList);
        System.out.println("jsonResp: " + jsonResp);
        resp.getWriter().write(jsonResp);
    }

    //提供一对方法
    //往数据库中存一条消息
    private void save(Message message) {
        //jdbc操作
        Connection connection = null;
        PreparedStatement statement = null;
        //1.建立连接
        try {
            connection = DBUtil.getConnection();
            //2.构造SQL语句
            String sql = "insert into message values(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, message.from);
            statement.setString(2, message.to);
            statement.setString(3, message.message);
            //3.执行sql
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //4.关闭连接
            DBUtil.close(connection, statement, null);
        }
    }

    //从数据库取所有消息
    private List<Message> load() {
        List<Message> messageList = new ArrayList<Message>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1.和数据库建立连接
            connection = DBUtil.getConnection();
            //2.构造sql
            String sql = "select * from message";
            statement = connection.prepareStatement(sql);
            //3.执行sql
            resultSet = statement.executeQuery();
            //遍历结果集合
            while (resultSet.next()) {
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");
                messageList.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源，断开连接
            DBUtil.close(connection, statement, resultSet);
        }
        return messageList;
    }
}
