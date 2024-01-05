<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%
//アプリケーションスコープからインスタンスを取得
List<Item> gachaResult = (ArrayList)session.getAttribute("gachaResult");
%>
<%
int kcalSum = 0;
int priceSum = 0;
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/index.css" />
<meta charset="UTF-8">
<title>ガチャ結果</title>
</head>
<body>

	<div class="main">
	<h1>ガチャResult</h1>
	
	
	<% for (Item item : gachaResult) {
		String name = item.getName();
		int price = item.getPrice();
		int kcal = item.getKcal();
		String imgPath = item.getImgPath();
		String category = item.getCategory();
		
		kcalSum += kcal;
		priceSum += price;
		
		String cate = null;
		switch (category){
				case "ドーナツ":
					cate = "donut";
					break;
				case "パイ":
					cate = "pie";
					break;
				case "マフィン":
					cate = "muffin";
					break;
				case "トッピング":
					cate = "topping";
					break;
				case "ホットドッグ":
					cate = "hotdog";
					break;
				case "ドリンク":
					cate = "drink";
					break;
				default:
					cate = "donut";
					break;
			}
		%>
		<div class="resultLine">
			<div class="<%=cate%>">
				<%=category%>
			</div>
			
			<div class="names">
				<%= name%>&#009;
			</div>
			
			<div>
				 <%= kcal%>kcal&#009;<%= price%>円
			</div>
			<div>
				<img src="<%=imgPath%>" class="resultImg"><br>
			</div>
		</div>
	<%}%>
		<div class="resultSum">
			<div class="sumChild">ガチャ合計</div>
			<div class="sumChild"><%= kcalSum %>kcal</div>
			<div class="sumChild"><%= priceSum %>円</div>
		</div>
	

		<form action="MisterDonutGacha" method="post">
			<input type="hidden" name="price" value="1000">
			ドリンクメニューを含む<input type="checkbox" name="drinkInclude" value="drink"><br>
			<input type="submit" value="もう1000円回す">
		</form>
			<br>
			<a href="MisterDonutGacha">トップページへ</a><br>
			&#009;<br>
			<a href="https://twitter.com/share?text=ドーナツを<%=priceSum %>円分食べたい" class="twitter-share-button" data-show-count="false">Tweet</a>
			<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
	</div>
</body>
</html>