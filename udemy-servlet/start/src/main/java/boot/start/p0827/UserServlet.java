package boot.start.p0827;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final Map<String, String> userStore = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String storedPassword = userStore.get(username);

        if (storedPassword != null && storedPassword.equals(password)) {
            resp.setContentType("text/plain;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("로그인 성공: " + username);
        } else {
            resp.setContentType("text/plain;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("로그인 실패: 인증 실패");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username != null && password != null){
            userStore.put(username, password);

            resp.setContentType("text/plain;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write("회원가입 완료: " + username);
        }
    }
}
