package Authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Authentication.queries.AuthenticationQueries;

import global.CurrentUser;
import global.MyValidators;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/displayInfo.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username : " + username + " password : " + password);

		if (!MyValidators.stringValidation(username) || !MyValidators.stringValidation(password))
			return;

		AuthenticationQueries aq = new AuthenticationQueries();
		try {
			if (aq.signIn(username, password)) {
				request.setAttribute("user", CurrentUser.user);
				getServletContext().getRequestDispatcher(url).forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/AuthenticaionView.jsp").forward(request, response);
				System.out.print("error signing in");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
