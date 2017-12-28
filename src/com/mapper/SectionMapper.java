package com.mapper;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.pojo.Section;

public interface SectionMapper {

	public List<Section> selList(Map<String, Object> hm, PageBounds pageBounds);

	public int selCount(Section section);

	public void add(Section section);

	public Section selOne(int sid);

	public void update(Section section);

	public void del(int sid);

	public List<Section> selSection(String chapterNo);

	public int getsid(String chapterNo, String sectionNo);

	public int getOne(String chapterNo, String sectionNo);

	public int getOneforUpdate(String chapterNo, String sectionNo,
			String oriSectionNo);

	public int getChapter(int cid);
	
	

}
