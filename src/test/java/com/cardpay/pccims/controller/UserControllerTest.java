package com.cardpay.pccims.controller;

import java.io.IOException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.junit.Test;

public class UserControllerTest {
	
//	@Test
//	public void testhandle41(){
//		RestTemplate restTemplate = new RestTemplate();
//		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
//		form.add("userName", "tom");
//		form.add("password", "123456");
//		form.add("age", "45");
//		restTemplate.postForLocation("http://localhost:8080/user/handle41.html", form);
//				
//	}
//	
//	@Test
//	public void testhandle42() throws IOException {
//		RestTemplate restTemplate = new RestTemplate();
//		byte[] response = restTemplate.postForObject(
//							"http://localhost:8080/user/handle42/{imageId}.html", null, byte[].class, "123");
//		Resource outFile = new FileSystemResource("f:/ggod.jpg");
//		FileCopyUtils.copy(response, outFile.getFile());				
//	}
}