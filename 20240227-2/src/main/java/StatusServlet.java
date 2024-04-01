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
 * Date: 2024 -02 -29
 * Time: 17:54
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setStatus(404);
//        //但是这里不设置body
//        resp.setContentType("text/html;charset=utf8");
//        resp.getWriter().write("<h1>404 没找到<h1>");
        resp.sendError(404);
    }
}
