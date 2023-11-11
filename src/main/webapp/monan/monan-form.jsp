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
	
	<style type="text/css">
		.flex-row {
			display: flex;
			justify-content: space-between;
		}
	</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="<%=request.getContextPath()%>/home"> Rest Man </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/home"
					class="nav-link">Khách hàng</a></li>
			</ul>
		</nav>
	</header>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${monan != null}">
					<form action="update" method="post">
				</c:if>

				<c:if test="${monan == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${monan != null}">
            			Chi tiết món ăn
            		</c:if>
						<c:if test="${monan == null}">
            			Chi tiết món ăn
            		</c:if>
					</h2>
				</caption>

				<c:if test="${monan != null}">
					<input type="hidden" name="id"
						value="<c:out value='${monan.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Tên món ăn</label> <input type="text"
						value="<c:out value='${monan.ten}' />" class="form-control"
						name="ten" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Đơn vị</label> <input type="text"
						value="<c:out value='${monan.donVi}' />" class="form-control"
						name="donVi">
				</fieldset>

				<fieldset class="form-group">
					<label>Giá</label> <input type="text"
						value="<c:out value='${monan.gia}' />" class="form-control"
						name="gia">
				</fieldset>

				<fieldset class="form-group">
					<label>Mô tả</label>
					<textarea class="form-control" name="moTa" rows="4"><c:out
							value="${monan.moTa}" /></textarea>
				</fieldset>

				</form>

				<div class="flex-row">
					<button onclick="goBack()" class="btn btn-primary">Quay lại</button>
					<button onclick="alert('Chức năng đang phát triển')" class="btn btn-primary">Thêm vào giỏ hàng</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function goBack() {
   	 		window.history.back();
		}
	</script>
</body>
</html>