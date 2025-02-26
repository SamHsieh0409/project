<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Student</title>
	</head>
	<body>
		<h1>${ message } ${ student.name }</h1>
		<h1>年齡: ${ student.age }</h1>
		<h1>分數: ${ student.score }</h1>
		<h1>判定: ${ student.score ge 60 ? "及格":"不及格" }</h1>
		<h1>${ food }</h1>
		<h1>${ price }</h1>
	</body>
</html>