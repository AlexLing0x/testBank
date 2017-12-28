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
import com.mapper.PointMapper;
import com.pojo.Point;
import com.pojo.Section;
@Service
public class PointServiceImpl implements PointService {
	
	@Autowired
	private PointMapper pointMapper;
	
	@Resource
	private SectionService sectionService;
	
	@Override
	public List<Section> getAllPoint(Point point, int curPage) {
		// TODO Auto-generated method stub
		String sortString = "kpid.desc";
		PageBounds pageBounds = new PageBounds(curPage, PageAction.PER_PAGE, Order.formString(sortString));
		
		Map<String,Object> hm = new HashMap<String,Object>();
		if(point!=null){
			
			hm.put("chapterNo", point.getChapterNo());
			hm.put("sectionNo", point.getSectionNo());
			hm.put("pointName", point.getPointName());
		}
		
		return pointMapper.selList(hm,pageBounds);
	}
		

	@Override
	public int getTotalCount(Point point) {
		// TODO Auto-generated method stub
		 return pointMapper.selCount(point);
	}


	@Override
	public void addPoint(Point point) {
		// TODO Auto-generated method stub
		point.setSid(sectionService.getsid(point.getChapterNo(),point.getSectionNo()));
		this.pointMapper.add(point);
	}


	@Override
	public Point getPoint(int kpid) {
		// TODO Auto-generated method stub
		return pointMapper.selOne(kpid);
	}


	@Override
	public void updatePoint(Point point) {
		// TODO Auto-generated method stub
		point.setSid(sectionService.getsid(point.getChapterNo(),point.getSectionNo()));
		this.pointMapper.update(point);
	}


	@Override
	public void delPoint(int kpid) {
		// TODO Auto-generated method stub
		this.pointMapper.del(kpid);
	}


	@Override
	public List<Point> getAllPoint(Point point) {
		// TODO Auto-generated method stub
		return pointMapper.selAll(point);
	}


	@Override
	public List<Point> getPoints(String chapterNo,String sectionNo) {
		// TODO Auto-generated method stub
		   
		   return this.pointMapper.getPoints(chapterNo,sectionNo);
	}


	

}
