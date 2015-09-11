//$(document).ready(function(){
//	$.ajax({
//		url:"show.action",  //后台处理程序  
//		type:"post",    //数据发送方式  
//		async:false,
//		dataType:"json",   //接受数据格式 
//		error:function(){
//			alert("服务器没有返回数据，可能服务器忙，请重试");},
//		success:function(json){
//			var listArray = eval(json).titlelist;
//			for(var i=0;i<listArray.length;i++){
//				$("#index_right_info").append(
//						"<div class='col-md-1'>"+listArray[i].first_name+"</div>"+
//						"<div class='col-md-1'>"+listArray[i].last_name+"</div>"+
//						"<div class='col-md-3'>"+listArray[i].address+"</div>"+
//						"<div class='col-md-3'>"+listArray[i].email+"</div>"+
//						"<div class='col-md-1'>"+listArray[i].customer_id+"</div>"+
//						"<div class='col-md-2'>"+listArray[i].last_update+"</div>");}  
//			}
//		});
//});  
      


