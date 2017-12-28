package com.service;

import java.util.List;

import com.pojo.Paper;
import com.pojo.Test;

public interface PaperService {

	int getTotalCount(Paper paper);

	List<Test> getAllPaper(Paper paper, int curPage);

	void autoGene(Paper paper);

	void del(int tpid);

	Paper getPaper(int tpid);

}
