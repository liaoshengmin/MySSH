<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<link href="style.css" type="text/css" rel="stylesheet" />
<script src="jquery-2.1.4.min.js"></script>
<script src="bootstrap.min.js"></script>

<script>
$(document).ready(
function ajaxForAddressData() {
	$.ajax({
		method : "Post",
		url : "/MySSH/getAddress",
		async : true,
		data : "",
		dataType : 'json',
		success : function(data) {
			//alert("Data Getted: " + data);
			//arr = data;
			var op = '';
               for(var index=0;index<data.length;index++){
                   op = "<option>"+ data[index] + "</option>";
                   $("#sid").append(op);
               }
		},
		timeout : 800,
		error : function(info, status, error) {
			alert('Error: ' + info.status + ' - ' + error);
		}
	});
});

</script>

</head>
<body>
<div>
	<div id="index_head">
		<button type="button" class="btn btn-info" id="index_head_btn">Admin</button>
	</div>

	<div class="col-lg-2" id="index_left">
		<ul>
			<li><a href="Redirect_index"><h3>Customer管理</h3></a></li>
			<li><a href="#"><h3>Film设置</h3></a></li>
		</ul>
	</div>

	<div class="col-lg-10 table-bordered">
		<div>
			<h1>客户管理</h1>
		</div>
		<hr>
		<div>
			<div id="add_right_head">
				<h3>创建Customer</h3>

			</div>
			<hr>
			<div>
				<form class="form-horizontal col-lg-5"
					name="LoginForm" method="POST" action="Add_add">
					<div class="form-group form-group-md">
						<label class="col-md-2 control-label" for="input_one">FirstName<span
							style="color: red">*</span></label>
						<div class="col-md-10">
							<input class="form-control" type="text" id="input_one"
								name="fname" placeholder="FirstName">
						</div>
					</div>
					<div class="form-group form-group-md">
						<label class="col-md-2 control-label" for="input_two">LastName<span
							style="color: red">*</span></label>
						<div class="col-md-10">
							<input class="form-control" type="text" id="input_two"
								name="lname" placeholder="LastName">
						</div>
					</div>
					<div class="form-group form-group-md">
						<label class="col-md-2 control-label" for="input_three">Email</label>
						<div class="col-md-10">
							<input class="form-control" type="email" id="input_three"
								name="email" placeholder="Email">
						</div>
					</div>
					<div class="form-group form-group-md">
						<label class="col-md-2 control-label" for="input_four">Address<span
							style="color: red">*</span></label>
						<div class="col-md-10">
							<select class="form-control input-lg" id="sid"
								name="addressname">
							</select>
						</div>
					</div>
					<div class="form-group form-group-md">
						<div class="col-md-10 text-center">
							<button class="btn btn-info" onclick="check()">提交</button>
							<button type="reset" class="btn">取消</button>
						</div>
					</div>
				</form>
			</div>
			
			
		</div>
	</div>
</div>







</div>

</body>
</html>