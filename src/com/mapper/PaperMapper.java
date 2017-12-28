package com.mapper;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.pojo.Paper;
import com.pojo.Test;

public interface PaperMapper {

	int selCount(Paper paper);

	List<Test> selList(Map<String, Object> hm, PageBounds pageBounds);

	void autoGene(Paper paper);

	void del(int tpid);

	Paper getPaper(int tpid);

}
