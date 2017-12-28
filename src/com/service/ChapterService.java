package com.service;

import java.util.List;

import com.pojo.Chapter;

public interface ChapterService {
	
    public List<Chapter> getAllChapter(Chapter chapter);
	
	public void addChapter(Chapter chapter);
	
	public void update(Chapter chapter);
	
	public void del(Integer cid);
	
   public Chapter getChapter(Integer cid);
   
    public int getcid(String chapterNo);

	public int getOne(String chapterNo);
}
