<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<title>组卷管理</title>
<link href="<%=path%>/resource/admin/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=path%>/resource/admin/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=path%>/resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript"
	src="<%=path%>/resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript" src="<%=path%>/resource/common/rabc_pager.js"></script>
  
  <body>
  
  		<table class="tablelist">
			<thead>
				<tr align="center">
					<th style="text-align:center;">序号</th>
				    <th style="text-align:center;">试卷编号</th>
					<th style="text-align:center;">试卷名称</th>
					<th style="text-align:center;">打印时间</th>
					

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="c" varStatus="status">
					<tr>
						<td align=center>${status.count}</td>
						<td align=center>${c.paper.tpNo }</td>
						<td align=center>${c.paper.tpName }</td>
						<td align=center>${c.pTime }</td>

						
					</tr>

				</c:forEach>

			</tbody>
		</table>
  
  </body>
</html>
