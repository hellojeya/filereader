package com.test.reader;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CRRField {
	
	@JacksonXmlProperty(isAttribute = true)
    private String fieldName;
	@JacksonXmlProperty(isAttribute = true)
    private int startPos;
	@JacksonXmlProperty(isAttribute = true)
    private int endPos;
    
    public CRRField() {
    }
    public CRRField(String fieldName, int startPos, int endPos) {
        this.fieldName = fieldName;
        this.startPos = startPos;
        this.endPos = endPos;
    }
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getEndPos() {
		return endPos;
	}
	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}
	@Override
	public String toString() {
		return "CRRField [fieldName=" + fieldName + ", startPos=" + startPos + ", endPos=" + endPos
				+ ", getFieldName()=" + getFieldName() + ", getStartPos()=" + getStartPos() + ", getEndPos()="
				+ getEndPos() + "]";
	}
   
}
