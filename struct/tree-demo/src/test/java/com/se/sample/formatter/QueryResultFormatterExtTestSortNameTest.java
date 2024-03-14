package com.se.sample.formatter;

import com.se.sample.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class QueryResultFormatterExtTestSortNameTest {

    QueryResultFormatterExtTestSortName formatter = new QueryResultFormatterExtTestSortName();


    @Test
    public void formatter_should_work_correct() throws IOException {
        List<Map<String, Object>> maps = FileUtils.readListMapFromDocumentSubFolder("base_records_for_sort.json");

        List<Map<String, Object>> root = formatter.getChilds(maps, "", 5);

        Assert.assertNotNull(root);
        Assert.assertEquals(1, root.size());
        // количество дочерних для первого уровня
        Assert.assertEquals(2, ((List)root.get(0).get("childs")).size());

        // проверяем что на втором уровне только массив без идентификаторов
        List<Map<String, Object>> childsSecondLevel = ( List<Map<String, Object>>) root.get(0).get("childs");
        Assert.assertNotNull(childsSecondLevel);

        // количество дочерних для второго уровня
        Assert.assertEquals(3, ((List)((HashMap)((List)root.get(0).get("childs")).get(0)).get("childs")).size());

        int a =0;
    }
}