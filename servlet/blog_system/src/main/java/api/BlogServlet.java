package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2024 -03 -03
 * Time: 17:05
 */
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //尝试获取一下queryString中的blogId字段
        BlogDao blogDao = new BlogDao();
        String blogId = req.getParameter("blogId");
        if (blogId == null) {
            //queryString不存在，这次请求是获取博客列表
            List<Blog> blogList = blogDao.selectAll();
            //需要把blogList转成符合要求的字符串
            String respJson = objectMapper.writeValueAsString(blogList);
            resp.setContentType("application/json;charset=utf8");
            resp.getWriter().write(respJson);
        } else {
            //queryString存在，说明本次请求获取的是指定id的博客
            Blog blog = blogDao.selectById(Integer.parseInt(blogId));
            if (blog == null) {
                System.out.println("当前blogId = " + blogId + "对应的博客不存在");
            }
            String respJson = objectMapper.writeValueAsString(blog);
            resp.setContentType("application/json;charset=utf8");
            resp.getWriter().write(respJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //发布博客
        //读取请求，构造Blog对象，插入数据库即可
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请登录后再发布博客");
            return;
        }
        User user = (User)httpSession.getAttribute("user");
        if (user == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请登录后再发布博客");
            return;
        }
        //确认登录之后，就可以把作者拿到了


        //获取博客标题和正文
        req.setCharacterEncoding("utf8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || "".equals(title) || content == null || "".equals(content)) {
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前提交数据有误！标题或者正文为空！");
        }

        //构造Blog对象
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());
        //发布时间，在java中生成 / 数据库 生成都行
        blog.setUpdateTime(new Timestamp((System.currentTimeMillis())));
        //插入数据库
        BlogDao blogDao = new BlogDao();
        blogDao.add(blog);
        //跳转到博客列表
        resp.sendRedirect("blog_list.html");
    }
}
