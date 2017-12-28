package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.action.PageAction;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mapper.SectionMapper;
import com.pojo.Section;
import com.pojo.Test;

@Service
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	private SectionMapper sectionMapper;
	
	@Resource
	private ChapterService chapterService;

	@Override
	public List<Section> getAllSection(Section section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Section> getAllSection(Section section, int curPage) {
		// TODO Auto-generated method stub
		
		String sortString = "sid.desc";
		PageBounds pageBounds = new PageBounds(curPage, PageAction.PER_PAGE, Order.formString(sortString));
		//Paginator paginator = new Paginator(curPage, PageAction.PER_PAGE, this.getTotalCount(section));
		Map<String,Object> hm = new HashMap<String,Object>();
		if(section!=null){
			hm.put("chapterNo", section.getChapterNo());
			hm.put("sectionName", section.getSectionName());
		}
		
		return sectionMapper.selList(hm,pageBounds);
	}

	@Override
	public int getTotalCount(Section section) {
		// TODO Auto-generated method stub
		return sectionMapper.selCount(section);
	}

	@Override
	public void addSection(Section section) {
		// TODO Auto-generated method stub
		section.setCid(chapterService.getcid(section.getChapterNo()));
		this.sectionMapper.add(section);
	}

	public ChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(ChapterService chapterService) {
		this.chapterService = chapterService;
	}

	@Override
	public Section getSection(int sid) {
		// TODO Auto-generated method stub
		return sectionMapper.selOne(sid);
	}

	@Override
	public void updateSection(Section section) {
		// TODO Auto-generated method stub
		section.setCid(chapterService.getcid(section.getChapterNo()));
		this.sectionMapper.update(section);
	}

	@Override
	public void delSection(int sid) {
		// TODO Auto-generated method stub
		this.sectionMapper.del(sid);
	}

	@Override
	public List<Section> getSection(String chapterNo) {
		// TODO Auto-generated method stub
		return sectionMapper.selSection(chapterNo);
	}

	@Override
	public int getsid(String chapterNo, String sectionNo) {
		// TODO Auto-generated method stub
		return sectionMapper.getsid(chapterNo,sectionNo);
	}

	@Override
	public int getOne(String chapterNo, String sectionNo) {
		// TODO Auto-generated method stub
		return sectionMapper.getOne(chapterNo,sectionNo);
	}

	@Override
	public int getOneforUpdate(String chapterNo, String sectionNo,
			String oriSectionNo) {
		// TODO Auto-generated method stub
		return sectionMapper.getOneforUpdate(chapterNo,sectionNo,oriSectionNo);
	}

	@Override
	public int getChapter(int cid) {
		// TODO Auto-generated method stub
		return sectionMapper.getChapter(cid);
	}

	
	

}
