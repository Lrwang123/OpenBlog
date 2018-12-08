 var isOK = true;
 
 $(document).ready(function(){
	 $("#usernameInput").blur(function(){
		 var input = $("#usernameInput");
		 var msg = $("#usernameMsg");
	 	 $.ajax({
	 		type:"post",
	 		url:"user/ajaxVerify",
	 		data:"type=loginUsername&str="+input.val(),
	 		success:function(meg){
	 			var res = JSON.parse(meg);
	 			if(true==res.valid){
	 				isOK = true;
	 				msg.hide();
	 			} else {
	 				isOK = false;
	 				msg.text("该用户名不存在！");
	 				msg.css("color","red");
	     			msg.show();
	     			};
	     		},
	     	});
	 });
	 $("#passwordInput").focus(function(){
		 $("#passwordMsg").hide();
	 });
});