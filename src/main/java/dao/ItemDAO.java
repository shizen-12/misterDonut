package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Item;

public class ItemDAO {
	//データベースに接続する情報
	private final String DB_PATH = "jdbc:mysql://localhost:3306/misterDonut";
	//送信するクエリの文字コード設定
	private final String DB_CHARACTER_ENCODE = "?useUnicode=true&characterEncoding=utf8";
	//データベースのユーザー名
	private final String DB_USER = "root";
	//DBのパス
	private final String DB_PASS = "root";
	//JDBCドライバーの場所
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	public ItemDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<Item> createDonutMenu(List<Item> donutMenu) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(DB_PATH +
				DB_CHARACTER_ENCODE, DB_USER, DB_PASS)) {
			
			//SELECT文を準備
			//ドリンク以外を抽出
			String sql = "SELECT * FROM ITEMS WHERE CATEGORY NOT LIKE '%ドリンク%'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				//ドーナツが存在してたら取得
				//ドーナツインスタンスを生成
				//メニューに追加
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int kcal = rs.getInt("kcal");
				String imgPath = rs.getString("imgPath");
				String category = rs.getString("category");
				donutMenu.add(new Item(name,price,kcal,imgPath,category));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return donutMenu;
	}
	
	public List<Item> createDrinkMenu(List<Item> drinkMenu) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(DB_PATH +
				DB_CHARACTER_ENCODE, DB_USER, DB_PASS)) {
			
			//SELECT文を準備
			//ドリンクを抽出
			String sql = "SELECT * FROM ITEMS WHERE CATEGORY LIKE '%ドリンク%'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				//ドリンクが存在してたら取得
				//ドリンクインスタンスを生成
				//メニューに追加
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int kcal = rs.getInt("kcal");
				String imgPath = rs.getString("imgPath");
				String category = rs.getString("category");
				drinkMenu.add(new Item(name,price,kcal,imgPath,category));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return drinkMenu;
	}
}
