package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Chat;
import com.example.demo.service.ChatService;
@CrossOrigin
@RestController
@RequestMapping("ChatApi")
public class ChatApi {
	@Autowired
	ChatService cs; 
	
	@GetMapping("allChat")
	public List<Chat> getAll(){
		return cs.AllChat();
		
	}
	
	@PostMapping("addChat1")
	public String gotoAdd1(String name,String subject,String content) 
	{
		cs.addChat(new Chat(name,subject,content));	
		return "ADD1";
		
	}
	
	@PostMapping("addChat2")
	public String gotoAdd2(@RequestParam("name") String abc,
						   @RequestParam("subject") String sst,
						   @RequestParam("content") String tt)
	{
		cs.addChat(new Chat(abc,sst,tt));		
		return "ADD2";
	}
	
	@PostMapping("addChat3")
	public String gotoAdd3(@RequestParam(value="name",defaultValue="巨匠") String abc,
						   @RequestParam("subject") String sst,
						   @RequestParam("content") String tt)
	{
		cs.addChat(new Chat(abc,sst,tt));		
		return "ADD3";
	}
	
	@PostMapping("addChat")
	public String gotoAdd(@RequestBody Chat c) //ajax傳遞 json
	{
		cs.addChat(c);		
		return "ADD";
	}
	
	
	@PutMapping("update/{id}/{content}")
	public String updateChat(@PathVariable("id") int id,
			@PathVariable("content") String content)
	{
		cs.updateChat(id, content);		
		return "UPDATE";
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteChat(@PathVariable("id") int id)
	{
		cs.deleteChat(id);		
		return "DELETE";
	}
	

}
