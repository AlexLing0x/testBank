package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pojo.Chapter;
import com.pojo.Point;
import com.pojo.Section;
import com.service.ChapterService;
import com.service.PointService;
import com.service.SectionService;

@SuppressWarnings("serial")
@Controller
public class PointAction extends PageAction {

	private Point point;
	@Resource
	private PointService pointService;
	@Resource
	private SectionService sectionService;
	@Resource
	private ChapterService chapterService;

	private String chapterNo;

	public String list() {

		HttpServletRequest req = ServletActionContext.getRequest();
		
		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		req.setAttribute("chapterlist", chapterlist);

		List<Section> sectionlist = sectionService.getAllSection(null);
		req.setAttribute("sectionlist", sectionlist);
		
		this.init(pointService.getTotalCount(point));

		List<Section> list = pointService.getAllPoint(point,this.getCurPage());

		req.setAttribute("list", list);

		return "list";

	}

	public String preAdd() {
		HttpServletRequest req = ServletActionContext.getRequest();

		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		req.setAttribute("chapterlist", chapterlist);

		List<Section> sectionlist = sectionService.getAllSection(null);
		req.setAttribute("sectionlist", sectionlist);

		return "add";
	}
	
	
	public String add(){
		
		pointService.addPoint(point);
	
		point = new Point();
	
		return list();
		
	}
	
	
 public String preUpdate(){
    	
		point = pointService.getPoint(point.getKpid());
		
		
		
		HttpServletRequest req = ServletActionContext.getRequest();

		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		req.setAttribute("chapterlist", chapterlist);

		List<Section> sectionlist = sectionService.getAllSection(null);
		req.setAttribute("sectionlist", sectionlist);

		
		
		return "update";
	
    }
	

 public String update(){
	 
	 pointService.updatePoint(point);
	 point = new Point();
	return list();

}

 public String del(){
     point = pointService.getPoint(point.getKpid());
	 pointService.delPoint(point.getKpid());
	 point = new Point();
	return list();

}
	
	

	public void getSection() throws IOException {
		Map<String, List<Section>> map = new HashMap<String, List<Section>>();
		List<Section> list = this.querySection();
		map.put("list", list);
		JSONObject js = JSONObject.fromObject(map);
		// 打印调试
		System.out.println(js);

		HttpServletResponse res = ServletActionContext.getResponse();
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = res.getWriter();
		pw.write(js.toString());
		pw.flush();
		pw.close();

	}

	public List<Section> querySection() {
		// TODO Auto-generated method stub
		List<Section> list = sectionService.getSection(chapterNo);
		// 以下是打印调试
		Section s = null;
		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			System.out.println(s.getSectionName() + s.getSectionNo());
		}

		return list;
	}

	public String getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
