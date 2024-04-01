package login;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //验证用户名密码是否正确
        //正常情况下，用户名密码是用数据库保存
        //此处直接写死
        //此处约定，用户名合法的是zhangsan 和 lisi
        //密码合法的都是123

        //这个代码固然能表现出效果，但是嵌套太深
//        if (username.equals("zhangsan") || username.equals("lisi")) {
//            if (password.equals("123")) {
//                //登录成功
//            } else {
//                //登录失败
//            }
//        } else {
//            //登录失败
//        }

        if (!username.equals("zhangsan") && !username.equals("lisi")) {
            //登录失败！！
            //重定向到登录页面
            System.out.println("登录失败，用户名错误！！");
            resp.sendRedirect("login.html");
            return;
        }
        if (!password.equals("123")) {
            //登录失败
            System.out.println("登录失败，密码错误");
            resp.sendRedirect("login.html");
            return;
        }
        //登录成功
        //1.创建一个会话
        HttpSession httpSession = req.getSession(true);
        //2.把当前的用户名保存到会话中，此处的HttpSession又可以当成一个map使用
        httpSession.setAttribute("username", username);
        //3.重定向到主页
        resp.sendRedirect("index");
    }
}
