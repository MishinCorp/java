package simpleformprocess;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Class BeerSelect.
 * Implements IBeerSelect.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class BeerSelect extends HttpServlet implements IBeerSelect {
    @Override
    protected final void doPost(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        StringBuilder html = new StringBuilder();

        String aColor = req.getParameter("color");
        List brands = new BeerExpert().getBrands(aColor);
        Iterator it = brands.iterator();

        while (it.hasNext()) {
            html.append(it.next());
            html.append("<br/>");
        }

        out.print(html.toString());
        out.close();
    }
}
