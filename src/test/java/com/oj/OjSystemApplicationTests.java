package com.oj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

@SpringBootTest
class OjSystemApplicationTests {
	@Test
	void contextLoads() {
		PrintStream oldPrintStream = System.out;
		FileOutputStream bos = null;
		try {
			bos = new FileOutputStream("output.txt");
			System.setOut(new PrintStream(bos));;
			System.setOut(oldPrintStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
