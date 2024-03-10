package com.se.sample.formatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryResultFormatter {


    private static final Logger logger = LogManager.getLogger(QueryResultFormatter.class);


    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount) {
        if (nLevelCount <= 0)
            return null;

        Map<String, Object> root = new HashMap<>();

        logger.info("---------------------------------------------");

        // перебираем все записи
        for (Map<String, Object> record : aAllRecords) {


        }

        // TODO: stub
        return  new ArrayList<>();
    }

}
