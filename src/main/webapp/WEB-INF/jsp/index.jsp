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
<script src="bootstrap.js"></script>
<script src="bootstrap-paginator.js"></script>
<script>
$(document).ready(
	function() {
		var arr;
		function ajaxForData() {
			$.ajax({
				method : "Post",
				url : "/MySSH/show.action",
				async : true,
				data : "",
				dataType : 'json',
				success : function(data) {
					//alert("Data Getted:1111 " + data);
					arr = eval(data);
					var tr = '';
	                for(var index=0;index<10;index++){
	                	var str = "确定要删除此记录？";
	                    tr = "<tr><td height='40px' width='80px'>"+
	                    "<a href='Delete_delete?id="+arr[index].customer_id+"' onclick='return confirm()'>删除</a>"
	                    		+"|<a href='javascript:void(0)' onclick='update(this);'>编辑</a>"
	                    		+ "</td><td>"
	                            + arr[index].customer_id + "</td><td>"
	                            + arr[index].first_name + "</td><td>"
	                            + arr[index].last_name + "</td><td>"
	                            + arr[index].address + "</td><td>"
	                            + arr[index].email + "</td><td>"
	                            + arr[index].last_update.toString().substring(0,9) + "</td></tr>";
	                    $("#table").append(tr);
	                }
	                var sign = false;
	                var pages = Math.floor(arr.length/10);
	                var num = arr.length%10;
	                if(num!=0){
	                	sign = true;
	                	pages = pages + 1;
	                }
	                //alert(pages+" "+num+" "+arr.length+" "+arr.length/10);
					var options = {
				            bootstrapMajorVersion:3,
				            size:"normal",
				            alignment:"center",
				            currentPage: 1,
				            totalPages: pages,
				            numberOfPages:5,
				            itemTexts: function (type, page, current) {
				                switch (type) {
				                    case "first":
				                        return "首页";
				                    case "prev":
				                        return "上一页";
				                    case "next":
				                        return "下一页";
				                    case "last":
				                        return "末页";
				                    case "page":
				                        return page;
				                }
				            },
				            onPageClicked: function(e,originalEvent,type,page){
				                $("#table").empty();
				                var tr = '';
				                var temp = page*10;
				                if(sign&&page==pages){
				                	temp = temp + num;
				                }
				                for(var index=(page-1)*10;index<temp;index++){
				                	var str = "确定要删除此记录？";
				                    tr = "<tr><td height='40px' width='80px'>"
				                    +"<a href='Delete_delete?id="+arr[index].customer_id+"' onclick='return confirm()'>删除</a>" 
				                    +"|<a href='javascript:void(0)' onclick='update(this);'>编辑</a>"
				                    		+ "</td><td>"
				                    		+ arr[index].customer_id + "</td><td>"
				                            + arr[index].first_name + "</td><td>"
				                            + arr[index].last_name + "</td><td>"
				                            + arr[index].address + "</td><td>"
				                            + arr[index].email + "</td><td>"
				                            + arr[index].last_update.toString().substring(0,9) + "</td></tr>";
				                    $("#table").append(tr);
				                }
				            }
				        }
				        $('#page').bootstrapPaginator(options);
				},
				error : function(info, status, error) {
					alert('Error: ' + info.status + ' - ' + error);
				}
			});
		}
		;
		<%
		if(session.getAttribute("user")!=null){
			%>
			ajaxForData();
			<%
		}
		%>
			
		});
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
                   $("#input_fours").append(op);
               }
		},
		timeout : 800,
		error : function(info, status, error) {
			alert('Error: ' + info.status + ' - ' + error);
		}
	});
}

function update(obj){
	ajaxForAddressData();
	var tds=$(obj).parent().parent().find('td');
	$('#input_o').val(tds.eq(1).text());
	$('#input_ones').val(tds.eq(2).text());
	$('#input_twos').val(tds.eq(3).text());
	$('#input_threes').val(tds.eq(5).text());
	$('#exampleModal').modal();
}
</script>

</head>
<body>
<div>
	<div id="index_head">
		<button type="button" class="btn btn-info" id="index_head_btn" 
		 onclick="return confirm('确定要退出？')"><a href="LoginOut_loginout">Admin</a></button>
	</div>

	<div class="col-lg-2" id="index_left">
		<ul>
			<li><a href="Redirect_index"><h3>Customer管理</h3></a></li>
			<li><a href="#"><h3>Film设置</h3></a></li>
		</ul>
	</div>

	<div class="col-lg-10 table-bordered">
		<div><h1>客户管理</h1></div>
		<hr>
		<div>
			<div id="index_right_head">
				<div style="float: left; width: 20%; margin: 0px; padding: 0px;">
					<h4>客户列表</h4></div>
				<div style="float: right; width: 80%; margin: 0px; padding: 0px;">
					<a href="Redirect_add"><button type="button"
							class="btn btn-info">新建</button></a>
				</div>
			</div>
			<hr>

			<div class="row">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>操作</th>
							<th>customerId</th>
							<th>first name</th>
							<th>last name</th>
							<th>address</th>
							<th>email</th>
							<th>lastUpdate</th>
						</tr>
					</thead>
					<tbody id="table"></tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-lg-9 text-center">
					<ul id="page" class="pagination"></ul>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">基本信息</h4>
				</div>
				<div class="modal-body">
					<!--创建客户-->
					<div class="row">
						<div class="col-lg-9">
							<form class="form-horizontal col-lg-9" name="LoginForm"
								method="POST" action="Update_update">
								<div class="form-group form-group-md hide">
									<label class="col-md-2 control-label" for="input_o">CustomerId<span
										style="color: red">*</span></label>
									<div class="col-md-8 col-md-offset-2">
										<input class="form-control" type="text" id="input_o"
											name="customerId" placeholder="CustomerId">
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-md-2 control-label" for="input_ones">FirstName<span
										style="color: red">*</span></label>
									<div class="col-md-8 col-md-offset-2">
										<input class="form-control" type="text" id="input_ones"
											name="fname" placeholder="FirstName">
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-md-2 control-label" for="input_twos">LastName<span
										style="color: red">*</span></label>
									<div class="col-md-8 col-md-offset-2">
										<input class="form-control" type="text" id="input_twos"
											name="lname" placeholder="LastName">
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-md-2 control-label" for="input_threes">Email</label>
									<div class="col-md-8 col-md-offset-2">
										<input class="form-control" type="email" id="input_threes"
											name="email" placeholder="Email">
									</div>
								</div>
								<div class="form-group form-group-md">
									<label class="col-md-2 control-label" for="input_fours">Address<span
										style="color: red">*</span></label>
									<div class="col-md-8 col-md-offset-2">
										<select class="form-control input-lg" id="input_fours"
											name="addressname">
										</select>
									</div>
								</div>
								<div class="form-group form-group-md">
									<div class="col-md-10 text-center">
										<button class="btn btn-info" onclick="check()">提交</button>
										<button type="button" class="btn btn-info" data-dismiss="modal" >取消</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
    </div>
</div>


</body>
</html>