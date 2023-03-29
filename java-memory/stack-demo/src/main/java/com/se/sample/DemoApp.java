package com.se.sample;

public class DemoApp {

    public static void main(String[] args) {
        Integer intObj  = new Integer(10);
        int intValue = 100;

        MyObject myObject = new MyObject();
        myObject.val = 1000;

        System.out.println("Before: ");
        System.out.println("int:"+ intValue);
        System.out.println("Integer:"+ intObj);
        System.out.println("myObject:"+ myObject);


        System.out.println("--------------------");

        functionObject(intObj);
        functionObject(myObject);
        functionValue(intValue);

        System.out.println("After: ");
        System.out.println("int:"+ intValue);
        System.out.println("Integer:"+ intObj);
        System.out.println("myObject:"+ myObject);


    }

    /**
     * Java всегда передает параметры по значению
     * метод работает с копией данных.
     * @param input
     * @return
     */
    private  static Integer  functionObject(Integer input){
        /*
        * Операция инкремента у экземпляра Integer приводит к
        *  созданию нового объекта, а поскольку в метод передаётся копия
        *  ссылки, то при инкременте она перестаёт ссылаться на старый
        * объект в куче и начинает ссылаться на новый. Оригинальная
        *  ссылка в методе main будет ссылаться на старый объект до
        *  изменения*/
        //Integer a = new Integer(input.intValue()--);
        return --input;
    }

    /**
     * метод работает с копией данных.
     * @param input
     * @return
     */
    private  static int functionValue(int input){
        return  --input;
    }


    private  static int functionObject(MyObject input){
        return input.val--;
    }

    static class MyObject{
        public int val;

        @Override
        public String toString() {
            return "MyObject{" +
                    "val=" + val +
                    '}';
        }
    }
}
