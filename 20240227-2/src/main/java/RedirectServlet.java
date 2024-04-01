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
 * Time: 17:40
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("https://www.baidu.com/?tn=02049043_50_pg&ch=15");
        resp.setStatus(302);
        resp.setHeader("Location", "https://www.baidu.com/?tn=02049043_50_pg&ch=15");
    }
}
