<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>试题统计</title>
<%--<link href="<%=path%>/resource/admin/css/style.css" rel="stylesheet"
	type="text/css" />
--%>
<script type="text/javascript"
	src="<%=path%>/resource/admin/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=path%>/resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript"
	src="<%=path%>/resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript"
	src="<%=path%>/resource/common/rabc_pager.js"></script>
<style type="text/css">
#div1 {
	margin-top: 15px;
}
</style>
</head>
<body>
	<div>
		<table border="1" cellspacing="0px" style="border-collapse:collapse"
			width="150px">
			<caption>总题量与总分值</caption>
			<tr>
				<th align=center width="100">题量</th>
				<th align=center width="100">分值</th>
			</tr>
			<tr>
				<td align=center width="100">${totalRows}</td>
				<td align=center width="100">${Allscore}</td>
			</tr>
		</table>
	</div>
	
<div  id="div1" class="xian "style="padding:0 200px; border-top:1px solid #ddd" ></div>
	<div id="div1">
		<table border="1" cellspacing="0px" style="border-collapse:collapse">
			<caption>难度题量与分值</caption>
			<tr>
				<th align=center width="100">难度</th>
				<th align=center width="100">题量</th>
				<th align=center width="100">分值</th>
				<th align=center width="100">题量百分比</th>
			</tr>
			<tr>
				<td align=center width="100">容易</td>
				<td align=center width="100">${easynum}</td>
				<td align=center width="100">${easyscore}</td>
				<td align=center width="100">
				<fmt:formatNumber type="number" value="${ easynum/(easynum+mediumnum+hardnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
			<tr>
				<td align=center width="100">适中</td>
				<td align=center width="100">${mediumnum}</td>
				<td align=center width="100">${mediumscore}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ mediumnum/(easynum+mediumnum+hardnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
			<tr>
				<td align=center width="100">困难</td>
				<td align=center width="100">${hardnum}</td>
				<td align=center width="100">${hardscore}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ hardnum/(easynum+mediumnum+hardnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
		</table>
	</div>
<div  id="div1" class="xian "style="padding:0 200px; border-top:1px solid #ddd" ></div>
	<div id="div1">
		<table border="1" cellspacing="0px" style="border-collapse:collapse">
			<caption>题型题量与分值</caption>
			<tr>
				<th align=center width="100">题型</th>
				<th align=center width="100">题量</th>
				<th align=center width="100">分值</th>
				<th align=center width="100">题量百分比</th>
			</tr>
			<tr>
				<td align=center w>选择题</td>
				<td align=center>${selectnum}</td>
				<td align=center>${selectsocre}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ selectnum/(selectnum+tknum+pdnum+jdnum+bcnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
			<tr>
				<td align=center width="100">填空题</td>
				<td align=center width="100">${tknum}</td>
				<td align=center width="100">${tkscore}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ tknum/(selectnum+tknum+pdnum+jdnum+bcnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
			<tr>
				<td align=center width="100">判断题</td>
				<td align=center width="100">${pdnum}</td>
				<td align=center width="100">${pdsocre}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ pdnum/(selectnum+tknum+pdnum+jdnum+bcnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
			<tr>
				<td align=center width="100">简答题</td>
				<td align=center width="100">${jdnum}</td>
				<td align=center width="100">${jdsocre}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ jdnum/(selectnum+tknum+pdnum+jdnum+bcnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
			<tr>
				<td align=center width="100">编程题</td>
				<td align=center width="100">${bcnum}</td>
				<td align=center width="100">${bcsocre}</td>
				<td align=center width="100"><fmt:formatNumber type="number" value="${ bcnum/(selectnum+tknum+pdnum+jdnum+bcnum)*100}" pattern="0.0" maxFractionDigits="1"/>%</td>
			</tr>
		</table>
	</div>


</body>
</html>
