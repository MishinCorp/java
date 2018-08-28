package helloworld;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;

/**
 * Class HelloUserTest.
 * Tests HelloUser class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2018
 */
public class HelloUserTest {
    //    HelloUser helloUser = mock(HelloUser.class);
    HelloUser helloUser = new HelloUser();

    /**
     * Method gets greeting.
     */
    @Test
    public void whenGetGreetingThenGetString() {
        String name = "Yura";
        String expected = String.format("Hello, %s!", name);

//        when(helloUser.getGreeting(name)).thenReturn(expected);
        String result = helloUser.getGreeting(name);

        assertEquals(expected, result);

//        verify(helloUser).getGreeting(name);
    }

    /**
     * Method throws Exception.
     */
    @Test(expected = RuntimeException.class)
    public void whenNameEmptyThenThrowException() {
        String name = "";
        String expected = String.format("Hello, %s!", name);

//        RuntimeException exception = new RuntimeException ();
//        doThrow(exception).when(helloUser.getGreeting(name));
        String result = helloUser.getGreeting(name);

        assertEquals(expected, result);

//        verify(helloUser).getGreeting(name);
    }

    /**
     * Complex answer.
     */
    private Answer<String> answer = new Answer<String>() {
        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {
            Object mock = invocation.getMock();

            Object[] args = invocation.getArguments();
            String name = (String) args[0];
            String result = String.format("Hello, Yura %s!", name);

            return result;
        }
    };

    /**
     * Method uses mock complex answer.
     */
    @Test
    public void whenMishinThenSpecificAnswer() {
        String name = "Mishin";
        String expected = String.format("Hello, Yura %s!", name);

//        when(helloUser.getGreeting(name)).thenAnswer(answer);
        String result = helloUser.getGreeting(name);
        assertEquals(expected, result);
//        verify(helloUser).getGreeting(name);
    }

    /**
     * Method uses mock spy option.
     */
    @Test
    public void whenUserThenSpecificAnswer() {
//        HelloUser helloUserSpy = spy(new HelloUser());
        HelloUser helloUserSpy = new HelloUser();

        String name = "User";
        String expected = String.format("Hello, my %s!", name);

//        when(helloUserSpy.getGreeting(name)).thenReturn(expected);
        String result = helloUserSpy.getGreeting(name);

        assertEquals(expected, result);

//        verify(helloUserSpy).getGreeting(name);
    }
    /**
     * Method tests ordinary invoke.
     */
    @Test
    public void whenInvokeThenGetAnswer() {
//        HelloUser helloUserSpy = spy(new HelloUser());
        HelloUser helloUserSpy = new HelloUser();

        String name = "Alex";
        String expected = String.format("Hello, %s!", name);

//        when(helloUserSpy.getGreeting(name)).thenReturn(expected);
        String result = helloUserSpy.getGreeting(name);

        assertEquals(expected, result);

//        verify(helloUserSpy).getGreeting(name);
    }
}