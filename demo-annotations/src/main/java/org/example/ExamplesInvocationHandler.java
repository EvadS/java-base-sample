package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class ExamplesInvocationHandler implements InvocationHandler {
    // ******************************
    // Fields
    // ******************************
    private Examples examples = new ExamplesImpl();

    // ******************************
    // Public methods
    // ******************************
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // If the annotation is not present, just redirect the method call to its origin...
        if(!method.isAnnotationPresent(Clocking.class)) {
            return method.invoke(examples, args);
        }

        // ... otherwise log the execution time of it.
        Instant start = Instant.now();
        Object returnObj = method.invoke(examples, args);
        Instant end = Instant.now();

        // TODO: This is for demonstration purpose only and should use the application's logging system.

        String formattedDuration =   formatDuration(Duration.between( start, end));
        System.out.println("Method " + method.getName() + " executed in " + formattedDuration + ".");

        return returnObj;
    }

    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}