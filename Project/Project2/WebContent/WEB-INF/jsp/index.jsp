<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー一覧</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/original/common.css">
<link rel="stylesheet" href="css/original/header.css">
</head>
<body>
	<header>
		<div class="container">
			<a style="color: #9d9d9d">${userInfo.name} さん </a>
			<div class="header-right">
				<a href="LogoutServlet" class="logout">ログアウト</a>
			</div>
		</div>
	</header>

	<div class="top-wrapper">
		<div class="container">
			<h1>ユーザー一覧</h1>
			<div class="btn-wrapper" align="right">
				<a class="btn btn-success" href="signupServlet" role="button">新規登録</a>
			</div>
			<h3>
				ログインID<input type="text" name="rogin_id">
			</h3>
			<h3>
				ユーザー名<input type="text" name="user_name">
			</h3>
			<h3>
				生年月日<input type="text" name="example3" size="10" placeholder="年/月/日">
				<input type="text" name="example4" size="10" placeholder="年/月/日">
			</h3>
			<div class="btn-wrapper">
				<a href="#" class="btn search">検索</a>
			</div>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>ログインID</th>
						<th>ユーザー名</th>
						<th>生年月日</th>
					</tr>
				</thead>
				<tr>
					<c:forEach var="user" items="${userList}">
						<tr>
							<td>${user.loginId}</td>
							<td>${user.name}</td>
							<td>${user.birthDate}</td>

							<td><c:if test="${userInfo.loginId =='admin'}">
									<c:if test="${user.loginId !='admin'}">
										<a class="btn btn-primary" href="showServlet?id=${user.id}">詳細</a>
										<a class="btn btn-success" href="UpdateServlet?id=${user.id}">更新</a>
										<a class="btn btn-danger" href="DestroyServlet?id=${user.id}">削除</a>
									</c:if>
								</c:if> <c:if test="${userInfo.loginId != 'admin'}">
									<c:if test="${user.loginId !='admin'}">
										<a class="btn btn-primary" href="showServlet?id=${user.id}">詳細</a>
										<c:if test="${userInfo.loginId == user.loginId}">
											<a class="btn btn-success" href="UpdateServlet?id=${user.id}">更新</a>
										</c:if>
									</c:if>
								</c:if></td>


						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>