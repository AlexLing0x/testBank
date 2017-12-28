package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Section;
import com.pojo.Test;

public interface SectionService {

	public List<Section> getAllSection(Section section);
	
	public List<Section> getAllSection(Section section,int curPage);
	
	public int getTotalCount(Section section);

	public void addSection(Section section);

	public Section getSection(int sid);

	public void updateSection(Section section);

	public void delSection(int sid);

	public List<Section> getSection(String chapterNo);

	public int getsid(String chapterNo, String sectionNo);

	public int getOne(String chapterNo, String sectionNo);

	public int getOneforUpdate(String chapterNo, String sectionNo,String oriSectionNo);

	public int getChapter(int cid);

	

	
	
}
