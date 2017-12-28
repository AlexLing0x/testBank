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

	private String filePath; // �ļ�·��
	private String fileName; // �ļ�����
	private String fileOnlyName; // �ļ�Ψһ����

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

		// ��ӡ����
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}

		List<String> cNoList = new ArrayList<String>();
		Collections.addAll(cNoList, values);

		// �����ȡ20��ѡ����
		List<Test> selectlist = testService.getSelect(cNoList);
		// ���ؽ����ӡ����
		for (int i = 0; i < selectlist.size(); i++) {
			System.out.println(selectlist.get(i).getTid() + "QQQQQQQQQ");
			sb.append(selectlist.get(i).getTid());
			sb.append(";");
		}

		// �����ȡ10�������
		List<Test> blanklist = testService.getBlank(cNoList);
		for (int i = 0; i < blanklist.size(); i++) {
			sb.append(blanklist.get(i).getTid());
			sb.append(";");
		}

		// �����ȡ10���ж���
		List<Test> judgelist = testService.getJudge(cNoList);
		for (int i = 0; i < judgelist.size(); i++) {
			sb.append(judgelist.get(i).getTid());
			sb.append(";");
		}
		// �����ȡ4�������
		List<Test> shortQlist = testService.getShortQ(cNoList);
		for (int i = 0; i < shortQlist.size(); i++) {
			sb.append(shortQlist.get(i).getTid());
			sb.append(";");
		}
		// �����ȡ1�������
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
	//Ԥ��ǰ׼��
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
			System.out.println("����" + j);

			test = testService.getTest(j);

			list.add(test);
		}
		// ��ӡ����
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		request.setAttribute("list", list);

		return "previewPrint";
	}
	//ɾ��
	public String del() {
		paperService.del(paper.getTpid());
		paper = new Paper();
		return list();

	}

	/**
	 * @Desc������word�ĵ�
	 * @return
	 */
	public String createWord() {
		/** ������װwordҳ����Ҫ������ */
		Map<String, Object> dataMap = new HashMap<String, Object>();

		List<Test> list = new ArrayList<Test>();
		// ��ȡ���Ծ���Ϣ
		paper = paperService.getPaper(tpid);
		// ��ȡ��ĿID
		String content = paper.getContent();
		// �ָ���ĿID
		String[] contentArray = content.split(";");
		for (int i = 0; i < contentArray.length; i++) {
			int j = Integer.parseInt(contentArray[i]);
			// ��ȡÿ����Ŀ
			test = testService.getTest(j);
			// ��ÿ����Ŀ�ӵ�listli����
			list.add(test);

		}

		/** ��װ���� */
		// �Ծ�����
		dataMap.put("tpName", paper.getTpName());
		for (int k = 0; k < 20; k++) {
			String[] selectArray = list.get(k).getTitle().split("~");
			
				dataMap.put("NO"+(k+1), k + 1 + "��");
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

		/** �ļ����ƣ�Ψһ�ַ��� */
		Random r = new Random();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		StringBuffer sb = new StringBuffer();
		sb.append(sdf1.format(new Date()));
		sb.append("_");
		sb.append(r.nextInt(100));

		// �ļ�·��
		filePath = ServletActionContext.getServletContext().getRealPath("/")
				+ "upload";

		// �ļ�Ψһ����
		fileOnlyName = paper.getTpName() + sb + ".doc";

		// �ļ�����
		fileName = paper.getTpName() + ".doc";

		/** ����word */
		WordUtil.createWord(dataMap, "gxu20033.ftl", filePath, fileOnlyName);
		
		//��Ӵ�ӡ��¼
		int newtpid =tpid;
		System.out.println(newtpid+"!!!!!!!!!!!!!!");
		print =new Print();
		print.setTpid(newtpid);
		printService.addPrint(print);
		
		return "createWordSuccess";
		
	}

	/**
	 * @Desc���������ɵ�word�ĵ�����ڣ�������ת��struts XML����
	 * @return
	 */
	public String dowloadWord() {
		/** ���ж��ļ��Ƿ������� */
		try {
			// �����������
			filePath = URLDecoder.decode(filePath, "UTF-8");
			fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
			fileName = URLDecoder.decode(fileName, "UTF-8");

			// ����ļ������ڣ���������쳣��Ȼ����Խ����쳣����
			new FileInputStream(filePath + File.separator + fileOnlyName);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "dowloadWord";
	}

	/**
	 * @Desc���������ɵ�word�ĵ� �÷�����struts.xml�ļ��еģ� <param
	 *                   name="inputName">wordFile</param> ���Զ���Ӧ��get�������÷����Զ�����
	 * @return �����������ɵ�word�ĵ� �ļ���
	 */
	public InputStream getWordFile() {
		try {
			// �����������
			fileName = URLDecoder.decode(fileName, "UTF-8");

			/** �����������ɵ�word�ļ��� */
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
