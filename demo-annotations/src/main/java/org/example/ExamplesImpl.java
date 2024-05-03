package org.example;

public class ExamplesImpl implements Examples {
    @Override
    public void thisIsAMethod() {
        System.out.println("thisIsAMethod called!");
    }

    @Override
    public void thisIsAnotherMethod(String something) {
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thisIsAnotherMethod called!");
    }

    @Override
    public void thisIsALongRunningMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thisIsALongRunningMethod called!");
    }
}

