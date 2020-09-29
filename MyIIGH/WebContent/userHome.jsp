<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<title>ügyfél nyító oldala</title>
</head>
<body>
	<h1 class="display-4 text-center mt-4">Üdvözlöm!</h1>
	<h5 class="text-center">Ez a semélyes oldala</h5>

	<div class="container-xl">
		<img src="images/logo.jpg" alt="bank logójá"
			class="img-fluid rounded img-thumbnail float-left m-4" width="250">
	</div>

	<div class="container-xl">
		<form action="login" class="was-validated" method="post">
			<div class="form-group">
				<label for="loginName">Felhasználó név:</label> <input type="text"
					class="form-control btn-mylg" id="loginName"
					placeholder="Példa Tamás" name="loginName" required>
				<div class="valid-feedback">Rendben van.</div>
				<div class="invalid-feedback">Ez a mező nem lehet üres.</div>
			</div>
			<div class="form-group">
				<label for="password">Jelszó:</label> <input type="password"
					class="form-control btn-mylg" id="password" placeholder="******"
					name="password" required>
				<div class="valid-feedback">Rendben van.</div>
				<div class="invalid-feedback">Ez a mező nem lehet üres.</div>
			</div>
			<button type="submit" class="btn btn-primary">Bejelentkezés</button>
		</form>


	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>