package com.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pojo.Chapter;
import com.pojo.Paper;
import com.pojo.Print;
import com.pojo.Section;
import com.pojo.Test;
import com.service.ChapterService;
import com.service.PaperService;
import com.service.PrintService;
import com.service.SectionService;
import com.service.TestService;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.lun.utils.WordUtil;

@SuppressWarnings("serial")
@Controller
public class PaperAction extends PageAction {

	public static int tpid;
	private Print print;
	private Paper paper;
	private Test test;

	@Resource
	private TestService testService;
	@Resource
	private PaperService paperService;
	@Resource
	private SectionService sectionService;
	@Resource
	private ChapterService chapterService;
	@Resource
	private PrintService printService;

	private Chapter chapterNo;

	private String filePath; // 文件路径
	private String fileName; // 文件名称
	private String fileOnlyName; // 文件唯一名称

	public String list() {

		HttpServletRequest req = ServletActionContext.getRequest();

		this.init(paperService.getTotalCount(paper));

		List<Test> list = paperService.getAllPaper(paper, this.getCurPage());

		req.setAttribute("list", list);

		return "list";

	}

	public String autoPerGene() {
		HttpServletRequest req = ServletActionContext.getRequest();

		List<Chapter> chapterlist = chapterService.getAllChapter(null);
		req.setAttribute("chapterlist", chapterlist);

		List<Section> sectionlist = sectionService.getAllSection(null);
		req.setAttribute("sectionlist", sectionlist);

		return "autoGene";
	}

	public String autoGene() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] values = request.getParameterValues("paper.chapterNo");
		StringBuffer sb = new StringBuffer();

		// 打印调试
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}

		List<String> cNoList = new ArrayList<String>();
		Collections.addAll(cNoList, values);

		// 随机抽取20道选择题
		List<Test> selectlist = testService.getSelect(cNoList);
		// 返回结果打印调试
		for (int i = 0; i < selectlist.size(); i++) {
			System.out.println(selectlist.get(i).getTid() + "QQQQQQQQQ");
			sb.append(selectlist.get(i).getTid());
			sb.append(";");
		}

		// 随机抽取10道填空题
		List<Test> blanklist = testService.getBlank(cNoList);
		for (int i = 0; i < blanklist.size(); i++) {
			sb.append(blanklist.get(i).getTid());
			sb.append(";");
		}

		// 随机抽取10道判断题
		List<Test> judgelist = testService.getJudge(cNoList);
		for (int i = 0; i < judgelist.size(); i++) {
			sb.append(judgelist.get(i).getTid());
			sb.append(";");
		}
		// 随机抽取4道简答题
		List<Test> shortQlist = testService.getShortQ(cNoList);
		for (int i = 0; i < shortQlist.size(); i++) {
			sb.append(shortQlist.get(i).getTid());
			sb.append(";");
		}
		// 随机抽取1道编程题
		List<Test> codeQlist = testService.getCodeQ(cNoList);
		for (int i = 0; i < codeQlist.size(); i++) {
			sb.append(codeQlist.get(i).getTid());
			sb.append(";");
		}

		String str = sb.toString();
		System.out.println(str);
		paper.setContent(str);

		long time = new Date().getTime();
		String tpNo = time + "";
		System.out.println(tpNo);
		paper.setTpNo(tpNo);

		paperService.autoGene(paper);

		paper = new Paper();
		return list();
	}
	//预览前准备
	public String preview() {
		List<Test> list = new ArrayList<Test>();
		HttpServletRequest request = ServletActionContext.getRequest();
		tpid = paper.getTpid();
		paper = paperService.getPaper(paper.getTpid());
		String content = paper.getContent();
		System.out.println(content);

		String[] contentArray = content.split(";");
		for (int i = 0; i < contentArray.length; i++) {
			int j = Integer.parseInt(contentArray[i]);
			System.out.println("数字" + j);

			test = testService.getTest(j);

			list.add(test);
		}
		// 打印调试
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		request.setAttribute("list", list);

		return "previewPrint";
	}
	//删除
	public String del() {
		paperService.del(paper.getTpid());
		paper = new Paper();
		return list();

	}

	/**
	 * @Desc：生成word文档
	 * @return
	 */
	public String createWord() {
		/** 用于组装word页面需要的数据 */
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<Test> list = new ArrayList<Test>();
		// 获取此试卷信息
		paper = paperService.getPaper(tpid);
		// 获取题目ID
		String content = paper.getContent();
		// 分割题目ID
		String[] contentArray = content.split(";");
		for (int i = 0; i < contentArray.length; i++) {
			int j = Integer.parseInt(contentArray[i]);
			// 获取每道题目
			test = testService.getTest(j);
			// 将每道题目加到listli里面
			list.add(test);

		}

		/** 组装数据 */
		// 试卷名称
		dataMap.put("tpName", paper.getTpName());
		for (int k = 0; k < 20; k++) {
			String[] selectArray = list.get(k).getTitle().split("~");
			
				dataMap.put("NO"+(k+1), k + 1 + "、");
				dataMap.put("title"+(k+1), selectArray[0]);
				dataMap.put("A"+(k+1), selectArray[1]);
				dataMap.put("B"+(k+1), selectArray[2]);
				dataMap.put("C"+(k+1), selectArray[3]);
				dataMap.put("D"+(k+1), selectArray[4]);
		}
		for (int k = 20; k < 30; k++) {
				dataMap.put("blank"+(k+1), list.get(k).getTitle());
				System.out.println(list.get(k).getTitle()+"55555555555555555");
		}
		for (int k = 30; k < 40; k++) {
			dataMap.put("judgee"+(k+1), list.get(k).getTitle());
			System.out.println(list.get(k).getTitle()+"666666666666");
	   }
		for (int k = 40; k < 44; k++) {
			dataMap.put("shortQ"+(k+1), list.get(k).getTitle());
			System.out.println(list.get(k).getTitle()+"7777777777777");
	   }
		for (int k = 44; k < 45; k++) {
			dataMap.put("codeQ"+(k+1), list.get(k).getTitle());
			System.out.println(list.get(k).getTitle()+"88888888888888888");
	   }

		/** 文件名称，唯一字符串 */
		Random r = new Random();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		StringBuffer sb = new StringBuffer();
		sb.append(sdf1.format(new Date()));
		sb.append("_");
		sb.append(r.nextInt(100));

		// 文件路径
		filePath = ServletActionContext.getServletContext().getRealPath("/")
				+ "upload";

		// 文件唯一名称
		fileOnlyName = paper.getTpName() + sb + ".doc";

		// 文件名称
		fileName = paper.getTpName() + ".doc";

		/** 生成word */
		WordUtil.createWord(dataMap, "gxu20033.ftl", filePath, fileOnlyName);
		
		//添加打印记录
		int newtpid =tpid;
		System.out.println(newtpid+"!!!!!!!!!!!!!!");
		print =new Print();
		print.setTpid(newtpid);
		printService.addPrint(print);
		
		return "createWordSuccess";
		
	}

	/**
	 * @Desc：下载生成的word文档，入口，用来跳转至struts XML配置
	 * @return
	 */
	public String dowloadWord() {
		/** 先判断文件是否已生成 */
		try {
			// 解决中文乱码
			filePath = URLDecoder.decode(filePath, "UTF-8");
			fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
			fileName = URLDecoder.decode(fileName, "UTF-8");

			// 如果文件不存在，则会跳入异常，然后可以进行异常处理
			new FileInputStream(filePath + File.separator + fileOnlyName);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "dowloadWord";
	}

	/**
	 * @Desc：下载生成的word文档 该方法是struts.xml文件中的： <param
	 *                   name="inputName">wordFile</param> 中自动对应的get方法，该方法自动调用
	 * @return 返回最终生成的word文档 文件流
	 */
	public InputStream getWordFile() {
		try {
			// 解决中文乱码
			fileName = URLDecoder.decode(fileName, "UTF-8");

			/** 返回最终生成的word文件流 */
			return new FileInputStream(filePath + File.separator + fileOnlyName);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getTpid() {
		return tpid;
	}

	public static void setTpid(int tpid) {
		PaperAction.tpid = tpid;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileOnlyName() {
		return fileOnlyName;
	}

	public void setFileOnlyName(String fileOnlyName) {
		this.fileOnlyName = fileOnlyName;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Chapter getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(Chapter chapterNo) {
		this.chapterNo = chapterNo;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Print getPrint() {
		return print;
	}

	public void setPrint(Print print) {
		this.print = print;
	}

}
