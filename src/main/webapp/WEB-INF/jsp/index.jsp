<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errMsg = (String)request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ミスタードーナツガチャ</title>
<link rel="stylesheet" href="css/index.css" />
</head>
<body>
	<header>
	<h2>ミスタードーナツ 1000円ガチャ</h1>
	</header>
	
	<div class="main">
	<h1>misterDonut 1000円ガチャ</h1>
	<form action="MisterDonutGacha" method="post">
		いくら回す？<br>
		<input type="text" class="txt" name="price" value="1000">円<br>
		<%if (errMsg != null) {%>
			<%=errMsg %><br>
		<%}%>
		ドリンクメニューを含む<input type="checkbox" name="drinkInclude" value="drink"><br>
		<input type="submit" value="ガチャを回す！"><br>
		&#009;<br>
		<a href="https://twitter.com/share?ref_src=twsrc%5Etfw;" class="twitter-share-button" data-show-count="false">Tweet</a>
		<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
	</form>

	<img src="img/back.jfif" class="ico"/>
	</div>

</body>
</html>