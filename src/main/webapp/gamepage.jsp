<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./assets/css/style.css" rel="stylesheet" />
<title>Game guess</title>
</head>
<body>
<%String path =  request.getContextPath();%>
	<div class="content">
	<h1 class="heading1">GAME ĐOÁN SỐ</h1>
	<h2 class="heading2">Hãy nhập vào số dự đoán của bạn từ 1 đến 1000</h2>
		<form action="<%= path %>/gamepage" method="post" class="form_game">
			<input type="text" name="numberguess" class="form_game_text">
			<input type="submit" name="btnguess" value="Dự Đoán" class="form_game_submit">
			<!-- dong h3 lấy data từ sevlet  -->
			<% if(request.getAttribute("message")!=null){ %>
				<h2><%=request.getAttribute("message") %></h2>
					
			<%	} %>
			<br/><br/>
			<input type="submit" name="btnexit" value="Exit Game" class="form_game_submit">
			<input type="submit" name="btnrate" value="Xếp Hạng " class="form_game_submit">
			<br/><br/>
			<% if(request.getAttribute("xephang")!=null){ %>
				<h2><%=request.getAttribute("xephang") %></h2>
				<h2>Tên người chơi : <%=request.getAttribute("tennnguoichoi") %></h2>
				<h2>Số lần dự đoán : <%=request.getAttribute("solandudoan") %></h2>
					
			<%	} %>
		</form>
		
		
	</div>
</body>
</html>