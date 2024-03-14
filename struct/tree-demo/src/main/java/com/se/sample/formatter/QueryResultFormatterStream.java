package com.se.sample.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.sample.utils.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * пробуем строить вложенность при помощи группировок
 */
public class QueryResultFormatterStream {

    /**
     * Имя поляидинтификатора записи
     */
    final static protected String strIDFieldName = "typed_facet";
    protected static final String CHILDS_KEY = "childs";
    private static final Logger logger = LogManager.getLogger(QueryResultFormatterStream.class);


    public static void main(String[] args) throws IOException {
        List<Map<String, Object>> maps = FileUtils.readListMapFromDocumentSubFolder("base_records_for_sort.json");

        logger.info("-------------------------------------");
        List<Map<String, Object>> childs = new QueryResultFormatterStream().getChilds(maps, "", 3);
        logger.info("Grouped result on stream api: {}", new ObjectMapper().writeValueAsString(childs));
    }


    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount)  {
        List<Map<String, Object>> oResult = new LinkedList<>();

        // если ничего не нашли на предыдущем шаге
        if (nLevelCount <= 0)
            return oResult;

        List<QueryResultFormatterStream.GroupedStructure> levels = aAllRecords.stream().map(i ->
                new QueryResultFormatterStream.GroupedStructure(
                        i.get(strIDFieldName).toString(),
                        i.get(strIDFieldName).toString().split("\\.").length - 1,
                        i.get("Decode").toString(),
                        Integer.valueOf(i.get("Count").toString()),
                        i.get("dict_typed_facet_decode").toString())).filter(i -> i.level < nLevelCount)
                .sorted((o1, o2) -> o2.level - o1.level)
                .collect(Collectors.toList());

        for (QueryResultFormatterStream.GroupedStructure currentKey : levels) {
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

        Map<String, List<QueryResultFormatterStream.GroupedStructure>> groups = levels.stream().filter(i -> i.level == 0)
                .collect(groupingBy(x -> x.typed_facet));

        oResult = groups.entrySet().stream()
                .filter(Objects::nonNull)
                .map(this::buildMapEntry)
                .collect(toList());

        return oResult;
    }

    private Map<String, Object> buildMapEntry(Map.Entry<String, List<QueryResultFormatterStream.GroupedStructure>> elt) {
        return Collections.singletonMap(elt.getKey(),  elt.getValue());
    }

    static class GroupedStructure
    {

        public String typed_facet;
        public String Decode;
        public Integer Count;
        public String dict_typed_facet_decode;

        public Integer level;
        public List<QueryResultFormatterStream.GroupedStructure> child = new ArrayList<>();

        public GroupedStructure(String typed_facet, int level, String Decode, Integer Count, String dict_typed_facet_decode) {
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
