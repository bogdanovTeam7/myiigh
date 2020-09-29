package hu.ak_akademia.myiigh.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.ak_akademia.myiigh.db.dao.user.GetUserDao;
import hu.ak_akademia.myiigh.db.entity.User;
import hu.ak_akademia.myiigh.db.entity.UserStatus;
import hu.ak_akademia.myiigh.db.prepstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.myiigh.db.prepstatementwriter.user.GetUserByLoginNameAndPasswordHashPreparedStatementWriter;
import hu.ak_akademia.myiigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.myiigh.db.resultsetreader.user.GetUsersResultSetReader;
import hu.ak_akademia.myiigh.db.sqlbuilder.SQLBuilder;
import hu.ak_akademia.myiigh.db.sqlbuilder.user.GetUserByLoginNameAndPasswordHashSQLBuilder;
import hu.ak_akademia.myiigh.util.password.PasswordManager;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		loginName = loginName.trim();
		String password = request.getParameter("password");
		password = password.trim();
		if (loginName.length() < 1 || password.length() < 1) {
			response.sendRedirect("login.jsp");
			return;
		}

		String passwordHash = new PasswordManager().encrypt(password);

		SQLBuilder sqlBuilder = new GetUserByLoginNameAndPasswordHashSQLBuilder();
		PreparedStatementWriter preparedStatementWriter = new GetUserByLoginNameAndPasswordHashPreparedStatementWriter(
				loginName, passwordHash);
		ResultSetReader<User> resultSetReader = new GetUsersResultSetReader();
		GetUserDao dao = new GetUserDao(sqlBuilder, preparedStatementWriter, resultSetReader);
		List<User> users = dao.retrieve();

		if (users.isEmpty()) {
			request.setAttribute("errorLogin", "Sikertelen belépés");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {

			User loggedUser = users.get(0);

			UserStatus userStatus = loggedUser.getUserStatus();

			if (userStatus.getName()
					.equals("active")) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedUser", loggedUser);
				response.sendRedirect("userHome.jsp");
			} else {
				request.setAttribute("errorLogin", "Ez a felhasználó nem aktív");
				request.getRequestDispatcher("login.jsp")
						.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

}
