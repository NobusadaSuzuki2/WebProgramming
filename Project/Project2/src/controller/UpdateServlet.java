package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");

			//idを引数にして、idに紐づくユーザ情報を出力する
			UserDao userDao = new UserDao();
			User userid = userDao.findByUserInfo(id);

			// ユーザ情報をリクエストスコープにセットしてjspにフォワード
			request.setAttribute("userid", userid);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
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
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String user_name = request.getParameter("user_name");
		String birthDate = request.getParameter("birth_date");
		String id = request.getParameter("id");
		//ここから暗号化のコード-------------------------------------------------------------------------------
		//ハッシュを生成したい元の文字列
		String source = password;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";
		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);
		//ここまでが暗号化のコード---------------------------------------------------------------------------
		if (user_name.equals("") || birthDate.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "未入力の欄があります");
			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (password.equals("") && password2.equals("")) {
			//idを引数にして、idに紐づくユーザ情報を出力する
			UserDao userDao = new UserDao();
			userDao.updateInfo(user_name, birthDate, id);
			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("UserListServlet");
			return;

		} else if (password.equals(password2)) {
			//idを引数にして、idに紐づくユーザ情報を出力する
			UserDao userDao = new UserDao();
			userDao.updateInfo(result, user_name, birthDate, id);

			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("UserListServlet");
			return;
		}
		// リクエストスコープにエラーメッセージをセット
		request.setAttribute("errMsg", "確認用パスワードが異なります");
		// 更新jspにフォワード(失敗した時に元の画面に戻る)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
