package com.se.sample;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStreamTest {

    @Test
    public void stream_on_directories() throws URISyntaxException, IOException {

        // строки файла из директории ресурсов
        URI uri = ClassLoader.getSystemResource("some.txt").toURI();
        Files.lines(Paths.get(uri)).forEach(System.out::println);

        // файлы корня проекта
        Stream<String> lines = Files.lines(Paths.get(uri));

        // файлы корня проекта
        Stream<Path> walk = Files.list(Paths.get("./"));

        final Stream<String> linesFiles = Files.lines(Paths.get(uri));

        //stream has already been operated upon or closed
        System.out.println(lines.parallel().filter(str -> str.contains("333")).count());

    }
}
