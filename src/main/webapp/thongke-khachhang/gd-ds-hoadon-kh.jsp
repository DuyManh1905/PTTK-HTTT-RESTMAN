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
	
	<h1>Danh sách hóa đơn</h1>
	
	
	<div class="form-group">
	
		<div class="form-group">
	        <label for="startDate">Từ ngày: </label>
	        <input type="text" id="startDate" name="startDate" value="${startDate}">
	    </div>
	    
	    <div class="form-group">
	        <label for="endDate">Đến ngày: </label>
	        <input type="text" id="endDate" name="endDate" value="${endDate}">
	    </div>
	    
		<div>
	        <label for="tenkh">Khách hàng: </label>
	        <input type="input" id="tenkh" name="tenkh" value="${kh.ten}">
	    </div>
	   
	</div>
	
	<!-- Tính tổng số tiền -->
	<c:set var="totalTongTien" value="0" />
	<c:forEach var="hd" items="${listHd}">
	    <c:set var="totalTongTien" value="${totalTongTien + hd.tongTien}" />
	</c:forEach>
	
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>ID Hóa đơn</th>
				<th>Thời gian</th>
				<th>Tổng tiền</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<!--   for (Todo todo: todos) {  -->
				<c:forEach var="hd" items="${listHd}">
				<tr>
					<td><c:out value="${hd.id}" /></td>
					<td><c:out value="${hd.thoiGian}" /></td>
					<td><c:out value="${hd.tongTien} (VNĐ)" /></td>
					<td><a href="<%= request.getContextPath() %>/tkkh/detail/hd?id=<c:out value='${hd.id}' />&id_kh=${kh.id}">Xem
							chi tiết</a> &nbsp;&nbsp;&nbsp;&nbsp;
				</tr>
			</c:forEach>
			        <!-- Hiển thị tổng số tiền -->
		        <tr>
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