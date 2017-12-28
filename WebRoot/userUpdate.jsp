<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title> 用户修改 </title>
    <link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path %>/resource/admin/js/jquery.js"></script>
   <script type="text/javascript">
	
   function check(){
		var input  = /\s/;
		
		
		var authority = document.getElementById("authority").value;
		
		if(authority==null||authority==""){
			alert(" 请选择权限");
			
			return;
		}
		
		
		document.form1.submit();
		alert("修改成功！");
	}
	
</script>
   
    
    <title>添加用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

	


  <body>
  	<form id="form1" name="form1" method="post" action="UserInfoAction!update" >
	<input type="hidden" name="userInfo.userId" value="${userInfo.userId} ">

		
		<ul class="forminfo">
		    <li><label>用户账号</label><label>${userInfo.userId}</label></li>
		  
		    <li><label>用户姓名</label><input name="userInfo.userName" value="${userInfo.userName}"id="userId" type="text" class="dfinput" maxlength="30" /></li>
		    <li><label>权限</label><select name="userInfo.authority" id="authority" class="select_show">  
							<option value="">--请选择--</option>
							<option value="1"<s:if test="userInfo.authority==1">selected</s:if>>管理员</option>
							<option value="0"<s:if test="userInfo.authority==0">selected</s:if>>普通用户</option>
						</select></li>
		  <li>
		    <input  type="button" class="btn" value="提交" onclick="check();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  class="btn" onclick="history.go(-1);" value="返回" type="button"/> </li>
		    </ul>
		
	</form>
  </body>
</html>
