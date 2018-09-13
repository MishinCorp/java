package date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class Servlet.
 * Implements simple html-page.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class Servlet extends HttpServlet {
    @Override
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        SimpleDate simpleDate = new SimpleDate();
        String result = simpleDate.getMonth();

        StringBuilder html = new StringBuilder();
        html.append("<!doctype html>")
                .append(System.lineSeparator())
                .append("<html lang=\"en\">")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">")
                .append(System.lineSeparator())
                .append("<title>Document</title>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator())
                .append("<p><a href=\"..\\index.jsp\">Главная</a></p>")
                .append(System.lineSeparator())
                .append(result)
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>");

        out.print(html.toString());

        out.close();
    }
}
