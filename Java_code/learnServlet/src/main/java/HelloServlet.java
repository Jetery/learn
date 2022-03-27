import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2022.01.18
 */


// 根据 HTTP 请求 URL 的路径来进行关联
@WebServlet("/hello")
// 这是 servlet 起手式
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 在 HTTP 响应的 body 中 写入字符串
        resp.getWriter().write("hello servlet");
    }
}
