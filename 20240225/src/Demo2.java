import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -02 -27
 * Time: 11:51
 */
public class Demo2 {
    public static void main(String[] args) throws SQLException {
//        1.创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test2?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1234");

//        2.建立连接
        Connection connection = dataSource.getConnection();

//        3.构造sql
        String sql = "select * from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,3);
//        4.执行sql （和之前不同了）
        //ResultSet 就表示查询的结果集合（临时表），此处就需要针对表进行遍历
         ResultSet resultSet = statement.executeQuery();

//         5.遍历结果集合
        //通过next方法就可以获取到临时表中的每一行数据，如果获取到最后一行之后，再执行next，就会返回false，循环结束
        while (resultSet.next()) {
            //针对这一行进行处理
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id:" + id + ", name:" + name);
        }

//        6.关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
