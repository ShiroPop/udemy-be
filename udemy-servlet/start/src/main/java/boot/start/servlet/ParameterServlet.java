package boot.start.servlet;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/param-test")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException {
        String name = req.getParameter("name");
//        String[] hobbies = req.getParameterValues("hobby");

        String method = req.getMethod();

//        String userAgent = req.getHeader("User-Agent");

        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().println("요청메서드: " + method);
        resp.getWriter().println("이름: " + name);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException {

        String encoding = req.getCharacterEncoding();
        int length = req.getContentLength();

        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().println("인코딩:" + encoding);
        resp.getWriter().println("본문길이: " + length);

        ServletInputStream inputStream = req.getInputStream();
        byte[] buffer = inputStream.readAllBytes();
        String body = new String(buffer, encoding != null ? encoding : "utf-8");

        resp.getWriter().println("본문내용" + body);
    }
}
