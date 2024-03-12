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

  // JsonObject employee = new JsonObject();

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

        List<Map<String, Object>> childs2 = new QueryResultFormatter().getChilds2(maps, "", 3);

    }

    public List<Map<String, Object>> getChilds2(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) throws JsonProcessingException {
        final List<Map<String, Object>> oResult = new LinkedList<Map<String, Object>>();

        // если ничего не нашли на предыдущем шаге
        if (nLevelCount <= 0)
            return oResult;


        List<AbstractMap.SimpleEntry> collect = aAllRecords.stream()
                .map(p -> new AbstractMap.SimpleEntry(p.get(strIDFieldName),
                        p.get(strIDFieldName).toString().split("\\.").length - 1))
                .collect(toList());


        List<MyStruct> levels = aAllRecords.stream().map(i ->
                new MyStruct(
                i.get(strIDFieldName).toString(),
                i.get(strIDFieldName).toString().split("\\.").length - 1,
                        i.get("Decode").toString(),
                        Integer.valueOf( i.get("Count").toString()),
                        i.get("dict_typed_facet_decode").toString())).filter(i -> i.level < nLevelCount)
                .sorted((o1, o2) -> o2.level - o1.level)
                .collect(Collectors.toList());

        for (MyStruct currentKey : levels) {

            String s = currentKey.typed_facet.lastIndexOf(".") < 0 ?
                    currentKey.typed_facet :
                    currentKey.typed_facet.substring(0, currentKey.typed_facet.lastIndexOf("."));

            levels.stream().filter(
                    x -> x.typed_facet.equals(s)
                            && x.level == currentKey.level - 1
            ).findFirst().ifPresent(i -> i.child.add(currentKey));
        }

        Map<String, List<MyStruct>> groups = levels.stream().filter(i -> i.level == 0)
                .collect(groupingBy(x -> x.typed_facet));


        List<StructuredResponse> collect1 = levels.stream()
                .map(s -> new StructuredResponse(s.typed_facet, s.Decode, s.Count, s.dict_typed_facet_decode))
                .collect(toList());



        // TODO: move to stream
        for (Map.Entry<String, List<MyStruct>> entries : groups.entrySet()) {

            Map<String, Object> aa = new HashMap<>();
            aa.put(entries.getKey(), entries.getValue());
            oResult.add(aa);
        }




        return oResult;
    }

    // TODO: WORKING HERE
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) throws JsonProcessingException {
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

            if (split.length > nLevelCount) {
                // превысили допустимое количество вложений (ограничение по уровням)
                continue;
            }

            Map<String, Object> currentParent = root;
            String parentId = id;

            // ищем родетеля для текущего
            for (int i = 0; i < split.length - 1; i++) {
                parentId = i == 0 ? split[i] : (parentId += "." + split[i]);

                // TODO: проверить что для этого есть родитель
                currentParent = getParentElementByPArentId(map, parentId);
            }

            if (!id.equals(parentId)) {
                if (currentParent.get(CHILDS_KEY) == null) {
                    currentParent.put(CHILDS_KEY, new HashMap<String, Object>());
                }
                ((Map<String, Object>) currentParent.get(CHILDS_KEY)).put(id, item);
            } else {
                currentParent.put(id, item);
            }
        }

        // приводим в нужный результат


        Iterator<Object> iterator = root.values().iterator();

        while (iterator.hasNext()) {
            Map<String, Object> next = (Map<String, Object>) iterator.next();
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

    static class MyStruct implements Comparable<MyStruct> {

        public String typed_facet;

        public Integer level;
        public Integer parentLevel;


        public String Decode;
        public Integer Count;
        public  String dict_typed_facet_decode;


        public List<MyStruct> child = new ArrayList<>();

        public MyStruct(String typed_facet, int level,String Decode, Integer Count, String dict_typed_facet_decode) {
            this.typed_facet = typed_facet;
            this.level = level;
            this.parentLevel = level - 1;
            this.Decode = Decode;
            this.Count = Count;
            this.dict_typed_facet_decode = dict_typed_facet_decode;
        }


        @Override
        public int compareTo(MyStruct o) {
            return o.level - this.level;
        }

        @Override
        public String toString() {
            return "MyStruct{" +
                    "key='" + typed_facet + '\'' +
                    '}';
        }
    }

    static class StructuredResponse {

        public String typed_facet;
        public String Decode;
        public Integer Count;
        public  String dict_typed_facet_decode;


        public List<StructuredResponse> child = new ArrayList<>();

        public StructuredResponse(String typed_facet,String Decode, Integer Count, String dict_typed_facet_decode) {
            this.typed_facet = typed_facet;
       
            this.Decode = Decode;
            this.Count = Count;
            this.dict_typed_facet_decode = dict_typed_facet_decode;
        }

        public String getTyped_facet() {
            return typed_facet;
        }

        public void setTyped_facet(String typed_facet) {
            this.typed_facet = typed_facet;
        }

        public String getDecode() {
            return Decode;
        }

        public void setDecode(String decode) {
            Decode = decode;
        }

        public Integer getCount() {
            return Count;
        }

        public void setCount(Integer count) {
            Count = count;
        }

        public String getDict_typed_facet_decode() {
            return dict_typed_facet_decode;
        }

        public void setDict_typed_facet_decode(String dict_typed_facet_decode) {
            this.dict_typed_facet_decode = dict_typed_facet_decode;
        }
    }

}
