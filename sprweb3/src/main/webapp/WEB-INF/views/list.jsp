<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
(1) 결과는 ${msg} <!-- EL 사용 --><br>

(2) 결과는 ${requestScope.msg}<br>

<% String ss = (String)request.getAttribute("msg"); %>
(3) 결과는 <%=ss %>
</body>
</html>