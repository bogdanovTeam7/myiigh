<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
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
<title>bejelentkezés</title>
</head>
<body>
	<h1 class="display-4 text-center mt-4">Üdvözlöm!</h1>
	<h5 class="text-center">Ez az IIGH NetBank bejelentkezési oldala</h5>

	<div class="container-xl">
		<img src="images/logo.jpg" alt="bank logójá"
			class="img-fluid rounded img-thumbnail float-left m-4" width="250">
	</div>
	<%!String massege = "";%>
	<%!String successMassege = "";%>
	<%
		if (request.getAttribute("errorLogin") != null) {
			massege = (String) request.getAttribute("errorLogin") + ", probáljon újra!";
		}
		if (Boolean.TRUE.equals(request.getAttribute("successfulRegistration"))) {
			successMassege = "Sikeres regisztráció, aktiválás után itt bejelentkezhet";
		}
	%>
	<h4 class="myError">
		<%=massege%>
	</h4>
	<h4 class="mySuccess">
		<%=successMassege%>
	</h4>
	<div class="container-xl">
		<form action="login" class="was-validated" method="post">
			<div class="form-group">
				<label for="loginName">Felhasználónév:</label> <input type="text"
					class="form-control btn-mylg" id="loginName"
					placeholder="1példaElek" name="loginName" required>
				<div class="valid-feedback">Rendben van.</div>
				<div class="invalid-feedback">Ez a mező nem lehet üres.</div>
			</div>
			<div class="form-group">
				<label for="password">Jelszó:</label> <input type="password"
					class="form-control btn-mylg" id="password" placeholder="********"
					name="password" required>
				<div class="valid-feedback">Rendben van.</div>
				<div class="invalid-feedback">Ez a mező nem lehet üres.</div>
			</div>
			<button type="submit" class="btn btn-primary">Bejelentkezés</button>
		</form>
		<br clear="all">
		<h5 class="text-center">Vagy válassza az alábbiak közül:</h5>

		<div>
			<form action="registration" method="get">
				<div>
					<button type="submit" name="action" value="registration"
						class="btn btn-primary  btn-lg btn-mylg m-4">Regisztráció</button>
				</div>
			</form>
			<form action="index" method="get">
				<div>
					<button type="submit" name="action" value="index"
						class="btn btn-primary btn-lg  btn-mylg m-4">Nyitóoldal</button>
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