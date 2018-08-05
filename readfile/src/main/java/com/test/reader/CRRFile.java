package com.test.reader;

import java.util.Arrays;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "CRRFile")
public final class CRRFile {
	@JacksonXmlProperty(localName = "CRRDataLine")
    @JacksonXmlElementWrapper(useWrapping = false)
	private CRRDataLine[] crrDataLine;
    
	public CRRFile() {}
	public CRRFile(CRRDataLine[] crrDataLine) {
		super();
		this.crrDataLine = crrDataLine;
	}

	public CRRDataLine[] getCrrDataLine() {
		return crrDataLine;
	}

	public void setCrrDataLine(CRRDataLine[] crrDataLine) {
		this.crrDataLine = crrDataLine;
	}
	
	@Override
	public String toString() {
		return "CRRFile [crrDataLine=" + Arrays.toString(crrDataLine) + "]";
	}
	
}
