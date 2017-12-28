package com.pojo;

import java.sql.Timestamp;

public class Paper {
	private int tpid;
	private int tid;
	private String tpNo;
	private String tpName;
	private String content;
	private Timestamp generateDate;
	private String description;
	
	
	private int sid;
	private String type;
	private String title;
	private double factor;
	private double score;
	private String photo;
	private String answer;
	private String expl;
	
	private int cid;
	private String sectionNo;
	private String sectionName;
	
	private String chapterNo;
	private String chapterName;
	
	private Section section;
	private Chapter chapter;
	private Test test;
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getFactor() {
		return factor;
	}
	public void setFactor(double factor) {
		this.factor = factor;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getExpl() {
		return expl;
	}
	public void setExpl(String expl) {
		this.expl = expl;
	}
	public int getTpid() {
		return tpid;
	}
	public void setTpid(int tpid) {
		this.tpid = tpid;
	}
	public String getTpNo() {
		return tpNo;
	}
	public void setTpNo(String tpNo) {
		this.tpNo = tpNo;
	}
	public String getTpName() {
		return tpName;
	}
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(Timestamp generateDate) {
		this.generateDate = generateDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getChapterNo() {
		return chapterNo;
	}
	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	
	
	
}
