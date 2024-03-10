package com.se.sample.formatter;

import com.se.sample.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryResultFormatter {

    /**
     * Имя поляидинтификатора записи
     */
    final static protected String strIDFieldName = "typed_facet";
    protected static final String CHILDS_KEY = "childs";


    private static final Logger logger = LogManager.getLogger(QueryResultFormatter.class);

    public static void main(String[] args) throws IOException {
        List<Map<String, Object>> maps = FileUtils.readListMap("f100_records.json");

        List<Map<String, Object>> childs = new QueryResultFormatter().getChilds(maps, "", 3);

    }

    // TODO: WORKING HERE
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) {
        if (nLevelCount <= 0)
            return null;

        Map<String, Object> root = new HashMap<>();


        // перебираем все записи
        for (Map<String, Object> record : aAllRecords) {

            String id = String.valueOf(record.get(strIDFieldName));
            String[] split = id.split("\\.");

            for (int i = 0; i < split.length; i++) {

            }
        }

        // TODO: stub
        return  new ArrayList<>();
    }

}
