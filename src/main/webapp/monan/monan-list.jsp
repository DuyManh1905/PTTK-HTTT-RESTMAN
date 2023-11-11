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
		h1 {
		    margin-top: 20px;
		    display: flex;
		    align-items: center;
		    justify-content: center;
		    margin-bottom: 100px;
		}
		
		table {
			width: 90% !important;
			margin: auto;
		}
		
		.row {
			justify-content: center;
		}
	</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="<%=request.getContextPath()%>/home" class="navbar-brand">
					Rest Man </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/home"
					class="nav-link">Khách hàng</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<h1>Tìm kiếm món ăn</h1>
	<div class="row">
		<div class="col-md-6">
			<form action="<%= request.getContextPath() %>/search" method="GET">
				<div class="form-group">
					<input type="text" class="form-control" name="ten"
						placeholder="Nhập tên món ăn">
				</div>
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-primary">Tìm kiếm</button>
		</div>
		</form>
	</div>

	<br>
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>Tên</th>
				<th>Giá</th>
				<th>Đơn vị</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
			<c:forEach var="monan" items="${listMonAn}">

				<tr>
					<td><c:out value="${monan.id}" /></td>
					<td><c:out value="${monan.ten}" /></td>
					<td><c:out value="${monan.gia}  (VNĐ)" /></td>
					<td><c:out value="${monan.donVi}" /></td>
					<td><a href="detail?id=<c:out value='${monan.id}' />">Xem
							chi tiết</a> &nbsp;&nbsp;&nbsp;&nbsp;
				</tr>
			</c:forEach>
			<!-- } -->
		</tbody>

	</table>
	</div>
	</div>
	<button style="display: flex; margin-left: auto;" onclick="goBack()" class="btn btn-primary">Quay lại</button>
	<script>
		function goBack() {
   	 		window.history.back();
		}
	</script>
</body>
</html>