package date;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class ServletTest.
 * Tests Servlet class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.08.2018
 */
public class ServletTest extends Mockito {
    /**
     * Method tests obtaining html.
     *
     * @throws ServletException ServletException.
     * @throws IOException      IOException.
     */
    @Test
    public void whenServletThenGetHtml() throws ServletException, IOException {
        Servlet servlet = new Servlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        String format = "MMMM";
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format,
                Locale.ENGLISH);

        String month = dateFormat.format(new Date());

        StringBuilder expected = new StringBuilder();
        expected.append("<!doctype html>")
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
                .append(month)
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>");

        String result = stringWriter.toString();

        verify(response, times(1)).getWriter();

        assertThat(result, is(expected.toString()));
    }
}