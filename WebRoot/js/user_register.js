$(document).ready(function(){
	var usernameValid = false;
	var nicknameValid = false;
	var passwordValid = false;
	var confirmPasswordValid = false;
	var emailValid = false;
	var phoneValid = false;
	
	$("#usernameInput").blur(function(){
		var input = $("#usernameInput");
		var msg = $("#usernameMsg");
		$.ajax({
			type:"post",
			url:"user/ajaxVerify",
			data:"type=username&str="+input.val(),
			beforeSend:function(){
				msg.css("color","black");
				msg.text("查询中");
			},
			success:function(meg){
				var res = JSON.parse(meg);
				msg.css("color",res.valid ? "green" : "red");
				msg.text(res.message);
			}
		});
	});
});
