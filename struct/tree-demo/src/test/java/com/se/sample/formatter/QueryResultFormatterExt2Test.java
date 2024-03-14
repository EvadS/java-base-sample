package com.se.sample.formatter;

import com.se.sample.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryResultFormatterExt2Test {

    QueryResultFormatterExt2 formatter =   new QueryResultFormatterExt2();

    @Test
    public void formatter_should_work_correct() throws IOException {
        List<Map<String, Object>> maps = FileUtils.readListMapFromDocumentSubFolder("base_records_for_sort.json");

        List<Map<String, Object>> root = formatter.getChilds(maps, "", 5);

        Assert.assertNotNull(root);
        Assert.assertEquals(1, root.size());
        // количество дочерних для первого уровня
        Assert.assertEquals(2, ((HashMap)root.get(0).get("childs")).size());

        // проверяем что на втором уровне только массив без идентификаторов
        Map<String, Map<String, Object>> childsSecondLevel = (Map<String, Map<String, Object>> ) root.get(0).get("childs");

        // количество дочерние для второго уровня
        Assert.assertNotNull(childsSecondLevel);
        Assert.assertEquals(3,((HashMap)childsSecondLevel.get("032-0000.0001").get("childs")).size());
        Assert.assertEquals(3,((HashMap)childsSecondLevel.get("032-0000.0002").get("childs")).size());
    }
}