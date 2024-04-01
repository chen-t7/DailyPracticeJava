import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -02 -28
 * Time: 16:28
 */

@WebServlet("/ShowRequest")
public class ShowRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里是设置响应的content-type，告诉浏览器，响应body里的数据格式是啥样的
        resp.setContentType("text/html");

        //搞个StringBuilder，把这些api的结果拼起来，统一写回到响应中
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");

        //获取到header中所有的键值对
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            stringBuilder.append(headerName + ": " + req.getHeader(headerName));
            stringBuilder.append("<br>");
        }
        resp.getWriter().write(stringBuilder.toString());
    }
}
