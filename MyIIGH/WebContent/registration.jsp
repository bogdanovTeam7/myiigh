<%@page import="java.time.LocalDate"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<title>regisztráció</title>
</head>
<body>
	<h1 class="display-4 text-center mt-4">Üdvözlöm!</h1>
	<h5 class="text-center">Ez az IIGH NetBank regisztrációs oldala</h5>

	<div class="container-xl">
		<img src="images/logo.jpg" alt="bank logójá"
			class="img-fluid rounded img-thumbnail float-left m-4" width="250">
	</div>
	<br>
	<h5>
		<u>Regisztráció fontos tudnivalók:</u>
	</h5>
	<%!String massege = "> *-gal jelöltek kötelező beadni <br>"
			+ "> felhasználónév és jelszó legalabb 8 és legfejebb 30 betűból állhat";%>
	<%!String errorMassege;%>

	<%
		Object errorsObj = request.getAttribute("errors");

		Map<String, String> errors = new HashMap<>();
		if (errorsObj != null && errorsObj instanceof HashMap) {
			errors = (HashMap<String, String>) errorsObj;
		}
		errorMassege = "";
		for (String error : errors.values()) {
			errorMassege += "<br>" + (String) error;
		}
	%>
	<h6 class="myInfo">
		<%
			out.print(massege);
		%>
	</h6>

	<h6 class="myError">
		<%
			out.print(errorMassege);
		%>
	</h6>
	<br clear="all">
	<div class="container-xl">
		<form action="registration" method="post">
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="loginName">Felhasználónév*</label> <input type="text"
						class="form-control" name="loginName" id="loginName"
						placeholder="1példaElek" value="${param.loginName}"> <small
						id="passwordHelpBlock" class="form-text text-muted"> A
						felhasználónévnek egyedinek kell lennie; ha foglalt nevet választ,
						a rendszer értesíti róla. Kérjük, ügyeljen arra, hogy
						felhasználóneve ne tartalmazzon szóközt, ékezetes betűt vagy
						különleges karaktert (pl. csillag, plusz jel). A rendszer
						megkülönbözteti a kis- és nagybetűket. </small>
				</div>
				<div class="form-group col-md-4">
					<label for="userRole">Szerepkör*</label> <select name="userRole"
						id="userRole" class="form-control">
						<option selected value="0">Válasson...</option>
						<option value="1">Adminisztrátor</option>
						<option value="2">Ügyfél</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="password">Jelszó*</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="********"> <small id="passwordHelpBlock"
						class="form-text text-muted"> A jelszó csak betűkből és
						számokból állhat, legalább 8 karakter hosszúságú legyen, legalább
						egy számot tartalmaznia kell. A rendszer megkülönbözteti a kis- és
						nagybetűket. </small>
				</div>
				<div class="form-group col-md-6">
					<label for="confirmationPassword">Jelszó újra*</label> <input
						type="password" class="form-control" name="confirmationPassword"
						id="confirmationPassword">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="lastName">Vezetéknév*</label> <input type="text"
						class="form-control" name="lastName" id="lastName"
						placeholder="Példa" value="${param.lastName }">
				</div>
				<div class="form-group col-md-6">
					<label for="firstName">Keresztnév*</label> <input type="text"
						class="form-control" name="firstName" id="firstName"
						placeholder="Elek" value="${param.firstName }">
				</div>
			</div>
			<div class="form-group">
				<label for="address">Levelezési cím*</label> <input type="text"
					class="form-control" name="address" id="address"
					placeholder="1010 Budapest Fő utca 1. 1." value="${param.address }">
			</div>
			<div class="form-row">
				<div class="form-group col-md-5">
					<label for="email">Email*</label> <input type="email"
						class="form-control" name="email" id="email"
						placeholder="pelda.elek@gmail.com" value="${param.email }">
				</div>
				<div class="form-group col-md-4">
					<label for="phone">Telefonszám*</label> <input id="text"
						class="form-control" name="phone" id="phone"
						placeholder="36 20 123 4567" value="${param.phone }">
				</div>
				<div class="form-group col-md-3">
					<%!String birthday = "";%>
					<%
						if (request.getParameter("dateOfBirth") != null) {
							birthday = request.getParameter("dateOfBirth");
						}
					%>
					<label for="dateOfBirth">Születési dátum</label> <input type="date"
						class="form-control" name="dateOfBirth" id="dateOfBirth"
						value=<%=birthday%>>
				</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" name="newsletter"
						id="newsletter"> <label class="form-check-label"
						for="newsletter"> Hírleveleket kérek</label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Regisztráció</button>
		</form>

		<br clear="all">
		<h5 class="text-center">Vagy válassza az alábbiak közül:</h5>

		<div>
			<form action="login" method="get">
				<div>
					<button type="submit" name="action" value="login"
						class="btn btn-primary  btn-lg btn-mylg m-4">Belépés</button>
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