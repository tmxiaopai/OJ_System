package com.oj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootTest
class OjSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	@RequestMapping("/faq")
	public String faq(){
		return "ordinaryHome/faq";
	}

}
