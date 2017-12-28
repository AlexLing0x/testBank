<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>试卷预览</title>
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
	
	document.frm.curPage.value = 1;
	document.frm.submit();
}

function reset() {
	document.getElementById("chapterNo").value="";
	document.getElementById("sectionName").value="";
	document.frm.curPage.value = 1;
	document.frm.submit();
}

//跳转到Page页
function goPage(page){
	document.frm.curPage.value=page;
	document.frm.submit();
}

//上一页
function prePage(){
	document.frm.curPage.value = parseInt(document.frm.curPage.value)-1;
	document.frm.submit();
}

//下一页
function nextPage(){
	document.frm.curPage.value = parseInt(document.frm.curPage.value)+1;
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

	<div class="tools">
		<input type="button" class="scbtn"
			onclick="JavaScript:window.location.href='createWord.action'"
			value="生成Word" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" class="scbtn"
			onclick="history.go(-1);" value="返回"
			value="返回" />
	</div>
	
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>
	<br>
	<div>
		<table>
			<tr>
				<td>试卷编号：${paper.tpNo }</td>
			</tr>
			<tr>
				<td>试卷名称：${paper.tpName }</td>
			</tr>
			<tr>
				<td>组卷日期：<fmt:formatDate value="${paper.generateDate }"pattern="yyyy-MM-dd hh:mm:ss" /></td>
			</tr>
			<tr>
				<td>描述：${paper.description}</td>
			</tr>
		</table>
	</div>
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>
	<br>

	<div>
		<span style="font-weight: bold">选择题:</span>
		<c:forEach items="${list}" var="s" varStatus="status" begin="0"
			end="19" step="1">
			<c:set var="string1" value="${s.title}" />
			<c:set value="${fn:split(string1, '~')}" var="str1" />
				
				${status.count}.<c:forEach items="${str1}" var="s">${s} <br>
			</c:forEach>
			<br>
		</c:forEach>
	</div>
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>
	<br>

	<div>
		<span style="font-weight: bold">填空题:</span>
		<c:forEach items="${list}" var="s" varStatus="status" begin="20"
			end="29" step="1">
				${status.count}.${s.title}<br>
		</c:forEach>
	</div>
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>
	<br>

	<div>
		<span style="font-weight: bold">判断题:</span>
		<c:forEach items="${list}" var="s" varStatus="status" begin="30"
			end="39" step="1">
				${status.count}.${s.title}<br>
		</c:forEach>
	</div>
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>
	<br>


	<div>
		<span style="font-weight: bold">简答题:</span>
		<c:forEach items="${list}" var="s" varStatus="status" begin="40"
			end="43" step="1">
				${status.count}.${s.title}<br>
		</c:forEach>
	</div>
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>
	<br>

	<div>
		<span style="font-weight: bold">编程题:</span>
		<c:forEach items="${list}" var="s" varStatus="status" begin="44"
			end="44" step="1">
				${status.count}.${s.title}<br>
		</c:forEach>
	</div>
	<div id="div1" class="xian "
		style="padding:0 200px; border-top:1px solid #ddd"></div>

</body>

</html>
