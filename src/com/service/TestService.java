package com.service;

import java.util.List;

import com.pojo.Test;

public interface TestService {

	int getTotalCount(Test test);

	List<Test> getAllTest(Test test, int curPage);

	void addTest(Test test);

	Test getTest(int tid);

	void updateTest(Test test);

	void delTest(int tid);

	Integer countAllScore();

	Integer Easynum(String string);

	Double easyscore(String string);

	Integer mediumnum(String string);

	Double mediumscore(String string);

	Integer hardnum(String string);

	Double hardscore(String string);

	Integer selectnum(String string);

	Double selectsocre(String string);

	Integer tknum(String string);

	Double tkscore(String string);

	Integer pdnum(String string);

	Double pdsocre(String string);

	Integer jdnum(String string);
	
	Double jdsocre(String string);

	Double bcsocre(String string);

	Integer bcnum(String string);

	//List<Test> getTitle(String[] check_val);

	List<Test> getSelect(List<String> cNoList);

	List<Test> getBlank(List<String> cNoList);

	List<Test> getJudge(List<String> cNoList);

	List<Test> getShortQ(List<String> cNoList);

	List<Test> getCodeQ(List<String> cNoList);

	int getSectionfordel(int sid);

	

	

	

	

	

	

}
