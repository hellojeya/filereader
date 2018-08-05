package com.test.reader;

import java.util.Arrays;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class CRRDataLine {
	
	@JacksonXmlProperty(isAttribute = true)
    private String tableName;
	
	@JacksonXmlProperty(localName = "CRRField")
	@JacksonXmlElementWrapper(useWrapping = false)
	private CRRField[] crrField;
    
	
	public CRRDataLine() {}
	
  
    public CRRDataLine(String tableName, CRRField[] crrField) {
		super();
		this.tableName = tableName;
		this.crrField = crrField;
	}


	public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

	public CRRField[] getCrrField() {
		return crrField;
	}

	public void setCrrField(CRRField[] crrField) {
		this.crrField = crrField;
	}

	@Override
	public String toString() {
		return "CRRDataLine [tableName=" + tableName + ", crrField=" + Arrays.toString(crrField) + "]";
	}
   
   
	
}