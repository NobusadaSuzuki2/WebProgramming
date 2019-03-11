<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/original/common.css" rel="stylesheet">

</head>
<body>
	<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>
	<div class="top-wrapper">
		<div class="container">

				<h1>ログイン画面</h1>
				<h1>　</h1>
				<form class="form-signin" action="LoginServlet" method="post">
				<h3>ログインID<input type="text" name="loginId"></h3>
				<h3>パスワード<input type="text" name="password"></h3>
				<div class="btn-wrapper">
					<button class="btn btn-primary" type="submit">ログイン</button>
				</div>
				</form>
				<!-- <p>まだ登録をお済みで無い方はこちらから</p>
				<div class="btn-wrapper">
					<a class="btn btn-success" href="signup.html" role="button">新規登録</a>
				</div> -->
		</div>
	</div>
</body>
</html>