package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chat;
import com.example.demo.service.impl.ChatServiceImpl;

@RestController
public class ChatController {
	@Autowired
	ChatServiceImpl csi;
	
	@CrossOrigin
	@GetMapping("allChat")
	public List<Chat> allChat(){
		return csi.AllChat();
	}
	
	@PostMapping("addChat")
	public String addChat(String name,String subject,String content) {
		csi.addChat(new Chat(name,subject,content));
		return "成功";
		
	}
		
}