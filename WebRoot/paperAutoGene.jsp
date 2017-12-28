<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
<title>自动组卷</title>
<link href="<%=path%>/resource/admin/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=path%>/resource/admin/js/jquery.js"></script>
</head>

<script type="text/javascript">
	function check() {
		var input = /\s$/;
		var name = document.getElementById("tpname").value;
		if (name == null || name == "" ) {
			alert("请输入试题名称!");
			return;
		}
		document.form1.submit();
		alert("组卷成功！");
	}
</script>

<body>
	<br> 
	<form id="form1" name="form1" action="paperAction!autoGene"
		method="post">

		<ul class="forminfo">

			<li><label>输入试卷名称</label><input name="paper.tpName" type="text"
				class="dfinput" id="tpname" /></li>

			

			<span>选择出卷的章节</span>
			<c:forEach items="${chapterlist }" var="c">
				<input type="checkbox" value="${c.chapterNo}" name="paper.chapterNo"
					checked="checked">第${c.chapterNo}章 ${c.chapterName} <br>
			</c:forEach>
			<br>
			<li><label>描述</label> <textarea name="paper.description" id=""
					rows="10" cols="100" style="border:solid 1px"></textarea><font
				color="">非必填项</font></li>
			<%--<button type="submit" value="提交">Submit</button>
	--%><br>
			<li><input type="button" class="btn" value="确认保存"
				onclick="check()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn" onclick="history.go(-1);" value="返回"
				type="button" />
			</li>
		</ul>

	</form>

</body>

</html>
