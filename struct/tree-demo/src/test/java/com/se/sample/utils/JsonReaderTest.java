package com.se.sample.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonReaderTest {

    @Test
    public void process_quotation_base_should_work_correct() throws IOException {

        List<Map<String, Object>> maps = FileUtils.readListMapFromDocumentSubFolder("f100_records.json");

        Assert.assertNotNull(maps);
    }

}