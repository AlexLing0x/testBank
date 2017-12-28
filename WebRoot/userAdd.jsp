<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
    <title> 用户添加 </title>
    <link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path %>/resource/admin/js/jquery.js"></script>
   
   <script type="text/javascript">
	
	function check(){
		var input  = /\s/;
		var userId = document.getElementById("userId").value;
		var userPWd = document.getElementById("userPwd").value;
		var userPWd1 = document.getElementById("userPwd1").value;
		var authority = document.getElementById("authority").value;
		if(userId==null||userId==""||input.test(userId)){
			alert("请输入正确名称! 注意不能包含空格！");
			
			return;
		}
		
		if(userPWd==null||userPWd==""||input.test(userPWd)){
			alert("请输入正确密码! 注意不能包含空格！");
			
			return;
		}
		if (userPWd.length > 16 || userPWd.length < 6)
		  {
		    alert("密码长度应该在 6 - 16 位");
		    return false;
		  }
		if(!(userPWd==userPWd1)){
			alert("两次输入的密码必须一致！");
		    return false;
		}
		if(authority==null||authority==""){
			alert(" 请选择权限");
			
			return;
		}
		
		
		document.form1.submit();	
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

	
	<form id="form1" name="form1" method="post" action="UserInfoAction!add" >
		
	

      <ul class="forminfo">
		    <li><label>用户账号</label><input name="userInfo.userId" id="userId" type="text" class="dfinput" maxlength="30" /><c:if test="${flag>0}"><font color="red">此用户已存在</font></c:if></li>
		    <li><label>用户密码</label><input name="userInfo.userPwd" id="userPwd" type="password" class="dfinput" maxlength="30" /></li>
		    <li><label>确认密码</label><input name=""                 id="userPwd1" type="password" class="dfinput" maxlength="30" /></li>
		    <li><label>用户姓名</label><input name="userInfo.userName" id="userId" type="text" class="dfinput" maxlength="30" /></li>
		    <li><label>权限</label><select name="userInfo.authority" id="authority" class="select_show">  
							<option value="">--请选择--</option>
							<option value="1">管理员</option>
							<option value="0">普通用户</option>
						</select></li>
		  <li>
		    <input  type="button" class="btn" value="提交" onclick="check();"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <input  class="btn" onclick="history.go(-1);" value="返回" type="button"/> </li>
		    </ul>
</form>
  <body>
  
  </body>
</html>
