package com.se.sample.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;


/**
 * пробуем рекурсивно сортировать
 */
public class QueryResultFormatterExtTestSortName {

    /**
     * Имя поляидинтификатора записи
     */
    final static protected String strIDFieldName = "typed_facet";
    protected static final String CHILDS_KEY = "childs";
    private static final Logger logger = LogManager.getLogger(QueryResultFormatterExtTestSortName.class);


    @SuppressWarnings(value = "unchecked")
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) {
        // если ничего не нашли на предыдущем шаге
        if (nLevelCount <= 0) {
            logger.debug("incorrect input level restriction : [" + nLevelCount + "]" );
            return null;
        }

        // результат
        final List<Map<String, Object>> oResult = new LinkedList<>();
        Map<String, Object> root = new HashMap<>();

        long startSubStructure = System.currentTimeMillis();
        // вспомагательная структура - ускоряем поиск родительских обьектов
        // вместо того чтобы перебирать варианты прохоходом по елементам
        Map<String, Map<String, Object>> map = new HashMap<>();
        for (Map<String, Object> record : aAllRecords) {
            String id = record.get(strIDFieldName).toString();
            map.put(id, record);
        }
        long buildSubstrDuration = System.currentTimeMillis() - startSubStructure;
        logger.debug("sub map built in sec:" + buildSubstrDuration / 1000);


        logger.debug("Count: [" + aAllRecords + "]" );
        int rowNum = 0;
        // перебираем все записи
        for (Map<String, Object> item : aAllRecords) {

            String id = String.valueOf(item.get(strIDFieldName));
            // получим все уровни
            String[] split = id.split("\\.");

            if (split.length > nLevelCount) {
                // превысили допустимое количество вложений (ограничение по уровням)
                continue;
            }

            Map<String, Object> currentParent = root;
            String parentId = id;

            if(split.length > 1){
                // обрезаем часть чтобы получить идентификатор родильского
                parentId = id.substring(0, id.lastIndexOf("."));
                currentParent = map.get(parentId);
            }

            if (!id.equals(parentId)) {
                /// проверить recursiveListSort
                currentParent.computeIfAbsent(CHILDS_KEY, k -> new LinkedList<String>());
                LinkedList childList = (LinkedList) currentParent.get(CHILDS_KEY);
                childList.add(item);
                currentParent.put(CHILDS_KEY, childList);
            } else {
                logger.debug("put parent item :" + id);
                currentParent.put(id, item);
            }

            rowNum++;
            int completedPercents = 100 * (rowNum / aAllRecords.size());
            if (rowNum > 0 && (completedPercents % 100 == 10)) {
                logger.info("progress: " + completedPercents);
            }
        }

        // приводим в нужный результат
        for (Object o : root.values()) {
            Map<String, Object> next = (Map<String, Object>) o;

            // пробуем отсортировать первій уровень
            //  Map<String, Object> maaap = recursiveListSort(next);
            // next.put(CHILDS_KEY,linkedList);

            oResult.add(next);
        }

        return oResult;
    }



    private Map<String, Object>  recursiveListSort( Map<String, Object> map) {

        // не нравиться рекурсия делем построчно

        //  уровень 1
        return map;
    }
}
