<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.ShohinBean"%>
<%@ page import="java.util.ArrayList"%>

<%
    // 問① EmployeeController.javaから渡されたBeanを受けとります。
    ArrayList<ShohinBean> shohinBean = (ArrayList<ShohinBean>) request.getAttribute("shohinBean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/index.css">
<title>検索結果</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<ul>
				<li><a href="index.html"><h1>WorkShop</h1></a></li>
				<li><a href="">ITEMS</a></li>
				<li><a href="">FEATURE</a></li>
				<li><a href="">COORDINATE</a></li>
				<li><a href="">SHOP</a></li>
				<li><a href="">CONTENT</a></li>
				<li><a href=""><i class="far fa-heart"></i></a></li>
				<li><a href=""><i class="fas fa-user"></i></a></li>
				<li><a href=""><i class="fas fa-shopping-cart"></i></a></li>
				<li><input type="text-box" placeholder="Search"> <i class="fas fa-search"></i></li>
			</ul>
		</div>
		<div class="title">
			<h1>ITEMS</h1>
			<p>商品</p>
		</div>
		<div class="items">
			<%for(ShohinBean d: shohinBean){%>
			<div class="item">
				<img src="<%=d.getImgURL()%>" width="150" height="150">
				<p><%=d.getName()%></p>
				<p>¥<%=d.getPrice()%>(税込)</p>
			</div>
			<%}%>
		</div>
	</div>
</body>
</html>