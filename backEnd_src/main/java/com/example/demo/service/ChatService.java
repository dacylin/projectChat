package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Chat;

public interface ChatService {
	
	List<Chat> AllChat();
	
	void addChat(Chat c);
	
	void updateChat(int id,String content);
	
	void deleteChat(int id);
	
}