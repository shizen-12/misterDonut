package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GachaLogic;
import model.Item;

@WebServlet("/MisterDonutGacha")
public class MisterDonutGacha extends HttpServlet {
	private static final long serialVersionUID = 1L;


//	public void init(ServletConfig config) throws ServletException {
//		
//	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//最初にここに来たらindex.jspへ行くよ
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//フォームからsubmitしたらここに来るよ。
		//アプリケーションスコープの作成
		ServletContext context = request.getServletContext();
		//ガチャテーブル用のListを作成
		List<Item> gachaList = new ArrayList<Item>();
		
		//ガチャ結果用のListを作成
		List<Item> gachaResult = new ArrayList<Item>();
		
		//ガチャ使用金額を受け取る
		//もしint型に変更できない場合 errMsgを入れてフォワードする
		int price = 0;
		try {
			price = Integer.parseInt(request.getParameter("price"));
		} catch (NumberFormatException e) {
		    System.out.println("money is not a valid integer number");
		    String errMsg = "金額は半角数字で入力してね";
		    request.setAttribute("errMsg", errMsg);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
		}
		
		//最初にアプリケーションスコープからドーナツメニューをリストに追加するよ
		List<Item> donutMenu = (List)context.getAttribute("donutMenu");
		gachaList.addAll(donutMenu);
		
		//次に送られてきたデータにドリンクも含む情報があったらgachaListにドリンクも追加するよ
		String drinkInclude = null;
		drinkInclude = request.getParameter("drinkInclude");
		if (drinkInclude != null && drinkInclude.equals("drink")) {
			gachaList.addAll((List)context.getAttribute("drinkMenu"));
		}
		
		
		
		//Logicにリストを渡してガチャをしてもらうよ
		GachaLogic gachaLogic = new GachaLogic();
		gachaResult = gachaLogic.execute(gachaList,price);
		
		//セッションスコープにガチャの結果を入れるよ
//		context.setAttribute("gachaResult", gachaResult);
		HttpSession session = request.getSession();
		session.setAttribute("gachaResult", gachaResult);
		
		//結果のjspにフォワードするよ
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
		
	}

}
