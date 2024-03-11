package com.se.sample.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

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

        final List<Map<String, Object>> oResult = new LinkedList<Map<String, Object>>();

        Map<String, Object> root = new HashMap<>();


        int row = 1;
        // перебираем все записи
        for (Map<String, Object> record : aAllRecords) {

            String id = String.valueOf(record.get(strIDFieldName));
            String[] split = id.split("\\.");

            Map<String, Object> parentCurr = root;
            String parentId = id;
            // ищем родетеля для текущего
            for (int i = 0; i < split.length - 1; i++) {
                //search parent
                if (i == 0) {
                    parentId = split[i];
                } else {
                    parentId +=  "." + split[i];
                }

                // TODO: проверить что для єтого есть родитель
                parentCurr = getParentCurr(root, parentId, i);
            }

            if (!id.equals(parentId)) {
                if (parentCurr.get(CHILDS_KEY) == null) {
                    parentCurr.put(CHILDS_KEY, new HashMap<String, Object>());
                }
                ((Map<String, Object>) parentCurr.get(CHILDS_KEY)).put(id, record);
            } else { // id: 032-0000
                parentCurr.put(id, record);
                oResult.add(parentCurr);
            }

            if (row == 10) {
                printToConsole(root);
            }
            row++;
        }

        // TODO: stub
        return (List<Map<String, Object>>) root.get("032-0000");
    }

    private void printToConsole(Map<String, Object> root) {
        try {
            String jsonString = new ObjectMapper().writeValueAsString(root);
            logger.info(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> getParentCurr(Map<String, Object> root, String parentId, int level) {

       if (level == 1) {
            // 032-0000.0000 - ищем в child
            // сначала взять дочерний потом в дочерний ложить по ключу
            Map<String, Object> childs =(Map<String, Object>)((Map<String, Object>) (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) root.get("032-0000")).get("childs")).get("032-0000.0000"));
            return childs;

        } else if (level == 2) {
            Map<String, Object> childs = (Map<String, Object>)(((Map<String, Object>)(Map<String, Object>)((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) root.get("032-0000")).get("childs"))
                    .get("032-0000.0000")).get("childs")).get("032-0000.0000.0000"));
            return childs;
        } else if (level == 3) {
            Map<String, Object> childs =(Map<String, Object>)((Map<String, Object>) ((Map<String, Object>)((Map<String, Object>)((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>)
                    root.get("032-0000")).get("childs")).get("032-0000.0000")).get("childs")).get("032-0000.0000.0000")).get("childs") ).get("032-0000.0000.0000.0000") ;
            return childs;
        } else if (level == 4) {
            Map<String, Object> child1 = (Map<String, Object>) ((Map<String, Object>) root.get("032-0000")).get("childs");
            return child1;
        }

        Map<String, Object> stringObjectMap = (Map<String, Object>) root.get(parentId);
        return stringObjectMap;

    }

}
