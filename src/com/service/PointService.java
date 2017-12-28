package com.service;

import java.util.List;
import java.util.Map;

import com.pojo.Point;
import com.pojo.Section;

public interface PointService {

	List<Section> getAllPoint(Point point, int curPage);

	int getTotalCount(Point point);

	void addPoint(Point point);

	Point getPoint(int kpid);

	void updatePoint(Point point);

	void delPoint(int kpid);

	List<Point> getAllPoint(Point point);

	List<Point> getPoints(String chapterNo,String sectionNo);




	
	

}
