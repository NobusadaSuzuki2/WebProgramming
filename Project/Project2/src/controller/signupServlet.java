package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();

		// リクエストスコープから"userInfo"インスタンスを取得
		User loginId = (User) session.getAttribute("userInfo");

		if (loginId == null) {
			response.sendRedirect("LoginServlet");
			return;
		} else {

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String user_name = request.getParameter("user_name");
		String birthDate = request.getParameter("birthDate");

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		UserDao userDao = new UserDao();
		User user = userDao.findByInfo(loginId);
		//loginIdがすでに存在していた場合
		if (user != null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "このログインIDは既に使われています");
			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (loginId.equals("") || password.equals("") || password2.equals("") || user_name.equals("") || birthDate.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "未入力の欄があります");
			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (password.equals(password2)) {

			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
			UserDao userDao2 = new UserDao();
			userDao2.createInfo(loginId, password, user_name, birthDate);
			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("UserListServlet");
			return;

		} else {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "確認用パスワードが異なります");

			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

	}
}
