<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>用户登录页面</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	
	<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body style="background-color: #999999;">
	<div class="text-center" style="padding-top: 130px;">
		<div style="width: 714px;margin: auto;background-color: #FFFFFF;border-radius: 40px;">
			<div style="padding: 60px;">
				<div style="width: 300px;margin: auto;">
					<img src="img/logo1.png" >
					<h3 style="margin-bottom: 20px;">NKT用户登录</h3>
					
					<!-- 表单操作 -->
					<form id="form" method="post" action="${pageContext.servletContext.contextPath}/UserServlet">
						<!-- 使用隐藏域存储method，用于指定到底调用的是Servlet中的哪个方法 -->
						<input type="hidden" name="method" value="login" />
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
								<input type="text" name="uname" id="uname" class="form-control" placeholder="请输入账号">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-eye-close"></span></span>
								<input type="password" name="upwd" id="upwd" class="form-control" placeholder="请输入密码">
							</div>
						</div>
						<div class="checkbox">
							<label>
								<input type="checkbox" name="" id="" value="" />记住我
							</label>
						</div>
						<button id="login" type="submit" class="btn btn-success" onclick="return check()">登录</button>
						<button id="reset" type="button" class="btn btn-danger" onclick="formReset()">重置</button>
					</form>
					<div class="text-center" style="padding-top:10px;">没有账号？点我<a>注册</a></div>
					
				</div>
				<div id="error" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 id="error_title">登录失败，请重试!</h4>
							</div>
						</div>
					</div>
				</div>
			</div>	
		</div>	
	</div>
	<footer class="navbar-fixed-bottom">
		<p class="text-center">&copy; 2020 南开通校园综合信息服务平台</p>
	</footer>
</body>
<script type="text/javascript">
	function check() {
		var username = document.getElementById("uname");
		var password = document.getElementById("upwd");
		if (username.value == "") {
			alert("用户名不能为空，请重新输入！");
			username.focus();
			return false;
		} else if (password.value == "") {
			alert("密码不能为空，请重新输入！");
			password.focus();
			return false;
		}
		return true;
	}
	
	function formReset() {
		document.getElementById("form").reset();
	}
</script>
</html>