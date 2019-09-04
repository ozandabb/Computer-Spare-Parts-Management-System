<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section id="main-sec2">
		<form action="removeItemServlet" method="POST">
		
			<h4>Cancel Order</h4>
			<p>Order id, we already sent to your email account.Please check that.</p><br>
			
			<input type="text" placeholder="" name="pid" class="pname" required>
			<input class="itg-button active" type = "submit" value = "Remove"><br><br>
	   </form>
	   </section>
	   
	   
</body>
</html>