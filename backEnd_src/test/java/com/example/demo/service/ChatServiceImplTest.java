package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Chat;
import com.example.demo.service.impl.ChatServiceImpl;

@SpringBootTest
public class ChatServiceImplTest {
	@Autowired
	ChatServiceImpl csi;
	
	@Test
	public void AllChatTest() {
		
		List<Chat> l=csi.AllChat();
		
		for(Chat c:l)
		{
			System.out.println("Id:"+c.getId()+
					"\t Name:"+c.getName()+
					"\t Subject:"+c.getSubject()+
					"\t Context:"+c.getContent());
		}
		
	}
	
	//@Test
	public void addChatTest() {
		csi.addChat(new Chat("f","t6","t6測"));
		System.out.println("add new one success");
	}

}
