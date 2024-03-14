package com.se.sample.formatter;

import com.se.sample.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class QueryResultFormatterExtTreeSetTest {

    QueryResultFormatterExtTreeSet formatter = new QueryResultFormatterExtTreeSet();

    @Test
    public void formatter_should_work_correct() throws IOException {
        List<Map<String, Object>> maps = FileUtils.readListMapFromDocumentSubFolder("base_records_for_sort.json");
        List<Map<String, Object>> root = formatter.getChilds(maps, "", 5);

        Assert.assertNotNull(root);
        Assert.assertEquals(1, root.size());
        // количество дочерних для первого уровня
        Assert.assertEquals(2, ((TreeSet) root.get(0).get("childs")).size());

        // TODO: получение через кастомизацию - полный бред
    }

}