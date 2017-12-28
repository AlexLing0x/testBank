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
<title>节管理</title>
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
 <c:if test="${flag>0}">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<font color="red">节管理关联此章，请先删除节！</font></c:if>
	<div class="tools">
		<form action="sectionAction!list" method="post" id="searchForm" name="frm">
			<ul class="seachform">
			
				<li><label>章号</label> 
				<select name="section.chapterNo" class="select_show" id="chapterNo">
						<option value="">--请选择--</option>
						
						<c:forEach items="${chapterlist}" var="cl">
							
							<option value="${cl.chapterNo}" >第${cl.chapterNo}章 ${cl.chapterName}</option>
							</c:forEach></select></li>
			

				<li><label>节名称 </label><input name="section.sectionName" id="sectionName" 
					 type="text" class="scinput" />
					<div class="myauto"></div></li>
	<li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询" onclick="query();"/></li>
	<%--<li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="清空" onclick="reset();"/></li>
	--%><li><input type="hidden" name="curPage" value="${curPage}"/></li>
	</ul>
	 </form>
        
        <ul class="seachform1">
        <li style="cursor: pointer;" onclick="location.href='sectionAction!preAdd'"><span><img 
        src="<%=path %>/resource/admin/images/t01.png" /></span>添加节</li>
        </ul>
			
	</div>

	<table class="tablelist">
		<thead>
			<tr align="center">
				<th style="text-align:center;">序号</th>
				<%--<th style="text-align:center;">sid</th>
				--%><th style="text-align:center;">节号</th>
				<th style="text-align:center;">节名称</th>
				<th style="text-align:center;">所属章</th>
				<th style="text-align:center;">操作</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="s" varStatus="status">
				<tr>
					<td align=center>${status.count}</td>
					<%--<td align=center>${s.sid}</td>
					--%><td align=center>第${s.sectionNo}节</td>
					<td>${s.sectionName }</td>
					<td >第${s.chapter.chapterNo}章&nbsp;&nbsp;${s.chapter.chapterName}</td>

					<td align=center><a
						href="sectionAction!preUpdate?section.sid=${s.sid }">修改</a>||<a
						href="sectionAction!del?section.sid=${s.sid }"
						onclick="return check()">删除</a></td>
				</tr>

			</c:forEach>

		</tbody>
	</table>

<div class="pagin">
		<div class="message" >共<i class="blue">${totalPage}</i>页，总<i class="blue">${totalRows}</i>条记录，当前是第<i class="blue">${curPage}</i>页&nbsp;&nbsp;</div>
		<ul class="paginList">
		<li class="paginItem"> <a href="javascript:goPage(1)">首页</a>&nbsp;</li>
		
		
		<li class="paginItem"><s:if test="curPage>1"><a href="javascript:prePage()">上一页</a></s:if><s:else>上一页</s:else>&nbsp;
		</li>
		
		<li class="paginItem"><s:if test="curPage<totalPage"><a href="javascript:nextPage()">下一页</a></s:if>
		<s:else>下一页</s:else>&nbsp;</li>	
		
		<li class="paginItem"><a href="javascript:goPage(${totalPage})">末页</a></li>
		  </ul>
	</div>
	
	

</body>

</html>
