<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/original/common.css">
<link rel="stylesheet" href="css/original/header.css">
<title>更新</title>
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
				<h1>ユーザー情報更新</h1>
				<H1>　</H1>
			<form class="form-signin" action="UpdateServlet" method="post">
			<input type="hidden" name="id" value="${userid.id}">
				<h3>ログインID　　　　　　　　　　　　　　${userid.name}</h3>

				<h3>パスワード　　　　　　<input type="text" name="password"></h3>

				<h3>パスワード（確認）　　<input type="text" name="password"></h3>

				<h3>ユーザー名　　　　　　<input type="text" name="user_name"></h3>

				<h3>生年月日　　　　　　　　　　　<input type="text" name="birth_date" size="10" value="年/月/日"></h3>

				<div class="btn-wrapper">
					<button class="btn btn-primary" type="submit">更新</button>
				</div>
			</form>

		</div>
	</div>
<a class="btn btn-primary" href="UserListServlet" role="button">戻る</a>

</body>
</html>