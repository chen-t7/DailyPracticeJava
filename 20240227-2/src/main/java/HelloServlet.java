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
 * Date: 2024 -02 -27
 * Time: 21:46
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //可以在这里重写init方法
        //插入一些自己的“初始化”相关的逻辑
        System.out.println("init()");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个代码一定要干掉，父类里的这个方法只是返回了一个错误页面
        //super.doGet(req, resp);

        //这个是在服务器的控制台里打印的
        System.out.println("hello world");

        //要想把hello world 返回到客户端，需要使用下面的代码。
        //getWriter会得到一个Writer对象
        resp.getWriter().write("hello world");
    }
}
