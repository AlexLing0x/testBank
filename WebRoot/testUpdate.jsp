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
<title>试题查看修改</title>
<link href="<%=path%>/resource/admin/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=path%>/resource/admin/js/jquery.js"></script>



</head>
<script type="text/javascript">
	function selSection() {
		var chapterNo = $('#cCode').val();
		var url = "pointAction!getSection";
		//清除point下拉框
		var obj = $('#sCode')[0];
		obj.options.length = 1;

		$.post(url, {
			chapterNo : chapterNo
		}, function(result) {
			//遍历查询到的
			var dataObj = eval("(" + result + ")");
			$.each(dataObj.list, function(index, data) {
				obj.options.add(new Option("第" + data.sectionNo + "节 "
						+ data.sectionName, data.sectionNo));
			})

		});
	}
	function selPoint() {
		var chapterNo = $('#cCode').val();
		var sectionNo = $('#sCode').val();
		var url = "testAction!getPoint";
		//清除section下拉框
		var obj = $('#selectL')[0];
		obj.options.length = 1;

		$.post(url, {chapterNo:chapterNo,
			sectionNo : sectionNo
		}, function(result) {
			//遍历查询到的
			var dataObj = eval("(" + result + ")");
			$.each(dataObj.list, function(index, data) {
				obj.options.add(new Option(data.pointNo + " "
						+ data.pointName, data.pointNo));
			})

		});
	}
	
	$(function(){
	    var leftSel = $("#selectL");
		var rightSel = $("#selectR");
		$("#toright").bind("click",function(){		
			leftSel.find("option:selected").each(function(){
				$(this).remove().appendTo(rightSel);
			});
		});
		$("#toleft").bind("click",function(){		
			rightSel.find("option:selected").each(function(){
				$(this).remove().appendTo(leftSel);
			});
		});
		leftSel.dblclick(function(){
			$(this).find("option:selected").each(function(){
				$(this).remove().appendTo(rightSel);
			});
		});
		rightSel.dblclick(function(){
			$(this).find("option:selected").each(function(){
				$(this).remove().appendTo(leftSel);
			});
		});
		$("#sub").click(function(){
			var selVal = [];
			rightSel.find("option").each(function(){
				selVal.push(this.value);
			});
			selVals = selVal.join(",");
			//selVals = rightSel.val();
			if(selVals==""){
				alert("没有选择任何项！");
			}else{
				alert(selVals);
			}
		});
	});
</script>
<script type="text/javascript">
function sel(){
	var traget=document.getElementById("mydiv");  
	var select = document.getElementById("select").value;
	if(select=="1"){
        traget.style.display="block";  
    }else{  
        traget.style.display="none";  
  }  
	
}
	function check() {
		var input = /\s$/;
		var parnt =/^[1-9]\d*(\.\d+)?$/;
		var sCode = document.getElementById("sCode").value;
		var name = document.getElementById("name").value;
		var cCode = document.getElementById("cCode").value;
		 var num = document.getElementById("num").value;
		 var factor = document.getElementById("factor").value;
		 var photo = document.form1.photo.value;
		 var select = document.getElementById("select").value;
		
		if (name == null || name == "" ) {
			alert("请输入题目! 注意末尾不能包含空格！");

			return;
		}
		 if (select == null || select == "") {
				alert(" 请选择题型");
				return;
			}
		
		 if (!parnt.exec(num)) {
				alert(" 请输入正确分值");
				return;
			}
	    if (factor == null || factor == "") {
			alert(" 请选择难度系数");
			return;
		}
	    
		if (cCode == null || cCode == "") {
			alert(" 请选择章");
			return;
		}

		if (sCode == null || sCode == "") {
			alert(" 请选择节");
			return;
		}
		var reg = /(.jpg)|(.bmp)|(.png)$/;
		if(!(photo==null||photo=="")){
			if(!reg.test(photo.toLowerCase())){
					alert("请上传正确格式的图片!");
					return;
			}
			}
		document.form1.submit();
		alert("添加成功！");
	}
</script>

<body>
<br>
	<form id="form1" name="form1" action="testAction!update" method="post" enctype="multipart/form-data">
	<input type="hidden" name="test.tid" value="${test.tid}">
		<ul class="forminfo">
		<li><label>题型</label><select name="test.type" id="select"
				class="select_show" onchange="javascript:sel();">
					<option value="">--请选择--</option>
					<option value="1" <c:if test="${test.type== 1}">selected</c:if>>选择题</option>
					<option value="2"<c:if test="${test.type== 2}">selected</c:if>>填空题</option>
					<option value="3"<c:if test="${test.type== 3}">selected</c:if>>判断题</option>
					<option value="4"<c:if test="${test.type== 4}">selected</c:if>>简答题</option>
					<option value="5"<c:if test="${test.type== 5}">selected</c:if>>编程题</option>
			</select></li>
			<li><label>题目</label>	
				<textarea name="test.title"  id="name" rows="10" cols="100"  style="border:solid 1px"
					>${test.title}</textarea>
			</li>
			<div id="mydiv" <c:if test="${test.type!= 1}">style="display:none"</c:if> >
			<li><label>A</label><textarea  name="A" id="A" rows="2" cols="100"  style="border:solid 1px">${A}</textarea></li>
			<li><label>B</label><textarea  name="B" id="B" rows="2" cols="100"  style="border:solid 1px">${B}</textarea></li>
			<li><label>C</label><textarea  name="C" id="C" rows="2" cols="100"  style="border:solid 1px">${C}</textarea></li>
			<li><label>D</label><textarea name="D" id="D" rows="2" cols="100"  style="border:solid 1px">${D}</textarea></li>
			</div>
			<li><label>分数</label><input name="test.score" value="${test.score }"type="text"
				class="dfinput"  id="num"/>
			</li>
			<li><label>难度</label><select name="test.factor" id="factor"
				class="select_show">
					<option value="">--请选择--</option>
					<option value="1"<c:if test="${test.factor== 1}">selected</c:if>>易</option>
					<option value="2"<c:if test="${test.factor== 2}">selected</c:if>>中</option>
					<option value="3"<c:if test="${test.factor== 3}">selected</c:if>>难</option>
				
			</select>
			</li>


			<li><label>所属章</label><br>
			<select name="test.chapterNo" id="cCode" class="select_show"
				onchange="selSection()">
					<option value="">--请选择--</option>
					<c:forEach items="${chapterlist }" var="c">
						<option value="${c.chapterNo}"<c:if test="${test.chapter.cid==c.cid }">selected</c:if>>第${c.chapterNo}章
							${c.chapterName}</option>
					</c:forEach>
			</select>
			<li><label>所属节</label><br>
			<select name="test.sectionNo" id="sCode" class="select_show"
			>
					<option value="">--请选择--</option>
					<c:forEach items="${sectionlist }" var="c">
						<option value="${c.sectionNo}"<c:if test="${test.section.sid==c.sid }">selected</c:if>>第${c.sectionNo}节
							${c.sectionName}</option>
					</c:forEach>
			</select>
				<br>
				<li><c:if test="${test.photo!=null}">
						<img src="<%=path %>/${test.photo}"/>			
				</c:if>
				
				</li>	
				<li><label>图片</label><input name="photo" type="file"/>
				<font color="red">*请上传BMP,JPG,PNG格式的图片</font>	</li>
				<li><label>答案</label>
			<textarea name="test.answer" id="" rows="10" cols="100"  style="border:solid 1px"
					>${test.answer}</textarea><font color="">非必填项</font>
			</li>
				<li><label>解析</label>
			<textarea name="test.expl" id="" rows="10" cols="100"  style="border:solid 1px"
					>${test.expl}</textarea><font color="">非必填项</font>
			</li>
			<br>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="btn" value="确认修改" onclick="check()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn" onclick="history.go(-1);" value="返回"
				type="button" /></li>
		</ul>

	</form>

</body>

</html>
