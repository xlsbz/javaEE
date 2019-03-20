<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button id="emp_add_modal_btn" class="btn btn-primary">新增</button>
				<button id="emp_delete_all_btn" class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table id="emps_table" class="table table-hover">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					<thead>
					<tBody >
					
					</tBody>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
	</div>
	
	<!-- 员工修改的模态框 -->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">员工修改</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">empName</label>
		    <div class="col-sm-10">
		      	<p class="form-control-static" id="empName_update_static"></p>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">email</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@atguigu.com">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
				</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">deptName</label>
		    <div class="col-sm-4">
		    	<!-- 部门提交部门id即可 -->
		      <select class="form-control" name="dId">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
      </div>
    </div>
  </div>
</div>



<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label class="col-sm-2 control-label">empName</label>
		    <div class="col-sm-10">
		      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">email</label>
		    <div class="col-sm-10">
		      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@atguigu.com">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">gender</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
				</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">deptName</label>
		    <div class="col-sm-4">
		    	<!-- 部门提交部门id即可 -->
		      <select class="form-control" name="dId">
		      </select>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript">
	//页面加载时发送请求
	$(function(){
		Ajax_Emplist(1);
	});
	//全局总页
	var totalRecord;
	//全局当前页
	var currentPage;
	//发送ajax请求淑君
	function Ajax_Emplist(pageNumber){
		$.ajax({
			url:"${pageContext.request.contextPath}/empAjax",
			data:"pageNumber="+pageNumber,
			type:"GET",
			success:function(result){
				/* alert(result.information.pageInfo.list[0].empName) */
				//创建表格数据
				table_data(result);
				//创建分页数据
				page_info(result);
				//创建分页导航
				page_nav(result);
			}
		});
		
	}
	
	//构建表格数据
	function table_data(result){
		//清空table表格
		$("#emps_table tbody").empty();
		var empTable = result.information.pageInfo.list;
		$.each(empTable,function(index,item){
			var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>");
			var empIdTd = $("<td></td>").append(item.empId);
			var empNameTd = $("<td></td>").append(item.empName);
			var genderTd = $("<td></td>").append(item.gender=='M'?"男":"女");
			var emailTd = $("<td></td>").append(item.email);
			var deptNameTd = $("<td></td>").append(item.dept.deptName);
			//添加到tr
			$("<tr></tr>").append(empIdTd)
			.append(empNameTd)
			.append(genderTd)
			.append(emailTd)
			.append(deptNameTd)
			.appendTo("#emps_table tbody");
			
			
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			//为编辑按钮添加一个自定义的属性，来表示当前员工id
			editBtn.attr("edit-id",item.empId);
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			//为删除按钮添加一个自定义的属性来表示当前删除的员工id
			delBtn.attr("del-id",item.empId);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			//var delBtn = 
			//append方法执行完成以后还是返回原来的元素
			$("<tr></tr>").append(checkBoxTd)
			.append(empIdTd)
			.append(empNameTd)
			.append(genderTd)
			.append(emailTd)
			.append(deptNameTd)
			.append(btnTd)
			.appendTo("#emps_table tbody");
			
		});
	}
		//解析显示分页信息
		function page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前"+result.information.pageInfo.pageNum+"页,总"+
					result.information.pageInfo.pages+"页,总"+
					result.information.pageInfo.total+"条记录");
			totalRecord = result.information.pageInfo.total;
			currentPage = result.information.pageInfo.pageNum;
		}
		
		//解析显示分页条，点击分页要能去下一页....
		function page_nav(result){
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.information.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				//首页
				firstPageLi.click(function(){
					Ajax_Emplist(1);
				});
				//上一页
				prePageLi.click(function(){
					Ajax_Emplist(result.infomation.pageInfo.pageNum -1);
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.information.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				//下一页
				nextPageLi.click(function(){
					Ajax_Emplist(result.information.pageInfo.pageNum +1);
				});
				//尾页
				lastPageLi.click(function(){
					Ajax_Emplist(result.information.pageInfo.pages);
				});
			}
			
			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.information.pageInfo.navigatepageNums,function(index,item){
				
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.information.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					Ajax_Emplist(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}

		
		
		//点击新增按钮弹出模态框。
		$("#emp_add_modal_btn").click(function(){
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
			reset_form("#empAddModal form");
			//s$("")[0].reset();
			//发送ajax请求，查出部门信息，显示在下拉列表中
			getDepts("#empAddModal select");
			//弹出模态框
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
		//清空表单样式及内容
		function reset_form(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		//查出所有的部门信息并显示在下拉列表中
		function getDepts(ele){
			//清空之前下拉列表的值
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/depts",
				type:"GET",
				success:function(result){
					//{"code":100,"msg":"处理成功！",
						//"extend":{"depts":[{"deptId":1,"deptName":"开发部"},{"deptId":2,"deptName":"测试部"}]}}
					//console.log(result);
					//显示部门信息在下拉列表中
					//$("#empAddModal select").append("")
					$.each(result.information.depts,function(){
						var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
						optionEle.appendTo(ele);
					});
				}
			});
			
		}
		
		//jquery校验
		function validation_add_form(){
			//获取到用户输入的数据
			var empName = $("#empName_add_input").val();
			var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				//alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
				show_validate_msg("#empName_add_input", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
				return false;
			}else{
				show_validate_msg("#empName_add_input", "success", "");
			};
			//校验邮箱信息
			var empEmail = $("#email_add_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,16})$/;
			if(!regEmail.test(empEmail)){
				//alert("邮箱格式不正确");
				//应该清空这个元素之前的样式
				show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
				/* $("#email_add_input").parent().addClass("has-error");
				$("#email_add_input").next("span").text("邮箱格式不正确"); */
				return false;
			}else{
				show_validate_msg("#email_add_input", "success", "");
			}
			return true;
		}
		
		//显示校验结果的提示信息
		function show_validate_msg(ele,status,msg){
			//清除当前元素的校验状态
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if("error" == status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		
		//检查用户名是否可用
		$("#empName_add_input").change(function(){
			var empName = this.value;
			//发送Ajax请求
			$.ajax({
				url:"${pageContext.request.contextPath}/checkUser",
				type:"POST",
				data:"empName="+empName,
				success:function(result){
					if(result.code==1){
						show_validate_msg("#empName_add_input","success","用户名可用");
						$("#emp_save_btn").attr("ajax-va","success");
					}else{
						show_validate_msg("#empName_add_input","error",result.information.vs_msg);
						$("#emp_save_btn").attr("ajax-va","error");
					}
				}
			});
		});
		
		
		
		//点击保存时间事件
		$("#emp_save_btn").click(function(){
		
			//1.将模态框的数据交给服务器保存
			//2.对模态框的数据进行校验
			//if(!validation_add_form()){
			//	return false;
			//};
			
			//判断用户名是否被占用
			
			if($(this).attr("ajax-va")=="error"){
				alert("用户名已占有，亲更换")
				return false;
			};
			//发送Ajax请求
			$.ajax({
				url:"${pageContext.request.contextPath}/addEmp",
				type:"POST",
				//将表单数据序列化发送到服务器
				data:$("#empAddModal form").serialize(),
				success:function(result){
					if(result.code==1){
						//数据插入成功  关闭模态框
						$("#empAddModal").modal("hide");
						//到最后一页显示刚才的数据
						//发送Ajax请求
						//不知道总页数，可以定最大，或者总记录数
						Ajax_Emplist(9999);
					}else{
						//信息添加失败
						//哪个字段信息错误就显示哪个字段的
						if(undefined != result.information.errorFields.email){
							//显示邮箱错误信息
							show_validate_msg("#email_add_input", "error", result.information.errorFields.email);
						}
						if(undefined != result.information.errorFields.empName){
							//显示员工名字的错误信息
							show_validate_msg("#empName_add_input", "error", result.information.errorFields.empName);
						}
					}
				}
			});
		});
		
		//编辑事件
		$(document).on("click",".edit_btn",function(){
			//查询出部门信息
			getDepts("#empUpdateModal select");
			//查询员工ID
			var empId = $(this).attr("edit-id");
			//ajax查询员工信息
			getEmpId(empId);
			//把员工ID给更新按钮
			$("#emp_update_btn").attr("editId",$(this).attr("edit-id"))
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		});
		//查询单个员工信息
		function getEmpId(empId){
			$.ajax({
				url:"${pageContext.request.contextPath}/getEmpId/"+empId,
				type:"POST",
				success:function(result){
					if(result.code==1){
						var empData = result.information.emp;
						$("#empName_update_static").text(empData.empName);
						$("#email_update_input").val(empData.email);
						$("#empUpdateModal input[name=gender]").val([empData.gender]);
						$("#empUpdateModal select").val([empData.dId]);
					}
				}
			});
		}
		//更新按钮事件
		$("#emp_update_btn").click(function(){
			//验证邮箱是否合法
			//1、校验邮箱信息
			var email = $("#email_update_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#email_update_input", "error", "邮箱格式不正确");
				return false;
			}else{
				show_validate_msg("#email_update_input", "success", "");
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/updateEmp/"+$(this).attr("editId"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					$("#empUpdateModal").modal("hide");
					//回到当前页
					Ajax_Emplist(currentPage);
				}
			});
		});
		
		
		//删除单个员工信息
		$(document).on("click",".delete_btn",function(){
			//弹出是否确认删除
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			//获得要删除的ID
			var empId = $(this).attr("del-id")
			if(confirm("确认删除"+empName+"吗？")){
				//发送Ajax请求
				$.ajax({
					url:"${pageContext.request.contextPath}/delEmpId/"+empId,
					type:"DELETE",
					
					success:function(result){
						alert(result.msg);
						//回到当前页
						Ajax_Emplist(currentPage);
					}
				});
				
			}
			
		});
		
		//全选
		$("#check_all").click(function(){
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		//下面选完就全选
		$(document).on("click",".check_item",function(){
			var flag = $(".check_item:checked").length == $(".check_item").length;
			$("#check_all").prop("checked",flag);
		})
		
		//批量删除
		$("#emp_delete_all_btn").click(function(){
			//拼接字符串
			var empNames = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
				
			});
			//去掉字符串最后一个符号
			empNames = empNames.substring(0,empNames.length-1);
			del_idstr = del_idstr.substring(0,del_idstr.length-1);
			if(confirm("您确认删除"+empNames+"这几个数据吗?")){
				//发送Ajax数据
				$.ajax({
					url:"${pageContext.request.contextPath}/delEmpId/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到当前页
						Ajax_Emplist(currentPage);
					}
				});
			}
		});
</script>

</html>