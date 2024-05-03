package org.example;
import java.lang.reflect.Proxy;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Examples examples = (Examples) Proxy.newProxyInstance(Examples.class.getClassLoader(),
                new Class[]{Examples.class}, new ExamplesInvocationHandler());

        examples.thisIsAMethod();
        examples.thisIsAnotherMethod("");
        examples.thisIsALongRunningMethod();
    }
}
