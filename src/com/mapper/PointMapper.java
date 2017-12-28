package com.mapper;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.pojo.Point;
import com.pojo.Section;

public interface PointMapper {

	List<Section> selList(Map<String, Object> hm, PageBounds pageBounds);

	int selCount(Point point);

	void add(Point point);

	Point selOne(int kpid);

	void update(Point point);

	void del(int kpid);

	List<Point> selAll(Point point);

	List<Point> getPoints(String chapterNo, String sectionNo);

}
