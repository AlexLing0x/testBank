<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title> 章添加 </title>
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
		
	}
	
</script>
   	
  <body>
   <form  id="form1" name="form1" action="ChapterAction!add" method="post" >
	  
		    <ul class="forminfo">
		    <li><label>章号</label><br><select name="chapter.chapterNo" id="cCode">  
							<option value="">--请选择--</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							
						</select>
		    <li><label>章名称</label><input name="chapter.chapterName" id="name" type="text" class="dfinput" maxlength="30" placeholder="章名称"/></li>
		  <c:if test="${flag==1}">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<font color="red">章号重复！请重新添加！</font></c:if>
		    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <input  type="button" class="btn" value="确认保存" onclick="check()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  class="btn" onclick="history.go(-1);" value="返回" type="button"/> </li>
		    </ul>
	
    </form>

  </body>
 
</html>
