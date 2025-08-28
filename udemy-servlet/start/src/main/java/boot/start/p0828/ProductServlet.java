package boot.start.p0828;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private static final List<Product> products = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String productId = req.getParameter("productId");
        String minPriceStr = req.getParameter("minPrice");

        List<Product> result = new ArrayList<>(products);

        if (productId != null && !productId.isEmpty()) {
            result = result.stream().filter(p->p.getProductId().equals(productId)).toList();
            if (result.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                resp.setStatus(HttpServletResponse.SC_OK);
            }
        }

        if(minPriceStr != null && !minPriceStr.isEmpty()){
            try {
                int minPrice = Integer.parseInt(minPriceStr);
                result = result.stream().filter(p -> p.getPrice() > minPrice).collect(Collectors.toList());
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.println("<html><body><h2>잘못된 값입니다.</h2></body></html>");
                return;
            }
        }

        out.println("<html><body>");
        out.println("<h2>상품 목록</h2>");
        if (result.isEmpty()) {
            out.println("<p>조회된 상품이 없습니다.</p>");
        } else {
            out.println("<ul>");
            for (Product product : result) {
                out.println("<li>" + product.getProductId() + " - "
                        + product.getProductName() + " (" + product.getPrice() + "원)</li>");
            }
            out.println("</ul>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String jsonBody = new String (req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        Product product = objectMapper.readValue(jsonBody, Product.class);
        products.add(product);

        resp.setContentType("text/html;charset=UTF-8");
        resp.setStatus(HttpServletResponse.SC_CREATED);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>상품 등록 성공!</h2>");
        out.println("<p>ID: " + product.getProductId() + "</p>");
        out.println("<p>Name: " + product.getProductName() + "</p>");
        out.println("<p>Price: " + product.getPrice() + "</p>");
        out.println("<a href='/product'>상품 목록 보기</a>");
        out.println("</body></html>");
    }
}
