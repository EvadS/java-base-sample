package com.se.sample.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;


/**
 * используем TreeSet для сортировки вложенных занчений
 * сейчас захаркожена сортировка по количеству
 */
public class QueryResultFormatterExtTreeSet {

    /**
     * Имя поляидинтификатора записи
     */
    protected static final String strIDFieldName = "typed_facet";
    protected static final String CHILDS_KEY = "childs";
    private static final Logger logger = LogManager.getLogger(QueryResultFormatterExtTreeSet.class);


    @SuppressWarnings(value = "unchecked")
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) {
        // если ничего не нашли на предыдущем шаге
        if (nLevelCount <= 0)
            return null;

        // результат
        final List<Map<String, Object>> oResult = new LinkedList<>();
        Map<String, Object> root = new HashMap<>();

        // вспомагательная структура - ускоряем поиск родительских обьектов
        // вместо того чтобы перебирать варианты прохоходом по елементам
        Map<String, Map<String, Object>> map = new HashMap<>();
        for (Map<String, Object> record : aAllRecords) {
            String id = record.get(strIDFieldName).toString();
            map.put(id, record);
        }

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

            // ищем родетеля для текущего
            for (int i = 0; i < split.length - 1; i++) {
                parentId = i == 0 ? split[i] : parentId + ("." + split[i]);

                // TODO: проверить что для этого есть родитель
                currentParent = map.get(parentId);
            }

             if (!id.equals(parentId)) {
                currentParent.computeIfAbsent(CHILDS_KEY, k -> new TreeSet<>(
                        new Comparator<Map<String, Object>>() {
                            @Override
                            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                                String id1 = String.valueOf(o1.get("Count"));
                                Integer idInt = Integer.parseInt(id1);
                                String id2 = String.valueOf(o2.get("Count"));
                                Integer idInt2 = Integer.parseInt(id2);
                                return idInt - idInt2;
                            }
                        }));

                TreeSet oo = (TreeSet) currentParent.get(CHILDS_KEY);
                oo.add(item);
                currentParent.put(CHILDS_KEY, oo);
            } else {
                currentParent.put(id, item);
            }
        }

        // приводим в нужный результат
        for (Object o : root.values()) {
            Map<String, Object> next = (Map<String, Object>) o;
            oResult.add(next);
        }

        return oResult;
    }
}
