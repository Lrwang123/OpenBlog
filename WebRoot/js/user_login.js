var isOK = true;
 
$(document).ready(function(){
	
	$("#usernameInput").blur(function(){
		var input = $("#usernameInput");
		var msg = $("#usernameMsg");
	 	$.ajax({
	 		type:"post",
	 		url:"user/loginAjaxVerify",
	 		data:"type=username&str="+input.val(),
	 		success:function(meg){
	 			if("exist"==meg){
	 				isOK = true;
	 				msg.hide();
	 			} else {
	 				isOK = false;
	 				msg.text("该用户不存在！");
	 				msg.css("color","red");
	     			msg.show();
	     		};
	 		},
	 	});
	});
	 
	$("#passwordInput").focus(function(){
		$("#passwordMsg").hide();
	});
	 
	$("#usernameInput").focus(function(){
		$("#usernameMsg").hide();
	});
});