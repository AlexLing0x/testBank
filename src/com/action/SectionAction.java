package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pojo.Chapter;
import com.pojo.Section;
import com.service.ChapterService;
import com.service.SectionService;
import com.service.TestService;


@Controller
public class SectionAction extends PageAction{
	
	public static int oriSid;
	
	private Section section;
	@Resource
	private SectionService sectionService;
	@Resource
	private ChapterService chapterService;
	@Resource
	private TestService testService;
	
	
	
	public String list(){
		
		this.init(sectionService.getTotalCount(section));
		
		List<Section> list = sectionService.getAllSection(section, this.getCurPage());
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("list", list);
		
		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		HttpServletRequest req1 = ServletActionContext.getRequest();
		req1.setAttribute("chapterlist", chapterlist);
		
		return "list";
		
	}
	
	public String preAdd(){
		
		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("chapterlist", chapterlist);
		return "add";
		
	}
	
	public String add(){
		
		int flag = 0;
		flag = sectionService.getOne(section.getChapterNo(),section.getSectionNo());
		if(flag==0){
			sectionService.addSection(section);
			section = new Section();
		return list();
		}else{
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("flag", flag);
			return preAdd();
		}
		
	}
	
    public String preUpdate(){
    	
		section = sectionService.getSection(section.getSid());
		
		 oriSid=section.getSid();
		
		
		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		HttpServletRequest req1 = ServletActionContext.getRequest();
		req1.setAttribute("chapterlist", chapterlist);
		
		
		return "update";
	
    }
    
     public String update(){
    	 
    	 /*int flag = 0;
 		 flag = sectionService.getOne(section.getChapterNo(),section.getSectionNo());
 		if(flag==0){
    	 
 		}else{
 			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("flag", flag);
			return preUpdate();
 		}*/
    	 sectionService.updateSection(section);
    	 section = new Section();
		return list();
    }
	
   public String del(){
	    int flag=testService.getSectionfordel(section.getSid());
	    if(flag==0){
    	  sectionService.delSection(section.getSid());
    	  section = new Section();
		  return list();
	    }else{
	    	HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("flag", flag);
			return list();
	    }
    }

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
	
	

}
