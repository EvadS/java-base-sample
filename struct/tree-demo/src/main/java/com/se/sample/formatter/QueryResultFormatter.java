package com.se.sample.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;


public class QueryResultFormatter {

    /**
     * Имя поляидинтификатора записи
     */
    final static protected String strIDFieldName = "typed_facet";
    protected static final String CHILDS_KEY = "childs";
    private static final Logger logger = LogManager.getLogger(QueryResultFormatter.class);


    public static void main(String[] args) throws IOException {
        List<Map<String, Object>> maps = FileUtils.readListMap("f100_records1.json");

        List<Map<String, Object>> childs = new QueryResultFormatter().getChilds(maps, "", 4);
        logger.info("Grouped result: {}", new ObjectMapper().writeValueAsString(childs));

        logger.info("-------------------------------------");
        List<Map<String, Object>> childs2 = new QueryResultFormatter().getChilds2(maps, "", 3);
        logger.info("Grouped result on stream api: {}", new ObjectMapper().writeValueAsString(childs2));
    }


    public List<Map<String, Object>> getChilds2(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount)  {
        List<Map<String, Object>> oResult = new LinkedList<>();

        // если ничего не нашли на предыдущем шаге
        if (nLevelCount <= 0)
            return oResult;

        List<GrouppedStructure> levels = aAllRecords.stream().map(i ->
                new GrouppedStructure(
                        i.get(strIDFieldName).toString(),
                        i.get(strIDFieldName).toString().split("\\.").length - 1,
                        i.get("Decode").toString(),
                        Integer.valueOf(i.get("Count").toString()),
                        i.get("dict_typed_facet_decode").toString())).filter(i -> i.level < nLevelCount)
                .sorted((o1, o2) -> o2.level - o1.level)
                .collect(Collectors.toList());

        for (GrouppedStructure currentKey : levels) {
            String parentLevel = currentKey.typed_facet.lastIndexOf(".") < 0 ?
                    currentKey.typed_facet :
                    //от текущего ключа отрезаем последний блок
                    currentKey.typed_facet.substring(0, currentKey.typed_facet.lastIndexOf("."));

            // find parent for element
            levels.stream().filter(
                    x -> x.typed_facet.equals(parentLevel)
                            && x.level == currentKey.level - 1)
                    .findFirst()
                    .ifPresent(i -> i.child.add(currentKey));
        }

        Map<String, List<GrouppedStructure>> groups = levels.stream().filter(i -> i.level == 0)
                .collect(groupingBy(x -> x.typed_facet));

        groups.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));

        oResult = groups.entrySet().stream()
                .filter(Objects::nonNull)
                .map(this::buildMapEntry)
                .collect(toList());

        return oResult;
    }

    private Map<String, Object> buildMapEntry(Map.Entry<String, List<GrouppedStructure>> elt) {
         return Collections.singletonMap(elt.getKey(),  elt.getValue());
    }


    // TODO: WORKING HERE
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount)   {
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
                currentParent = getParentElementByPArentId(map, parentId);
            }

            if (!id.equals(parentId)) {
                currentParent.computeIfAbsent(CHILDS_KEY, k -> new HashMap<String, Object>());
                if(currentParent.get(CHILDS_KEY) instanceof Map) {
                    ((Map<String, Object>) currentParent.get(CHILDS_KEY)).put(id, item);
                }
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

        return map.get(parentId);
    }

    static class GrouppedStructure //implements Comparable<GrouppedStructure>
    {

        public String typed_facet;
        public String Decode;
        public Integer Count;
        public String dict_typed_facet_decode;

        public Integer level;
        public List<GrouppedStructure> child = new ArrayList<>();

        public GrouppedStructure(String typed_facet, int level, String Decode, Integer Count, String dict_typed_facet_decode) {
            this.typed_facet = typed_facet;
            this.level = level;
            this.Decode = Decode;
            this.Count = Count;
            this.dict_typed_facet_decode = dict_typed_facet_decode;
        }

        @Override
        public String toString() {
            return "MyStruct{" +
                    "typed_facet='" + typed_facet + '\'' +
                    ", Decode='" + Decode + '\'' +
                    ", Count=" + Count +
                    ", dict_typed_facet_decode='" + dict_typed_facet_decode + '\'' +
                    ", level=" + level +
                    ", child=" + child +
                    '}';
        }
    }


}
