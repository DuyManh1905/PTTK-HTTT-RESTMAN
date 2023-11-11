<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
	margin-bottom: 50px;
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
	flex-direction: row;
	justify-content: center;
	align-items: center;
	gap: 40px;
	
	margin-bottom: 50px;
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
	
	<h1>Hóa đơn chi tiết</h1>
	
	<div>
		<div class="form-group">
	        <label for="username">ID Hóa đơn: </label>
	        <input type="input" id="username" name="username" value="${hd.id}">
	    </div>
		<div class="form-group">
	        <label for="tenkh">Tên Khách hàng: </label>
	        <input type="input" id="tenkh" name="tenkh" value="${kh.ten}">
	    </div>
	    <div class="form-group">
	        <label for="username">Tên Nhân viên bán hàng: </label>
	        <input type="input" id="username" name="username" value="${hd.nhanVienBanHang423.ten}">
	    </div>
	</div>
	
		<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>Tên món ăn</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
				<c:forEach var="hd" items="${dsmonan}">
				<tr>
					<td><c:out value="${hd.monAn423.ten}" /></td>
					<td><c:out value="${hd.soLuong}" /></td>
					<td><c:out value="${hd.monAn423.gia * hd.soLuong} " /></td>
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>

	</table>
	
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>Tên ComBo</th>
				<th>Số lượng</th>
				<th>Thành tiền</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
				<c:forEach var="hd" items="${dscombo}">
				<tr>
					<td><c:out value="${hd.combo423.ten}" /></td>
					<td><c:out value="${hd.soLuong}" /></td>
					<td><c:out value="${hd.combo423.gia * hd.soLuong} " /></td>
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>

	</table>
	
	<div class="form-group-right" style="float: right;">
	        <label for="username">Tổng cộng </label>
	        <input type="input" id="username" name="username" value="${hd.tongTien}">
	    </div>
	
	<button style="display: flex; margin-left: auto;" onclick="goBack()" class="btn btn-primary">Quay lại</button>
	<script>
		function goBack() {
   	 		window.history.back();
		}
	</script>
</body>
</html>