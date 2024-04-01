import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -03 -01
 * Time: 12:10
 */
//通过这个类，把数据库连接过程封装一下
    //此处把DBUtil作为一个工具类，提供static方法供其他代码调用
public class DBUtil {
    //静态成员是跟随类对象的，类对象在整个进程中只有唯一一份
    //静态成员相当于也是唯一的实例。（单例模式，饿汉模式）
    private static DataSource dataSource = new MysqlDataSource();

    static {
        //使用静态代码块，针对dataSource进行初始化操作
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test2?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");
    }

    //通过这个方法来建立连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //通过这个方法断开连接，释放资源
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        //此处的三个try catch分开写更好，避免前面的异常导致后面的代码不能执行。
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
