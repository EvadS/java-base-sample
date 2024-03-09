package com.se.sample;

public class Helper {

    public List<Map<String, Object>> getChilds(List<Map<String, Object>> aAllRecords, final String strParentID, final int nLevelCount)
    {
        if (nLevelCount == 0)
            return null;

        final List<Map<String, Object>> oResult = new LinkedList<Map<String,Object>>();
        for(final Map<String, Object> oRow : aAllRecords)
        {
            final String strID = oRow.get(m_strIDFieldName).toString();

            if (null != oRow.get("dict_" + m_strIDFieldName + "_decode") && StringUtils.isNotBlank(oRow.get("dict_" + m_strIDFieldName + "_decode").toString()))
                oRow.put(NAME_FIELD_DECODE, oRow.get("dict_" + m_strIDFieldName + "_decode"));

            if (!isItChildsRecord(strParentID, strID))
                continue;

            final List<Map<String, Object>> aChildRecord = getChilds(aAllRecords, strID, nLevelCount - 1);
            if (null != aChildRecord)
                oRow.put(CHILDS_KEY, aChildRecord);
            oResult.add(oRow);
        }

        return oResult;
    }
}
