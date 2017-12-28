<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>JAVA WEB 试题库</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
    <script>
    function logout(){
		location.href = 'LoginAction!logOut';
	}
    //权限的判断
    function check(){
    	if(${user1.authority==0}){
    		alert("无权限！");
    		return false;
    	}
    }
   
   
    </script> 
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />JAVA WEB 试题库</h1>
  </div>
  <div class="head-l" style="float:right;text-align:right;" > 
      <a>欢迎您：${user.userId}</a> &nbsp; &nbsp;&nbsp;  <a class="button button-little bg-red" href="#" onClick="javaScript:logout();"><span class="icon-power-off"></span> 退出登录</a>
      &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
       </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>课程管理</h2>
    <ul style="display:block"><%--
        <li><a href="welcome.jsp" target="right"><span class="icon-caret-right"></span>课程信息</a></li>
        --%><li><a href="ChapterAction!list" target="right"><span class="icon-caret-right"></span>章管理</a></li>
         <li><a href="sectionAction!list" target="right"><span class="icon-caret-right"></span>节管理</a></li>
        <%--<li><a href="pointAction!list" target="right"><span class="icon-caret-right"></span>知识点管理</a></li>
    --%></ul>

    <h2><span class="icon-pencil-square-o"></span>题库管理</h2>
    <ul>
        <li><a href="testAction!list" target="right"><span class="icon-caret-right"></span>试题管理</a></li>
        <li><a href="testAction!count" target="right"><span class="icon-caret-right"></span>试题统计</a></li>
    </ul>

    <h2><span class="icon-pencil-square-o"></span>试卷管理</h2>
    <ul>
        <li><a href="paperAction!list" target="right"><span class="icon-caret-right"></span>组卷管理</a></li>
        <li><a href="printAction!list" target="right"><span class="icon-caret-right"></span>打印记录</a></li>

    </ul>

    <h2><span class="icon-pencil-square-o"></span>系统管理</h2>
    <ul>
        <li > <a  href="UserInfoAction!list" onclick="return check()" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
        <li><a href="UserInfoAction!preModifyPw?userInfo.userId=${user.userId }" target="right"><span class="icon-caret-right"></span>密码修改</a></li>
       
    </ul>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread"><%--
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  --%><li><a href="##" id="a_leader_txt"></a></li>

</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
</div>

</body>
</html>