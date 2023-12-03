package kr.co.kalpa.sbtemplates.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class YmdFormatterTest {

	private YmdFormatter ymdFormatter = new YmdFormatter();
	
	@Test
	void testPrint() throws ParseException {
		String s = ymdFormatter.parse("2023-11-12", null);
		System.out.println(s);
		
		System.out.println(ymdFormatter.print("20231214",null));
	}

}
