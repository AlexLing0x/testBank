package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.ChapterMapper;
import com.pojo.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService {
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Override
	public List<Chapter> getAllChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterMapper.selALL(chapter);
	}

	@Override
	public void addChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		chapterMapper.add(chapter);
	}

	@Override
	public void update(Chapter chapter) {
		// TODO Auto-generated method stub
		chapterMapper.update(chapter);
	}

	@Override
	public void del(Integer cid) {
		// TODO Auto-generated method stub
		chapterMapper.del(cid);
	}

	@Override
	public Chapter getChapter(Integer cid) {
		// TODO Auto-generated method stub
		return chapterMapper.selOne(cid);
	}

	@Override
	public int getcid(String chapterNo) {
		// TODO Auto-generated method stub
		 int cid = chapterMapper.getcid(chapterNo);
		return cid;
	}

	@Override
	public int getOne(String chapterNo) {
		// TODO Auto-generated method stub
		return this.chapterMapper.getOne(chapterNo);
	}

}
