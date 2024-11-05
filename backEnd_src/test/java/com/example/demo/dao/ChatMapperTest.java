package com.example.demo.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Chat;

@SpringBootTest
public class ChatMapperTest {
	@Autowired
	ChatMapper cm;
	
	//@Test
	public void addTest()
	{
		cm.add(new Chat("abc","test1","test2"));
		System.out.println("success");
	}
	
	@Test
	public void selectAllTest() {
		List<Chat> l=cm.selectAll();
		
		for( Chat c:l) 
		{
			System.out.println("Id:"+c.getId()+
					"\t Name:"+c.getName()+
					"\t 主題:"+c.getSubject()+
					"\t 內容:"+c.getContent());
		}
		System.out.println("select success");
	}
	
}
