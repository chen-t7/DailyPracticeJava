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
 * Date: 2024 -02 -28
 * Time: 16:46
 */

@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //预期浏览器会发一个形如 /getParameter?studentId=108&classId=20 秦秋
        //借助req里的getParameter 方法就能拿到query string 中的键值对内容了。
        //getParameter得到的是String类型的结果
        String studentId = req.getParameter("studentId");
        String classId = req.getParameter("classId");
        resp.setContentType("text/html;charset=utf8");
        //resp.setCharacterEncoding("utf8");
        resp.getWriter().write("学生Id:" + studentId + ", 班级Id:" + classId);
    }
}
