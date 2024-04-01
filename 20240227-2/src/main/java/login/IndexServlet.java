package login;

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
 * Date: 2024 -03 -01
 * Time: 15:36
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    //通过重定向，浏览器发起的是get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先判定用户的登录状态
        //如果用户还没登陆，要求先登录
        //如果已经登录，则根据回会话中的用户名，来显示到页面上
        //这个操作不会触发会话的创建
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            //用户是未登录状态
            System.out.println("用户未登录");
            resp.sendRedirect("login.html");
            return;
        }
        //已经登录
        String username = (String)httpSession.getAttribute("username");
        //构造页面
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("欢迎" + username + "回来！");
    }
}
