import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -02 -25
 * Time: 23:22
 */
public class demo1 {
//    通过这个代码，往数据库的表中，插入一条记录
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        int id = scanner.nextInt();
        System.out.println("请输入姓名：");
        String name = scanner.next();

        //1. 先创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test2?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1234");

//        2.和数据库服务器建立连接，连接好了之后，才能进行后续的 请求-响应 交互。
        Connection connection = dataSource.getConnection();

//        3.构造sql (代码中的 sql 不需要写;)
        //String sql = "insert into student values(1,'张三')";
        //String sql = "delete from student where id = 1";
        //String sql = "update student set id = 3 where id = 1";
        //String sql = "insert into student values(" + id + ",'" + name + "')";
        //此处使用？作为占位符
        String sql = "insert into student values(?,?)";
        //构造一个sql对象，Prepared准备好的/预处理的：先解析检查sql，看看sql是不是有啥问题，解析完毕之后，也会得到结构化数据
        //直接把解析好的结构化数据发给数据库服务器，服务器就剩下了这部分解析的工作
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);//这里的数字1表示要替换第几个问号，从1开始算起
        statement.setString(2, name);
        System.out.println("sql = " + statement );

//        4.把sql发送给服务器，返回值是一个整数，表示影响到的行数
        int n =  statement.executeUpdate();
        System.out.println("n = " + n);

//        5.执行完毕之后，最后一个步骤，关闭连接，释放资源
        statement.close();
        connection.close();
    }
}
