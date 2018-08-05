package com.test.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.test.reader.model.BCP;

public class FileReader {
	
	
	public static void main(String args[]) {

		String fileName = "/Users/jeyakumarnarashimman/Documents/sampledata/sample.txt";

		BCPConstructor converter = new BCPConstructor();
		

		
		ObjectMapper objectMapper = new XmlMapper();
		//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		Map<String, CRRField> crrFieldProcessor = new HashMap<>();
		CRRFile crrFile = null;
		try {
			crrFile = objectMapper.readValue(
			        StringUtils.toEncodedString(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("crr.xml").toURI())), StandardCharsets.UTF_8),
			        CRRFile.class);
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(crrFile);
        CRRDataLine[] crrDataLine=crrFile.getCrrDataLine();
        int crrDataLineCount=crrDataLine.length;
        System.out.println(crrDataLineCount);
        for(CRRDataLine dataline:crrDataLine) {
        	for(CRRField crrfield:dataline.getCrrField()) {
        		crrFieldProcessor.put(crrfield.getFieldName(), crrfield);
        	}
        }

      		try {

      			List<String> listLines = Files.readAllLines(Paths.get(fileName));
      			List<BCP> bcpList=converter.createRowForBCP(crrFieldProcessor,listLines);
      			
      			bcpList.forEach(name -> System.out.println(name));
      			

      		} catch (IOException e) {
      			e.printStackTrace();
      		}
	}

}
