<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>章节管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/resource/admin/css/style.css" rel="stylesheet" type="text/css"/>
  </head>
  
  <body>
    <div style="float:left;" >
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="" type="button" class="scbtn" value="章管理" onclick=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input name="" type="button" class="scbtn" value="节管理" onclick=""/>
    </div>
    
     
  </body>
</html>
