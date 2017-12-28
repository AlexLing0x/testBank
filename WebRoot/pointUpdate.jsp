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
    <title> 知识点修改</title>
    <link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path %>/resource/admin/js/jquery.js"></script>
   
  
   
  </head>
  <script type="text/javascript">
		function selSection(){
			var chapterNo = $('#cCode').val();
			var url = "pointAction!getSection";
			//清除section下拉框
			var obj=$('#sCode')[0];
			obj.options.length=1;			
			
			$.post(url,{chapterNo:chapterNo},function(result){
				//遍历查询到的
				 var dataObj=eval("("+result+")");
				$.each(dataObj.list,function(index,data){
					obj.options.add(new Option("第"+data.sectionNo+"节 "+data.sectionName,data.sectionNo));	
				})
				
				
			});
		}
	</script>
     <script type="text/javascript">
	
	function check(){
		var input  = /\s$/;
		var sCode = document.getElementById("sCode").value;
		var name = document.getElementById("name").value;
		var cCode = document.getElementById("cCode").value;
		var pCode = document.getElementById("pCode").value;

		

		if(pCode==null||pCode==""){
			alert(" 请选择知识点号");
			return;
		}
		if(name==null||name==""||input.test(name)){
			alert("请输入正确名称! 注意末尾不能包含空格！");
			
			return;
		}
		
		if(cCode==null||cCode==""){
			alert(" 请选择章");
			return;
		}
	
		if(sCode==null||sCode==""){
			alert(" 请选择节");
			return;
		}
		
		document.form1.submit();
		alert("修改成功！");
	}
	
</script>
   	
  <body>
   <form  id="form1" name="form1" action="pointAction!update" method="post" >
	  
		    <ul class="forminfo">
		    <li><label>知识点号</label><br><select name="point.pointNo" id="pCode" class="select_show">  
							<option value="">--请选择--</option>
							<c:forEach var="x" begin="1" end="20" step="1">
							<option value="${x}"<c:if test="${point.pointNo== x}">selected</c:if>>${x}</option>
							</c:forEach>
						</select>
		    <li><label>知识点名称</label><input name="point.pointName" value=" ${point.pointName}" id="name" type="text" class="dfinput" maxlength="30" placeholder="知识点名称"/></li>
		    
		    
		      <li><label>所属章</label><br><select name="point.chapterNo" id="cCode" class="select_show"
		      onchange="selSection()">  
							<%--<option value="">--请选择--</option>
							--%><c:forEach items="${chapterlist }" var="c">
							<option value="${c.chapterNo}"<c:if test="${point.chapter.cid==c.cid }">selected</c:if>>第${c.chapterNo}章 ${c.chapterName}</option>
							</c:forEach>
						</select>
						
					<li><label>所属节</label><br><select name="point.sectionNo" id="sCode" class="select_show"><%--  
							<option value="">--请选择--</option>
							--%><c:forEach items="${sectionlist }" var="s">
							<option value="${s.sectionNo}"<c:if test="${point.section.sid==s.sid }">selected</c:if>>第${s.sectionNo}节 ${s.sectionName}</option>
							</c:forEach>
						</select>
		   <br><br>
		    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <input  type="button" class="btn" value="确认修改" onclick="check()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  class="btn" onclick="history.go(-1);" value="返回" type="button"/> </li>
		    </ul>
	
    </form>

  </body>
 
</html>
