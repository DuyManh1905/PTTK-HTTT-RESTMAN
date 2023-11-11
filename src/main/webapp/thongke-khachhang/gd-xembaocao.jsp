<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
}

h1 {
	margin-top: 20px;
	margin-bottom: 150px;
}

.button {
	display: inline-block;
	margin: 10px;
	padding: 10px 20px;
	background-color: #0074D9;
	color: #fff;
	border: none;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	cursor: pointer;
}
.tk-block {
	display: flex;
	flex-direction: column;
	gap: 40px;
}
</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="<%=request.getContextPath()%>/tkkh/tk"> Rest Man </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/tkkh/tk"
					class="nav-link">Nhân viên quản lý</a></li>
			</ul>
		</nav>
	</header>

	<h1>Xem báo cáo</h1>
	<div class="tk-block">
		<a href="<%= request.getContextPath() %>/tkkh/tkkhtdt" class="button">Thống kê khách hàng theo doanh thu</a>
		<a href="#" class="button">Chức năng X</a>
		<a href="#" class="button">Chức năng Y</a>
	</div>
	<button style="display: flex; margin-left: auto;" onclick="goBack()" class="btn btn-primary">Quay lại</button>
	<script>
		function goBack() {
   	 		window.history.back();
		}
	</script>
</body>
</html>