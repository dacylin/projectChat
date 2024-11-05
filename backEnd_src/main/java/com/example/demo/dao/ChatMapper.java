package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Chat;

@Mapper
public interface ChatMapper {
	
	@Insert("insert into chat(name,subject,content) values(#{name},#{subject},#{content})")
	void add(Chat c);
	
	@Select("select * from chat order by id desc")
	List<Chat> selectAll();
	
	@Select("select * from chat where id=#{id}")
	List<Chat> selectById(int id);
	
	@Update("update chat set content=#{content} where id=#{id}")
	void update(Chat c);
	
	@Delete("delete from chat where id=#{id}")
	void delete(int id);
	
}