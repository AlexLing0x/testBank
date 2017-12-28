package com.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pojo.Test;
import com.pojo.Chapter;
import com.pojo.Point;
import com.pojo.Section;
import com.service.ChapterService;
import com.service.PointService;
import com.service.SectionService;
import com.service.TestService;



@Controller
public class TestAction extends PageAction {
	
	private Test test;
	
    private File photo;
	
	private String fileName;
	
	private String filePath = "upload";
	
	private String newFileName;
	
	@Resource
	private TestService testService;
    @Resource
	private SectionService sectionService;
	@Resource
	private ChapterService chapterService;
	@Resource
	private PointService pointService;
	private String chapterNo;
	private String sectionNo;
	 

		public String list(){
			
			HttpServletRequest req = ServletActionContext.getRequest();
			
			List<Chapter> chapterlist = chapterService.getAllChapter(null);
			req.setAttribute("chapterlist", chapterlist);

			List<Section> sectionlist = sectionService.getAllSection(null);
			req.setAttribute("sectionlist", sectionlist);
			
			
			
			this.init(testService.getTotalCount(test));
			
			List<Test> list = testService.getAllTest(test, this.getCurPage());
			
			req.setAttribute("list", list);
			
			return "list";
			
		}
	 
	public String preAdd(){
		HttpServletRequest req = ServletActionContext.getRequest();
		
		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		req.setAttribute("chapterlist", chapterlist);

		List<Section> sectionlist = sectionService.getAllSection(null);
		req.setAttribute("sectionlist", sectionlist);
			
		return "add";
	}
	 
	/**
	 * 新增
	 * @return
	 */
	public String add(){
		HttpServletRequest req = ServletActionContext.getRequest();
		String A = req.getParameter("A");
		String B = req.getParameter("B");
		String C = req.getParameter("C");
		String D = req.getParameter("D");
		if(test.getType().equals("1")){
			String title=test.getTitle();
			String newTitle=title+"~A."+A+"~B."+B+"~C."+C+"~D."+D;
		    test.setTitle(newTitle);
		}
		try{
			if(upload()){//上传成功
				//把文件名赋值
				this.test.setPhoto(filePath + "\\" + newFileName);
			}
			
			testService.addTest(test);
			//重置test对象
			test = new Test();
			
		}catch(Exception fe){
			fe.printStackTrace();
		}
		
		return list();
	}
	
	 public String preUpdate(){
		 HttpServletRequest req1 = ServletActionContext.getRequest();
			test = testService.getTest(test.getTid());
			if(test.getType().equals("1")){
				String[] selectArray = test.getTitle().split("~");
				test.setTitle(selectArray[0]);
				String A = selectArray[1];
				String B = selectArray[2];
				String C = selectArray[3];
				String D = selectArray[4];
				A=A.substring(2);
				B=B.substring(2);
				C=C.substring(2);
				D=D.substring(2);
				req1.setAttribute("A", A);
				req1.setAttribute("B", B);
				req1.setAttribute("C", C);
				req1.setAttribute("D", D);
				
			}
	
			List<Chapter> chapterlist = chapterService.getAllChapter(null);
			req1.setAttribute("chapterlist", chapterlist);
			
			List<Section> sectionlist = sectionService.getAllSection(null);
			req1.setAttribute("sectionlist", sectionlist);

			
			return "update";
		
	    }
	 public String update(){
		 HttpServletRequest req = ServletActionContext.getRequest();
			String A = req.getParameter("A");
			String B = req.getParameter("B");
			String C = req.getParameter("C");
			String D = req.getParameter("D");
			if(test.getType().equals("1")){
				String title=test.getTitle();
				String newTitle=title+"~A."+A+"~B."+B+"~C."+C+"~D."+D;
			    test.setTitle(newTitle);
			}
			try{
				if(upload()){//上传成功
					//把文件名赋值
					this.test.setPhoto(filePath + "\\" + newFileName);
				}
				
				testService.updateTest(test);
				//重置test对象
				test = new Test();
				
			}catch(Exception fe){
				fe.printStackTrace();
			}
			
			return list();
		}
	  public String del(){
		    
	    	 testService.delTest(test.getTid());
	    	 test = new Test();
			return list();
		
	    }
	 //统计
	  public String count(){
		  HttpServletRequest req = ServletActionContext.getRequest();
		  this.init(testService.getTotalCount(null));
		  
		   Integer Allscore =testService.countAllScore();
		   req.setAttribute("Allscore", Allscore);
		   
		   
		   Integer easynum =testService.Easynum("1");
		   Double easyscore =testService.easyscore("1");
		   
		   Integer mediumnum =testService.mediumnum("2");
		   Double mediumscore =testService.mediumscore("2");
		   
		   Integer hardnum =testService.hardnum("3");
		   Double hardscore =testService.hardscore("3");
		   
		   req.setAttribute("easynum", easynum);
		   req.setAttribute("easyscore", easyscore);
		   req.setAttribute("mediumnum", mediumnum);
		   req.setAttribute("mediumscore", mediumscore);
		   req.setAttribute("hardnum", hardnum);
		   req.setAttribute("hardscore", hardscore);
		   
		   Integer selectnum =testService.selectnum("1");
		   Double selectsocre =testService.selectsocre("1");
		   
		   Integer tknum =testService.tknum("2");
		   Double tkscore =testService.tkscore("2");
		   
		   Integer pdnum =testService.pdnum("3");
		   Double pdsocre =testService.pdsocre("3");
		   
		   Integer jdnum =testService.jdnum("4");
		   Double jdsocre =testService.jdsocre("4");
		   
		   Integer bcnum =testService.bcnum("5");
		   Double bcsocre =testService.bcsocre("5");
		   
		   req.setAttribute("selectnum", selectnum);
		   req.setAttribute("selectsocre", selectsocre);
		   
		   req.setAttribute("tknum", tknum);
		   req.setAttribute("tkscore", tkscore);
		   
		   req.setAttribute("pdnum", pdnum);
		   req.setAttribute("pdsocre", pdsocre);
		   
		   req.setAttribute("jdnum", jdnum);
		   req.setAttribute("jdsocre", jdsocre);
		   
		   req.setAttribute("bcnum", bcnum);
		   req.setAttribute("bcsocre", bcsocre);
		  return "count";
	  }
	  
	  
	/**
	 * 处理上传文件
	 * 
	 * @return 上传成功:true  失败:false
	 */
	public boolean upload(){
		
		boolean flag = true;
		//如果上传文件
		if(photo == null) return false;
		String path = ServletActionContext.getServletContext().getRealPath(filePath);
		String ext = fileName.substring(fileName.lastIndexOf("."));
		long time = new Date().getTime();
		newFileName = time + ext;
		//构造新的文件名
		File destFile = new File(path+"\\"+newFileName);
		try {
			FileUtils.copyFile(photo, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}

	
	

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public void setPhotoFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
	
	
	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public SectionService getSectionService() {
		return sectionService;
	}

	public void setSectionService(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	public ChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(ChapterService chapterService) {
		this.chapterService = chapterService;
	}

	public PointService getPointService() {
		return pointService;
	}

	public void setPointService(PointService pointService) {
		this.pointService = pointService;
	}

	public String getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}

	public String getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}

	

	 
	 
	 
}
