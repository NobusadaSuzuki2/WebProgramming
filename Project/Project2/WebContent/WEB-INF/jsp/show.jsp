<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報詳細</title>
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
				<h1>ユーザー情報詳細参照</h1>
				<H1>　</H1>
				<h3>ログインID　　　　　　　　　　</h3>
				<h3>ユーザー名　　　　　　　　　　</h3>
				<h3>生年月日　　　　　　　　　　</h3>
				<h3>登録日時　　　　　　　　　　</h3>
				<h3>更新日時　　　　　　　　　　</h3>
		</div>
	</div>
<a class="btn btn-primary" href="UserListServlet" role="button">戻る</a>


</body>
</html>