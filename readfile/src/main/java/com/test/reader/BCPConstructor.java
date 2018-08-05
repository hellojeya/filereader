package com.test.reader;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.test.reader.model.BCP;


public class BCPConstructor {

	public List<BCP> createRowForBCP(Map<String, CRRField> fieldProcessor,List<String> dataLines){
		List<BCP> bcpList = new ArrayList<>();
		BCP bcpTable = new BCP();
		Field[] fields = bcpTable.getClass().getDeclaredFields();
		
		for(String data:dataLines) {
			for(Field tableField:fields) {
				CRRField crrfield=fieldProcessor.get(tableField.getName());
				
				try {
					BeanUtils.setProperty(bcpTable, tableField.getName(), data.substring(crrfield.getStartPos(), crrfield.getEndPos()));
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			bcpList.add(bcpTable);
					
		};
		return bcpList;
	}

}
