$(document).ready(function(){
	//异步评论
	function() {
		$.ajax({
			type:"post",
			url:"blog/addMessage",
			data:"blogId="+$("blogId").val()+"&text="+$("text").val(),
			success:function(meg){
				//评论成功后局部刷新
				if ("success" == meg) {
					
				} else {
					
				}
			
			}
		});
	}
	
	
});
