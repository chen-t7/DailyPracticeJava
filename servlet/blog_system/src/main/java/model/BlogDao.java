package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -03 -03
 * Time: 15:23
 */
//通过这个类，封装针对 博客表 的基本操作
    //此处暂时不涉及到修改博客~~（修改也可以通过 删除/新增）
public class BlogDao {
    //1. 新增一个博客
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    public void add(Blog blog) {
        try {
            //1.和数据库建立连接
            Connection connection = DBUtil.getConnection();
            //2.构建sql
            String sql = "insert into blog values(null,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getContent());
            preparedStatement.setTimestamp(3, blog.getUpdateTimestamp());
            preparedStatement.setInt(4, blog.getUserId());
            //3.执行sql
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //4.释放资源
            DBUtil.close(connection, preparedStatement, null);
        }

    }

    //2.根据博客id来查询指定博客（博客详情页中）
    public Blog selectById(int blogId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from blog where blogId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, blogId);
            resultSet = preparedStatement.executeQuery();
            //由于blogId在blog表中是唯一的（主键）
            // 此时的查询结果，要么是没有查到任何数据，要么是只有一条记录
            //此处不需要使用while，直接if判定
//            while (resultSet.next()) {
//
//            }
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("Content"));
                blog.setUpdateTime(resultSet.getTimestamp("updateTime"));
                blog.setUserId(resultSet.getInt("userId"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    //3.直接查询数据库中所有的博客列表（用于博客列表页）
    public List<Blog> selectAll() {
        List<Blog> blogList = new ArrayList<Blog>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.和服务器建立连接
            connection = DBUtil.getConnection();
            //2.构造sql语句
            String sql = "select * from blog order by updateTime desc";
            //3.执行sql
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                //需要注意，这里的正文，是在博客列表页中，不需要把整个正文内容都显示出来
                String content = resultSet.getString("Content");
                if (content.length() >= 100) {
                    content = content.substring(0, 100) + "...";
                }
                blog.setContent(content);
                blog.setUpdateTime(resultSet.getTimestamp("updateTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogList.add(blog);
            }
            return blogList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //5.释放资源
            DBUtil.close(connection, preparedStatement, resultSet);
        }
        return null;
    }

    //4.删除指定博客
    public void delete(int blogId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from blog wher blogId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, blogId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
    }
}
