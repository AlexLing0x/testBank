package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.action.PageAction;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mapper.TestMapper;
import com.pojo.Test;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	@Resource
	private ChapterService chapterService;
	@Resource
	private SectionService sectionService;
	
	
	@Override
	public int getTotalCount(Test test) {
		// TODO Auto-generated method stub
		return testMapper.selCount(test);
	}

	@Override
	public List<Test> getAllTest(Test test, int curPage) {
		// TODO Auto-generated method stub
		String sortString = "tid.desc";
		PageBounds pageBounds = new PageBounds(curPage, PageAction.PER_PAGE, Order.formString(sortString));
		//Paginator paginator = new Paginator(curPage, PageAction.PER_PAGE, this.getTotalCount(section));
		Map<String,Object> hm = new HashMap<String,Object>();
		if(test!=null){
			hm.put("chapterNo", test.getChapterNo());
			hm.put("sectionNo", test.getSectionNo());
			hm.put("title", test.getTitle());
		}
		
		return testMapper.selList(hm,pageBounds);
	}

	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		test.setSid(sectionService.getsid(test.getChapterNo(),test.getSectionNo()));
		testMapper.addtest(test);
	}

	@Override
	public Test getTest(int tid) {
		// TODO Auto-generated method stub
		return testMapper.selOne(tid);
	}

	@Override
	public void updateTest(Test test) {
		// TODO Auto-generated method stub
		test.setSid(sectionService.getsid(test.getChapterNo(),test.getSectionNo()));
		this.testMapper.updateTest(test);
	}

	@Override
	public void delTest(int tid) {
		// TODO Auto-generated method stub
		this.testMapper.del(tid);
	}

	@Override
	public Integer countAllScore() {
		// TODO Auto-generated method stub
		return this.testMapper.countAllScore();
	}

	@Override
	public Integer Easynum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.Easynum(string);
	}

	@Override
	public Double easyscore(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.easyscore(string);
	}

	@Override
	public Integer mediumnum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.mediumnum(string);
	}

	@Override
	public Double mediumscore(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.mediumscore(string);
	}

	@Override
	public Integer hardnum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.hardnum(string);
	}

	@Override
	public Double hardscore(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.hardscore(string);
	}


	@Override
	public Integer selectnum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.selectnum(string);
	}

	@Override
	public Double selectsocre(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.selectsocre(string);
	}

	@Override
	public Integer tknum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.tknum(string);
	}

	@Override
	public Double tkscore(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.tkscore(string);
	}

	@Override
	public Integer pdnum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.pdnum(string);
	}

	@Override
	public Double pdsocre(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.pdsocre(string);
	}

	@Override
	public Integer jdnum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.jdnum(string);
	}

	@Override
	public Double jdsocre(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.jdsocre(string);
	}

	@Override
	public Double bcsocre(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.bcsocre(string);
	}

	@Override
	public Integer bcnum(String string) {
		// TODO Auto-generated method stub
		return this.testMapper.bcnum(string);
	}

	@Override
	public List<Test> getSelect(List<String> cNoList) {
		// TODO Auto-generated method stub
		return testMapper.getSelect(cNoList);
	}

	@Override
	public List<Test> getBlank(List<String> cNoList) {
		// TODO Auto-generated method stub
		return testMapper.getBlank(cNoList);
	}

	@Override
	public List<Test> getJudge(List<String> cNoList) {
		// TODO Auto-generated method stub
		return testMapper.getJudge(cNoList);
	}

	@Override
	public List<Test> getShortQ(List<String> cNoList) {
		// TODO Auto-generated method stub
		return testMapper.getShortQ(cNoList);
	}

	@Override
	public List<Test> getCodeQ(List<String> cNoList) {
		// TODO Auto-generated method stub
		return testMapper.getCodeQ(cNoList);
	}

	@Override
	public int getSectionfordel(int sid) {
		// TODO Auto-generated method stub
		return this.testMapper.getSectionfordel(sid);
	}


	

}
