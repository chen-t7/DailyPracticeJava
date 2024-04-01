package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -03 -04
 * Time: 0:05
 */
@WebServlet("/login")
public class loginServlet  extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码，告诉servlet按照啥样的格式来理解请求
        req.setCharacterEncoding("utf8");
        //设置相应的编码，告诉servlet按照啥样的格式来构造响应
        //resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html;charset=utf8");
        //1.读取参数中的用户名和密码
        // 注意！如果密码和用户名包含中文，此处可能会乱码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
            //登录失败！！
            String html = "<h3>登录失败！缺少username或者password字段<h3>";
            resp.getWriter().write(html);
            return ;
        }
        //2.读取数据库，看下用户名是否存在，并且密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectByUsername(username);
        if (user == null) {
            //用户不存在
            String html = "<h3>登录失败！用户名或密码错误<h3>";
            resp.getWriter().write(html);
            return ;
        }
        if (!password.equals(user.getPassword())) {
            //密码不对
            String html = "<h3>登录失败！用户名或密码错误<h3>";
            resp.getWriter().write(html);
            return ;
        }
        // 3.用户名密码验证通过，登录成功，接下来创建会话，使用会话保存用户信息
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);
        //4.进行重定向，跳转到博客列表也
        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        //使用这个方法来获取到用户的登录状态

        //如果用户未登录，这里的会话就拿不到！！
        HttpSession session = req.getSession(false);
        if (session == null) {
            //未登录，返回一个空的user对象
            User user = new User();
            String respJson = objectMapper.writeValueAsString(user);
            resp.getWriter().write(respJson);
            return;
        }
        User user =(User)session.getAttribute("user");
        if (user == null) {
            user = new User();
            String respJson = objectMapper.writeValueAsString(user);
            resp.getWriter().write(respJson);
            return;
        }
        //确实成功取出了User对象
        String respJson = objectMapper.writeValueAsString(user);
        resp.getWriter().write(respJson);
    }
}
