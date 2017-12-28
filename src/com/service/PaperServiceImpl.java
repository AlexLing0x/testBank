package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.action.PageAction;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.mapper.PaperMapper;
import com.pojo.Paper;
import com.pojo.Test;

@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	private PaperMapper paperMapper;
	
	
	@Override
	public int getTotalCount(Paper paper) {
		// TODO Auto-generated method stub
		return paperMapper.selCount(paper);
	}

	@Override
	public List<Test> getAllPaper(Paper paper, int curPage) {
		// TODO Auto-generated method stub
		String sortString = "tpid.desc";
		PageBounds pageBounds = new PageBounds(curPage, PageAction.PER_PAGE, Order.formString(sortString));
		//Paginator paginator = new Paginator(curPage, PageAction.PER_PAGE, this.getTotalCount(section));
		Map<String,Object> hm = new HashMap<String,Object>();
		if(paper!=null){
			hm.put("tpName", paper.getTpName());
		}
		
		return paperMapper.selList(hm,pageBounds);
	}

	@Override
	public void autoGene(Paper paper) {
		// TODO Auto-generated method stub
		this.paperMapper.autoGene(paper);
	}

	@Override
	public void del(int tpid) {
		// TODO Auto-generated method stub
		this.paperMapper.del(tpid);
	}

	@Override
	public Paper getPaper(int tpid) {
		// TODO Auto-generated method stub
		return this.paperMapper.getPaper(tpid);
	}
}
