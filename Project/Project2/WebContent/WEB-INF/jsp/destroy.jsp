<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/original/common.css">
<link rel="stylesheet" href="css/original/header.css">
</head>
<body>
	<header>
		<div class="container">
          	<a style="color:#9d9d9d">${userInfo.name} さん </a>
			<div class="header-right">
				<a href="LogoutServlet" class="logout">ログアウト</a>
			</div>
		</div>
	</header>

	<div class="top-wrapper">
		<div class="container">
				<h1>ユーザー削除確認</h1>
				<H1>　</H1>
				<h3>ログインID　　　${userid.name}</h3>

				<p>を本当に削除してよろしいでしょうか。</p>
			<form class="form-signin" action="DestroyServlet" method="post">
				<input type="hidden" name="id" value="${userid.id}">
				<div class="btn-wrapper">
					<a class="btn btn-primary" href="UserListServlet" role="button">キャンセル</a>
					<button class="btn btn-danger" type="submit">OK</button>
				</div>
			</form>
		</div>
	</div>




</body>
</html>