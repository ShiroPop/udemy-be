package boot.start.p0829;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    private final PostRepository postRepository = new PostRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();

        String keyword = req.getParameter("keyword");

        out.println("<html><body>");
        out.println("<h2>게시글 작성</h2>");
        out.println("<form method='post' action='/post'>");
        out.println("제목: <input type='text' name='title'/><br/>");
        out.println("내용: <textarea name='content'></textarea><br/>");
        out.println("<input type='submit' value='등록'/>");
        out.println("</form><hr/>");

        List<Post> posts;
        if (keyword != null && !keyword.isEmpty()) {
            posts = postRepository.search(keyword);
            out.println("<h3>검색 결과 (keyword=" + keyword + ")</h3>");
        } else {
            posts = postRepository.findAll();
            out.println("<h3>전체 게시글 목록</h3>");
        }

        for (Post post : posts) {
            out.println("<p>");
            out.println("<b>" + post.getPostIdx() + ". " + post.getTitle() + "</b><br/>");
            out.println(post.getContent() + "<br/>");
            out.println("<small>작성 시간: " + post.getCreatedAt() + "</small>");
            out.println("</p><hr/>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title  = req.getParameter("title");
        String content = req.getParameter("content");

        Post post = new Post(title, content);
        postRepository.save(post);

        res.setContentType("text/html; charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<html><body>");
        out.println("<h2>게시글 등록 성공!</h2>");
        out.println("<a href='/post'>게시글 목록 보기</a>");
        out.println("</body></html>");
    }
}
