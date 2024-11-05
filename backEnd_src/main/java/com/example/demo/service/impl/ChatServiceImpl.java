package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChatMapper;
import com.example.demo.model.Chat;
import com.example.demo.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{
	@Autowired
	ChatMapper cm;

	@Override
	public List<Chat> AllChat() {		
		return cm.selectAll();
	}

	@Override
	public void addChat(Chat c) {
		cm.add(c);	
	}

	@Override
	public void updateChat(int id, String content) {
		List<Chat> l=cm.selectById(id);
		Chat c=l.get(0);
		c.setContent(content);
		
		cm.update(c);
				
	}

	@Override
	public void deleteChat(int id) {
		cm.delete(id);
		
	}	

}