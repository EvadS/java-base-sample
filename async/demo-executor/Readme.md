

              Exception
                /   \
RuntimeException    Exception
“непроверяемые”       “проверяемые”
                        Если компилятор их найдет, то не скомпилирует код, пока не обработаем их или не пробросим наверх.
                        (IOException, FileNotFoundException)


Проверяемых исключений — их надо обрабатывать.

## Многопоточность в Java
 каждый поток имеет свою обособленную область в памяти, выделенной для процесса. Эту структуру памяти называют стеком.
 Стек состоит из фрэймов. Фрэйм — это точка вызова метода, execution point. Также фрэйм может быть представлен как StackTraceElement


 почитать потом
 ```
 https://javarush.com/groups/posts/2048-threadom-java-ne-isportishjh--chastjh-ii---sinkhronizacija
 ```


 TODO:
 Consumer - Supplier
 --------------

 ## CompletableFutureApp
 CompletableFuture - класс для асинхронной работы,  дает возможность комбинировать шаги обработки, соединяя их в цепочку