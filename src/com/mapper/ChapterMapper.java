package com.mapper;

import java.util.List;

import com.pojo.Chapter;



public interface ChapterMapper {
	
	
	public List<Chapter> selALL(Chapter chapter);
	
	public void add(Chapter chapter);
	
	public void update(Chapter chapter);
	
	public void del(Integer cid);
	
	public Chapter selOne(Integer cid);

	public int getcid(String chapterNo);

	public int getOne(String chapterNo);
	
	
}
