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
		var oldPwd = document.getElementById("oldPwd").value;
		
		var userPWd = document.getElementById("userPwd").value;
		var userPWd1 = document.getElementById("userPwd1").value;
		
		if (oldPwd.length > 16 || oldPwd.length < 6)
		  {
		    alert("原密码长度应该在 6 - 16 位");
		    return false;
		  }
		if(userPWd==null||userPWd==""||input.test(userPWd)){
			alert("请输入正确密码! 注意不能包含空格！");
			
			return;
		}
		if (userPWd.length > 16 || userPWd.length < 6)
		  {
		    alert("新密码长度应该在 6 - 16 位");
		    return false;
		  }
		if(!(userPWd==userPWd1)){
			alert("两次输入的密码必须一致！");
		    return false;
		}
		document.form1.submit();
		
	}
	
</script>
    <title>添加密码</title>
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
  	<form id="form1" name="form1" method="post" action="UserInfoAction!modifyPw" >
	<input type="hidden" name="userInfo.userId" value="${userInfo.userId} ">
		
		<ul class="forminfo">
		    <li><label>用户账号</label><label>${userInfo.userId}</label></li>
		  
		    <li><label>原密码</label><input name="userInfo.oldPwd" id="oldPwd" type="password" class="dfinput" maxlength="30" /></li>
		    <li><label>新密码</label><input name="userInfo.userPwd" id="userPwd" type="password" class="dfinput" maxlength="30" /></li>
		     <li><label>确认新密码</label><input name=""                 id="userPwd1" type="password" class="dfinput" maxlength="30" /></li>
		   <li><c:if test="${newflag ==5}"><font color="red">原密码错误！</font></c:if></li>
		  <li>
		    <input  type="button" class="btn" value="提交" onclick="check();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  class="btn" onclick="history.go(-1);" value="返回" type="button"/> </li>
		    </ul>
		
	</form>
  </body>
</html>
