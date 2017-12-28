<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title> 章修改 </title>
    <link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path %>/resource/admin/js/jquery.js"></script>
   
  
   
  </head>
  
     <script type="text/javascript">
	
	function check(){
		var input  = /\s/;
		var cCode = document.getElementById("cCode").value;
		var name = document.getElementById("name").value;

		if(cCode==null||cCode==""){
			alert(" 请选择章号");
			return;
		}
		
		if(name==null||name==""||input.test(name)){
			alert("请输入正确名称! 注意不能包含空格！");
			
			return;
		}
		
	
		
		document.form1.submit();
		alert("修改成功！");
	}
	
</script>
   	
  <body>
   <form  id="form1" name="form1" action="ChapterAction!update" method="post" >
	  <input type="hidden" name="chapter.cid" value="${chapter.cid} "/>
		    <ul class="forminfo">
		    <li><label>章号</label><label>第${chapter.chapterNo}章</label>
		    <li><label>章名称</label><input name="chapter.chapterName" value="${chapter.chapterName}" id="name" type="text" class="dfinput" maxlength="30" placeholder="章名称"/></li>
		   <br><br>
		    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <input  type="button" class="btn" value="确认修改" onclick="check()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  class="btn" onclick="history.go(-1);" value="返回" type="button"/> </li>
		    </ul>
	
    </form>

  </body>
 
</html>
