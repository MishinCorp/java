package simpleformprocess;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class BeerSelectTest.
 * Tests BeerSelect class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 13.09.2018
 */
public class BeerSelectTest extends Mockito {
    /**
     * Method tests obtaining html.
     *
     * @throws ServletException ServletException.
     * @throws IOException      IOException.
     */
    @Test
    public void whenServletThenGetHtml() throws ServletException, IOException {
        BeerSelect servlet = new BeerSelect();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(request.getParameter("color")).thenReturn("light");
        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        StringBuilder expected = new StringBuilder();
        expected.append("Jail Pale Ale")
                .append("<br/>")
                .append("Gout Stout")
                .append("<br/>");


        String result = stringWriter.toString();

        verify(request, times(1)).getParameter("color");
        verify(response, times(1)).getWriter();

        assertThat(result, is(expected.toString()));
    }

}