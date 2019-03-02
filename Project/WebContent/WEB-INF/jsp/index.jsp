<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー一覧</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="header.css">
</head>
<body>
	<header>
		<div class="container">
			<div class="header-right">
  				<a href="Login.html" class="login">ログアウト</a>
			</div>
		</div>
	</header>

	<div class="top-wrapper">
		<div class="container">
				<h1>ユーザー一覧</h1>
				<div class="btn-wrapper" align="right">
					<a class="btn btn-success" href="signup.html" role="button">新規登録</a>
				</div>
				<h3>ログインID<input type="text" name="rogin_id"></h3>
				<h3>ユーザー名<input type="text" name="user_name"></h3>
				<h3>生年月日<input type="text" name="example3" size="10" value="年/月/日">
							<input type="text" name="example4" size="10" value="年/月/日"></h3>
				<div class="btn-wrapper">
					<a href="#" class="btn search">検索</a>
				</div>

				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">ログインID</th>
				      <th scope="col">ユーザー名</th>
				      <th scope="col">生年月日</th>
				      <th scope="col"></th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>
				      	<a class="btn btn-primary" href="show.html" role="button">詳細</a>
				      	<a class="btn btn-success" href="update.html" role="button">更新</a>
				      	<a class="btn btn-danger" href="destroy.html" role="button">削除</a>
				      </td>
				    </tr>
				    <tr>
				      <th scope="row">2</th>
				      <td>Jacob</td>
				      <td>Thornton</td>
				      <td>
				      	<a class="btn btn-primary" href="show.html" role="button">詳細</a>
				      	<a class="btn btn-success" href="update.html" role="button">更新</a>
				      	<a class="btn btn-danger" href="destroy.html" role="button">削除</a>
				      </td>
				    </tr>
				    <tr>
				      <th scope="row">3</th>
				      <td>Larry</td>
				      <td>the Bird</td>
				      <td>
				      	<a class="btn btn-primary" href="show.html" role="button">詳細</a>
				      	<a class="btn btn-success" href="update.html" role="button">更新</a>
				      	<a class="btn btn-danger" href="destroy.html" role="button">削除</a>
				      </td>
				    </tr>
				  </tbody>
				</table>
		</div>
	</div>
</body>
</html>