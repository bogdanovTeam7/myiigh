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
<title>nyítóoldal</title>
</head>
<body>
	<h1 class="display-4 text-center mt-4">Üdvözlöm!</h1>
	<h5 class="text-center">Ez az IIGH NetBank nyító oldala</h5>
	<div class="container-xl">
		<img src="images/logo.jpg" alt="bank logójá"
			class="img-fluid rounded img-thumbnail float-left m-4" width="250">
		<div>
			<form action="login" method="get">
				<div>
					<button type="submit" name="action" value="login"
						class="btn btn-primary btn-lg  btn-mylg m-5">Bejelentkezés</button>
				</div>
			</form>
			<form action="registration" method="get">
				<div>
					<button type="submit" name="action" value="registration"
						class="btn btn-primary  btn-lg btn-mylg m-5">Regisztráció</button>
				</div>
			</form>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>