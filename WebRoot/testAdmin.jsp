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
<title>试题管理</title>
<link href="<%=path%>/resource/admin/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=path%>/resource/admin/js/jquery.js"></script>
<link rel="stylesheet"
	href="<%=path%>/resource/admin/artDialog/css/ui-dialog.css">
<script language="JavaScript"
	src="<%=path%>/resource/admin/artDialog/dist/dialog-plus.js"></script>
<script type="text/javascript" src="<%=path%>/resource/common/rabc_pager.js"></script>


<script type="text/javascript">

$(function(){
	  $('#click_event').click(function(){
	    if($('#hidden_enent').is(':hidden')){
	      $('#hidden_enent').show();
	    
	    }
	    else{
	      $('#hidden_enent').hide();
	     
	    }
	  })
	})
	
	
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
 
 function selSection(){
		var chapterNo = $('#cCode').val();
		var url = "pointAction!getSection";
		//清除section下拉框
		var obj=$('#sCode')[0];
		obj.options.length=1;			
		
		$.post(url,{chapterNo:chapterNo},function(result){
			//遍历查询到的section
			 var dataObj=eval("("+result+")");
			$.each(dataObj.list,function(index,data){
				obj.options.add(new Option("第"+data.sectionNo+"节 "+data.sectionName,data.sectionNo));	
			})
			
			
		});
	}
</script>
<style type="text/css">  
.tablelist {  
    table-layout: fixed;   
}  

.tablelist tr td {  
    text-overflow: ellipsis; /* for IE */  
    -moz-text-overflow: ellipsis; /* for Firefox,mozilla */  
    overflow: hidden;  
    white-space: nowrap; 
     word-break: break-all; 
   
   
}  </style>
</head>

<body>

	<div class="tools">
		<form action="testAction!list" method="post" id="searchForm" name="frm">
			<ul class="seachform">

				<li><label>所属章</label> <select name="test.chapterNo"
					id="cCode" class="select_show" onchange="selSection()">
						<option value="">--请选择--</option>
						<c:forEach items="${chapterlist }" var="c">
							<option value="${c.chapterNo}"
							>第${c.chapterNo}章
								${c.chapterName}
								</option>
						</c:forEach>
				</select>
				<li><label>所属节</label> <select name="test.sectionNo"
					id="sCode" class="select_show">
						<option value="">--请选择--</option>
						<c:forEach items="${sectionlist }" var="s">
							<option value="${s.sectionNo}"
								>第${s.sectionNo}节
								${s.sectionName}</option>
						</c:forEach>
				</select><%--
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<li><label>知识点名称 </label><input name="test.point.pointName"
					value="${test.point.pointName}" type="text" class="scinput" />
					<div class="myauto"></div></li>
					--%><li><label>题目 </label><input name="test.title"
					 type="text" class="scinput" />
					<div class="myauto"></div></li>
				<li><label>&nbsp;</label><input name="" type="button"
					class="scbtn" value="查询" onclick="query();" /></li>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<li><label>&nbsp;</label><input name="" type="button"
					class="scbtn" value="刷新" onclick="query();" /></li>
				<li><input type="hidden" name="curPage" value="${curPage}" />
				</li>
			</ul>
	 </form><%--
        
         <ul class="seachform1">
        <li style="cursor: pointer;" onclick=""><span><img 
        src="<%=path %>/resource/admin/images/t01.png" /></span>批量添加</li>
        </ul>
        --%><ul class="seachform1">
        <li style="cursor: pointer;" onclick="location.href='testAction!preAdd'"><span><img 
        src="<%=path %>/resource/admin/images/t01.png" /></span>添加题目</li>
        </ul>
        
       
			
	</div>

	<table class="tablelist" width="100%">
		<thead>
			<tr align="center">
				<th style="text-align:center;" width="3%">序号</th>
				<th style="text-align:center;"width="50%">试题题目</th>
				<th style="text-align:center;"width="5%">类型</th>
				<th style="text-align:center;"width="4%">分数</th>
				<th style="text-align:center;"width="4%">难度</th>
				<th style="text-align:center;"width="8%">所属章节</th>
				<th style="text-align:center;"width="10%">操作</th>
				

			</tr>
		</thead>
		<tbody>
	
		
			<c:forEach items="${list}" var="t" varStatus="status">
			
				<tr>
					<td align=center>${status.count}</td>
					<%--<td align=center>${t.tid} </td>
					--%><td width="100px">${t.title}</td>
					<td align=center> 
					<c:if test="${t.type==1}">选择题</c:if>
					<c:if test="${t.type==2}">填空题</c:if>
					<c:if test="${t.type==3}">判断题</c:if>
					<c:if test="${t.type==4}">简答题</c:if>
					<c:if test="${t.type==5}">编程题</c:if>
					</td>
					<td align=center>${t.score }</td>
					<td align=center>
					<c:if test="${t.factor==1}">易</c:if>
					<c:if test="${t.factor==2}">中</c:if>
					<c:if test="${t.factor==3}">难</c:if>
					</td>
					<td align=center>第${t.chapter.chapterNo }章 
					第${t.section.sectionNo }节 
					</td>
					<td align=center>
					  <a href="testAction!preUpdate?test.tid=${t.tid }"> 详情&修改</a>  ||  <a
						href="testAction!del?test.tid=${t.tid}" onclick="return check()">删除</a></td>
						
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
