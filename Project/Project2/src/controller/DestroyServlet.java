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
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/DestroyServlet")
public class DestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DestroyServlet() {
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
		//ユーザーがログインしているか確認
		if (loginId == null) {
			response.sendRedirect("LoginServlet");
			return;
		} else {
			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");

			//idを引数にして、idに紐づくユーザ情報を出力する
			UserDao userDao = new UserDao();
			User userid = userDao.findByUserInfo(id);

			// ユーザ情報をリクエストスコープにセットしてjspにフォワード
			request.setAttribute("userid", userid);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/destroy.jsp");
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

		// hiddenがついたインプットのformからIDパラメータを受け取る
		String id = request.getParameter("id");

		try {
			//idを引数にして、idに紐づくユーザ情報を出力する
			UserDao userDao = new UserDao();
			userDao.destroy(id);
		} catch (NullPointerException e) {
			e.printStackTrace();
			// 削除jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/destroy.jsp");
			dispatcher.forward(request, response);
		}
		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("UserListServlet");
		return;
	}

}
