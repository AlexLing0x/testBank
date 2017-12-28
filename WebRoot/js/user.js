function toAddUserDialog(){
        	var addDialog=top.dialog({
        		title:'新增员工',
        		width:600,
        		height:1000,
        		url:'sys/user/add',
        		onclose:function(){
        		  if(this.returnValue=="success"){
        			  window.location.href=window.location.href;
        		  }
        		}
        	});
        	addDialog.showModal();
        }
function toAddSub(){
			var user_code=$.trim($("#user_code").val());
    		var account=$.trim($("#account").val());
    		var user_name=$.trim($("#user_name").val());
    		var sex=$.trim($("#sex").val());
    		var id_card=$.trim($("#id_card").val());
    		var birthday=$.trim($("#birthday").val());
    		var email=$.trim($("#email").val());
    		var bank_card=$.trim($("#bank_card").val());
    		var telphone=$.trim($("#telphone").val());
    		var province=$.trim($("#province").val());
    		var city=$.trim($("#city").val());
    		var area=$.trim($("#area").val());
    		if(user_code.length==0||user_code.length>7){
    			alert("编号位数不符合规范！");
    			$("#user_code").focus();
    			return false;
    		}
    		if(!utils.isUserCode(user_code)){
    			alert("编号格式不对！");
    			$("#user_code").focus();
    			return false;
    		}
    		if(account.length==0||account.length>20){
    			alert("账号位数不符合规范！");
    			$("#account").focus();
    			return false;
    		}
    		if(!utils.isUserAccount(account)){
    			alert("账号格式不对！");
    			$("#account").focus();
    			return false;
    		}
    		if(user_name.length==0||user_name.length>16){
    			alert("请输入规范的姓名！");
    			return false;
    		}
    		if(!utils.isZh(user_name)){
    			alert("名字只能是汉字！");
    			$("#user_name").focus();
    			return false;
    		}
    		if(sex.length==0){
    			alert("请选择性别！");
    			return false;
    		}
    		if(id_card.length==0||id_card.length>18){
    			alert("身份证号位数有误!");
    			return false;
    		}
    		if(!utils.isIDno(id_card,province)){
    			alert("身份证格式不正确或身份证与地区不匹配！");
    			return false;
    		}
    		if(email.length==0||email.length>30){
    			alert("email位数不规范！");
    			return false;
    		}
    		if(!utils.isEmail(email)){
    			alert("email格式不正确！");
    			return false;
    		}
    		if(bank_card.length==0||bank_card.length>19){
    			alert("银行卡号位数不规范！");
    			return false;
    		}
    		if(!utils.isBCNumber(bank_card)){
    			alert("银行卡号格式不正确！");
    			return false;
    		}
    		if(telphone.length==0||telphone.length>11){
    			alert("手机号位数不符合规范！");
    			return false;
    		}
    		if(!utils.checkMobile(telphone)){
    			alert("您输入的号码不符合规定！");
    			return false;
    		}
    		if(province.length==0){
    			alert("请选择省份！");
    			return false;
    		}
    		if(city.length==0){
    			alert("请选择城市！");
    			return false;
    		}
    		if(area.length==0){
    			alert("请选择区域！");
    			return false;
    		}
    		$.post("sys/user/userCode",{user_code:user_code},function(data){
    			if(data.flag=="success"){//编号不存在
    				$.post("sys/user/account",{account:account},function(data){
    	    			if(data.flag=="success"){//账号不存在
    	    				$("#userForm").submit();
    	    			}else{//账号存在
    	    				alert(data.message);
    	    				$("#account").focus();
    	    				return false;
    	    			}
    	    		});
    			}else{//编号存在
    				alert(data.message);
    				$("#user_code").focus();
    				return false;
    			}
    		});
    		
    	}
function addBirthday(){
	var id_card = $.trim($("#id_card").val());
	if(id_card.length==18){
		var year = id_card.substr(6, 4);
		var mothod = id_card.substr(10, 2);
		var day = id_card.substr(12, 2);
		
		var birthday = year+"-"+mothod+"-"+day;
		//赋值
		$("#birthday").val(birthday);
	}
	if(id_card.substr(16,1)%2!=0){
		$("#sex").empty();
		$("#sex").append("<option value='男' selected>男</option>");
	}else{
		$("#sex").empty();
		$("#sex").append("<option value='女' selected>女</option>");
	}
	
}



function toAddUpdateDialog(user_id){
        	var addDialog=top.dialog({
        		title:'更新员工',
        		width:600,
        		height:600,
        		url:'sys/user/update/'+user_id,
        		onclose:function(){
        		  if(this.returnValue=="success"){
        			  //window.location.href=window.location.href;
        			  window.location.reload(true);
        		  }
        		}
        	});
        	addDialog.showModal();
        }

function toUpdateSub(){
	var user_name=$.trim($("#user_name").val());
	var sex=$.trim($("#sex").val());
	var id_card=$.trim($("#id_card").val());
	var birthday=$.trim($("#birthday").val());
	var email=$.trim($("#email").val());
	var bank_card=$.trim($("#bank_card").val());
	var telphone=$.trim($("#telphone").val());
	var province=$.trim($("#province").val());
	var city=$.trim($("#city").val());
	var area=$.trim($("#area").val());
	if(user_name.length==0||user_name.length>16){
		alert("请输入规范的姓名！");
		return false;
	}
	if(sex.length==0){
		alert("请选择性别！");
		return false;
	}
	if(id_card.length==0||id_card.length>18){
		alert("身份证号位数有误!");
		return false;
	}
	if(!utils.isIDno(id_card,province)){
		alert("身份证格式不正确或身份证与地区不匹配！");
		return false;
	}
	if(email.length==0||email.length>30){
		alert("email位数不规范！");
		return false;
	}
	if(!utils.isEmail(email)){
		alert("email格式不正确！");
		return false;
	}
	if(bank_card.length==0||bank_card.length>19){
		alert("银行卡号位数不规范！");
		return false;
	}
	if(!utils.isBCNumber(bank_card)){
		alert("银行卡号格式不正确！");
		return false;
	}
	if(telphone.length==0||telphone.length>11){
		alert("手机号位数不符合规范！");
		return false;
	}
	if(!utils.checkMobile(telphone)){
		alert("您输入的号码不符合规定！");
		return false;
	}
	if(province.length==0){
		alert("请选择省份！");
		return false;
	}
	if(city.length==0){
		alert("请选择城市！");
		return false;
	}
	if(area.length==0){
		alert("请选择区域！");
		return false;
	}
    		
    $("#userForm").submit();
    		
 }
function toUpdatePhotoDialog(user_id){
	var addDialog=top.dialog({
        		title:'更新头像',
        		width:1000,
        		height:400,
        		url:'sys/user/photo/'+user_id,
        		onclose:function(){
        		  if(this.returnValue=="success"){
        			  //window.location.href=window.location.href;
        			  window.location.reload(true);
        		  }
        		}
        	});
        	addDialog.showModal();
        }
function toUpdatePhotoSub(){
	var docObj = document.getElementById("photo");
	var pSize = document.getElementById("preview");
	if(docObj.value.length==0){
		alert("在期待你帅气的脸庞哦！");
		return false;
	}
	if (!docObj.value.match(/.jpg|.gif|.png|.bmp/i)) {
        alert('图片格式无效！');
        document.getElementById("photo").value = "";
        return false;
    }
	if(pSize.width!=150||pSize.height!=200){
		alert("图片不符合规范！"+pSize.width);
		return false;
	}
	
      $("#photoForm").submit();
}
function setImagePreview() {

            var docObj = document.getElementById("photo");

            if (!docObj.value.match(/.jpg|.gif|.png|.bmp/i)) {
                alert('图片格式无效！');
                document.getElementById("photo").value = "";
                return false;
            }
            var imgObjPreview = document.getElementById("preview");
            if (docObj.files && docObj.files[0]) {
                // 火狐下，直接设img属性
                imgObjPreview.style.display = 'block';
                imgObjPreview.style.width = 'auto';
                imgObjPreview.style.height = 'auto';
                // imgObjPreview.src = docObj.files[0].getAsDataURL();

                // 火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
                imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);

            } else {
                // IE下，使用滤镜
                docObj.select();
                docObj.blur();
                var imgSrc = document.selection.createRange().text;
                var localImagId = document.getElementById("localImag");

                // 必须设置初始大小
                localImagId.style.width = "auto";
                localImagId.style.height = "auto";
                // 图片异常的捕捉，防止用户修改后缀来伪造图片
                try {
                    document.selection.empty();
                    localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                    localImagId.filters
                            .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                } catch (e) {
                    alert("您上传的图片格式不正确，请重新选择!");
                    return false;
                }
                imgObjPreview.style.display = 'none';
                document.selection.empty();
            }
            return true;
        }
function toUpdateRoleDialog(user_id){
	var addDialog=top.dialog({
        		title:'分配角色',
        		width:400,
        		height:400,
        		url:'sys/user/'+user_id+'/role',
        		onclose:function(){
        		  if(this.returnValue=="success"){
        			  //window.location.href=window.location.href;
        			  var online_user_id=$("#online_user_id").val();
        			  if(online_user_id==user_id){
        				  
        				  window.top.location.reload();
        			  }else{
        				  window.location.href=window.location.href;
        			  }
        			  
        		  }
        		}
        	});
        	addDialog.showModal();
        }
function toUpdateRoleSub(){
	var role_id=$("#role_id").val();
	if(role_id.length==0){
		alert("别逗我了，你要选择角色");
		return false;
	}
	$("#roleForm").submit();
}
function toFH(obj,user_id){
	var d = dialog({
		align: 'top',
		content: '<a href="javascript:void(0)" onclick="updateFH(1,'+user_id+')"><font color="#00FF00">一天</font></a>'
				+'&nbsp;|&nbsp;'
				+'<a href="javascript:void(0)" onclick="updateFH(2,'+user_id+')"><font color="#FFCCCC">二天</font></a>'
				+'&nbsp;|&nbsp;'
				+'<a href="javascript:void(0)" onclick="updateFH(3,'+user_id+')"><font color="#FF0033">三天</font></a>'
				+'&nbsp;|&nbsp;'
				+'<a href="javascript:void(0)" onclick="updateFH(10000,'+user_id+')"><font color="#CC0000">永久</font></a>'
				,
		quickClose: true// 点击空白处快速关闭	
	});
	
	d.show(obj);
}
function updateFH(day,user_id){
	$.post("sys/user/fh",{day:day,user_id:user_id},function(data){
		if(data.flag=="success"){
			window.location.href=window.location.href;
		}else{
			alert(data.message);
			return false;
		}
	});
}

/*function toDetailDialog(user_id){

	var addDialog=top.dialog({
	        		title:'详细信息',
	        		width:810,
	        		height:550,
	        		url:'sys/user/detail/'+user_id,
	        		onclose:function(){
	        		  if(this.returnValue=="success"){
	        			  //window.location.href=window.location.href;
	        			  window.location.reload(true);
	        		  }
	        		}
	        	});
	        	addDialog.showModal();

	}*/

