package com.se.sample.formatter;

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
        List<Map<String, Object>> maps = FileUtils.readListMap("f100_records1.json");

        List<Map<String, Object>> childs = new QueryResultFormatter().getChilds(maps, "", 3);

    }

    private static List<Map<String, Object>> queryForList(String s) {
        final List<Map<String, Object>> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Map<String, Object> map = new HashMap<>();
            map.put("key", "key" + i);
            map.put("value", "value" + i);
            result.add(map);
        }

        return result;
    }

    // TODO: WORKING HERE
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) {
       // если ничего не нашли на предыдущем шаге
       if (nLevelCount <= 0)
            return null;

        // результат
        final List<Map<String, Object>> oResult = new LinkedList<Map<String, Object>>();
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

            if(split.length> nLevelCount){
                // превысили допустимое количество вложений (ограничение по уровням)
                continue;
            }

            Map<String, Object> currentParent  = root;
            String parentId = id;

            // ищем родетеля для текущего
            for (int i = 0; i < split.length - 1; i++) {
                parentId = i == 0 ? split[i] : (parentId += "." + split[i]);

                // TODO: проверить что для этого есть родитель
                currentParent = getParentElementByPArentId(map, parentId);
            }

            if (!id.equals(parentId)) {
                if (currentParent .get(CHILDS_KEY) == null) {
                    currentParent .put(CHILDS_KEY, new HashMap<String, Object>());
                }
                ((Map<String, Object>) currentParent .get(CHILDS_KEY)).put(id, item);
            } else {
                currentParent.put(id, item);
            }
        }

        // приводим в нужный результат

        Iterator<Object> iterator = root.values().iterator();

        while (iterator.hasNext()){
            Map<String, Object> next = (Map<String, Object>)iterator.next();
            oResult.add(next);
        }

        return oResult;
    }



    private Map<String, Object> getParentElementByPArentId(Map<String, Map<String, Object>> map, String parentId) {

        // если не использовать мапу для поиска родительского - получим следующий код
//      if (level == 1) {
//            // 032-0000.0000 - ищем в child
//            Map<String, Object> childs = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) root
//            .get("032-0000")).get("childs"))
//            .get("032-0000.0000");
//            return childs;
//
//        } else if (level == 2) {
//            Map<String, Object> childs = (Map<String, Object>) (((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) root
//                    .get("032-0000")).get("childs"))
//                    .get("032-0000.0000")).get("childs"))
//                    .get("032-0000.0000.0000"));
//            return childs;

//        } else if (level == 3) {
//            Map<String, Object> childs = (Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>)
//                    root
//                    .get("032-0000")).get("childs"))
//                    .get("032-0000.0000")).get("childs")).get("032-0000.0000.0000"))
//                    .get("childs")).get("032-0000.0000.0000.0000");
//            return childs;
//        } else if (level == 4) {
//            Map<String, Object> child1 = (Map<String, Object>) ((Map<String, Object>) root.get("032-0000")).get("childs");
//            return child1;
//        }

        Map<String, Object> stringObjectMap = map.get(parentId);
        return stringObjectMap;
    }

}
