package com.se.sample;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class ResourceFolderFilesReaderAppTest
{

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void starting(final Description description) {
            String methodName = description.getMethodName();
            String className = description.getClassName();
            className = className.substring(className.lastIndexOf('.') + 1);
            System.err.println("Starting JUnit-test: " + className + " " + methodName);
        }
    };


    // @DisplayName("Test loading a JSON file")
    @Test
    public void loadJSONTest() {

        String fileName = "json/file1.json";

        ClassLoader classLoader = getClass().getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // @DisplayName("Test loading a properties file")
    @Test
    public  void loadPropTest() throws IOException, URISyntaxException {

        String fileName = "database.properties";

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }

        //File file = new File(resource.getFile());
        File file = new File(resource.toURI());

        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        lines.forEach(System.out::println);

    }
}
