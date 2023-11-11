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
	
	<h1>Thống kê khách hàng theo doanh thu</h1>
	
	
	<form id="searchForm" class="tk-block" action="<%= request.getContextPath() %>/tkkh/search-by-date" method="GET">
	    <div class="form-group">
	        <label for="startDate">Ngày bắt đầu:</label>
	        <input type="date" id="startDate" name="startDate" value="${startDate}">
	    </div>
	    <div class="form-group">
	        <label for="endDate">Ngày kết thúc:</label>
	        <input type="date" id="endDate" name="endDate" value="${endDate}">
	    </div>
	    <button type="submit" class="btn btn-primary">Xem thống kê</button>
	</form>
	
	<!-- Tính tổng số tiền -->
	<c:set var="totalTongTien" value="0" />
	<c:forEach var="kh" items="${listKh}">
	    <c:set var="totalTongTien" value="${totalTongTien + kh.tongTien}" />
	</c:forEach>
	
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>ID Khách hàng</th>
				<th>Tên Khách hàng</th>
				<th>User Name</th>
				<th>Tổng số tiền</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
				<c:forEach var="kh" items="${listKh}">
				<tr>
					<td><c:out value="${kh.id}" /></td>
					<td><c:out value="${kh.ten}" /></td>
					<td><c:out value="${kh.username}" /></td>
					<td><c:out value="${kh.tongTien} (VNĐ)" /></td>
					<td><a href="<%= request.getContextPath() %>/tkkh/detail?id=<c:out value='${kh.id}' />&startDate=${startDate}&endDate=${endDate}">Xem
							chi tiết</a> 
				</tr>
			</c:forEach>
			<!-- Hiển thị tổng số tiền -->
		        <tr>
		            <td></td>
		            <td></td>
		            <td></td>
		            <td><strong>Tổng cộng: <c:out value="${totalTongTien} (VNĐ)" /></strong></td>
		            <td></td>
		        </tr>
			<!-- } -->
		</tbody>

	</table>
	<button style="display: flex; margin-left: auto;" onclick="goBack()" class="btn btn-primary">Quay lại</button>
	<script>
		function goBack() {
   	 		window.history.back();
		}
	</script>
</body>
</html>