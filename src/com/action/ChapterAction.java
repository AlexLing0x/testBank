package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Chapter;
import com.pojo.UserInfo;
import com.service.ChapterService;
import com.service.SectionService;

@Controller
public class ChapterAction extends ActionSupport {
	
	private Chapter chapter;
	
	@Resource
	private ChapterService chapterService;
	@Resource
	private SectionService sectionService;
	//��ȡȫ������
		public String list(){
			
			List<Chapter> list = chapterService.getAllChapter(chapter);
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("list", list);
			return "list";
		}


		//�����
		public String add(){
			int flag = 0;
			flag = chapterService.getOne(chapter.getChapterNo());
			if(flag==0){
			chapterService.addChapter(chapter);
			chapter = new Chapter();
			return list();
			}else{
				HttpServletRequest req = ServletActionContext.getRequest();
				req.setAttribute("flag", flag);
				return "add";
			}
			
		}
		
		//Ԥ�޸���
		public String preupdate(){
			
			chapter = chapterService.getChapter(chapter.getCid());

			return "update";
		}
		
		//�޸���
		public String update(){
			
			chapterService.update(chapter);
			chapter = new Chapter();
			return list();
		}
		
		//ɾ����
		public String del(){
			int flag = sectionService.getChapter(chapter.getCid());
			if(flag==0){
				chapterService.del(chapter.getCid());
				chapter = new Chapter();
				return list();
			}else{
				HttpServletRequest req = ServletActionContext.getRequest();
				req.setAttribute("flag", flag);
				return list();
			}
			
		}
		
		
		public Chapter getChapter() {
			return chapter;
		}

		public void setChapter(Chapter chapter) {
			this.chapter = chapter;
		}

		public ChapterService getChapterService() {
			return chapterService;
		}

		public void setChapterService(ChapterService chapterService) {
			this.chapterService = chapterService;
		}
		
		
		
		
}
