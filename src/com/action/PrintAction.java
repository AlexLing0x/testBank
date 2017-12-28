package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Chapter;
import com.pojo.Print;
import com.service.PrintService;

@Controller
public class PrintAction extends ActionSupport{
	
	private Print print;

	@Resource
	private PrintService printService;
	//获取全部数据
			public String list(){
				
				List<Print> list = printService.getAllPrint(print);
				HttpServletRequest req = ServletActionContext.getRequest();
				req.setAttribute("list", list);
				return "list";
			}
	
	
	
	public Print getPrint() {
		return print;
	}

	public void setPrint(Print print) {
		this.print = print;
	}



	public PrintService getPrintService() {
		return printService;
	}



	public void setPrintService(PrintService printService) {
		this.printService = printService;
	}
	
	
	
	
}
