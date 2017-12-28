<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户管理</title>
<link href="<%=path%>/resource/admin/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=path%>/resource/admin/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=path%>/resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript"
	src="<%=path%>/resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript"
	src="<%=path%>/resource/common/rabc_pager.js"></script>


<script type="text/javascript">
function query() {
	document.frm.submit();
}

 function check() {  
        //利用对话框返回的值 （true 或者 false）  
        if (confirm("你确定删除吗？")) {  
        	return true;
        }  
        else {  
        	return false;
        }  
  
    }  
</script>
</head>

<body>
	 
		<ul class="seachform1">
			<li style="cursor: pointer;"
				onclick="window.location='userAdd.jsp'"><span><img
					src="<%=path%>/resource/admin/images/t01.png" /> </span>添加用户</li>
		</ul>
		<table class="tablelist">
			<thead>
				<tr align="center">
					<th style="text-align:center;">序号</th>
					<th style="text-align:center;">用户账号</th>
					<th style="text-align:center;">用户姓名</th>
					<th style="text-align:center;">权限</th>
					<th style="text-align:center;">注册时间</th>
					<th style="text-align:center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="c" varStatus="status">
					<tr>
						<td align=center>${status.count}</td>
						<td align=center>${c.userId}</td>
						<td align=center>${c.userName}</td>
						<td align=center>
						<c:if test="${c.authority==0}">普通用户</c:if>
						<c:if test="${c.authority==1}">管理员</c:if>
						</td>
						<td align=center> <fmt:formatDate value="${c.registerDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>

						<td align=center><a
							href="UserInfoAction!preupdate?userInfo.userId=${c.userId }">修改</a>||<a
							href="UserInfoAction!del?userInfo.userId=${c.userId }"
							onclick="return check()">删除</a>
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>



	
</body>

</html>
