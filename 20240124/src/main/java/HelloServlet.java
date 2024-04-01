import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -01 -24
 * Time: 21:40
 */

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个代码一定要干掉，父类里的这个方法只是返回了一个错误页面~~
        //super.doGet(req, resp);
        //这个是在服务器的控制台里打印，
        System.out.println("hello world");
        //要想把hello world返回到客户端，需要使用下面的代码
        //getWriter会得到一个Writer对象
        resp.getWriter().write("hello world");
    }
}