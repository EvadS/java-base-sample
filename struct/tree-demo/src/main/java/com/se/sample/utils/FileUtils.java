package com.se.sample.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.config.AppConfig;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

    private static final Logger logger = LogManager.getLogger(FileUtils.class);


    public static List<String> readListFromResources(String fileName) {
        List<String> resultList = new ArrayList<>();

        String fullFileName = AppConfig.DOCUMENT_FOLDER + File.separator + fileName;

        try (final InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(fullFileName);
             BufferedInputStream bf = new BufferedInputStream(is);
             final BufferedReader reader = new BufferedReader(
                     new InputStreamReader(bf, StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }

        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

        return resultList;
    }




    public static  List<Map<String, Object>> readListMap(String fileName) throws IOException {

        String fullFileName = AppConfig.DOCUMENT_FOLDER + File.separator + fileName;

        ObjectMapper mapper = new ObjectMapper();

        InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(fullFileName);

        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};

        List<Map<String, Object>> mapList =
                mapper.readValue(is , new TypeReference<List<Map<String, Object>>>(){});

        return  mapList;

    }


}
