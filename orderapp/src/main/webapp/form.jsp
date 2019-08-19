<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Form</title>
</head>
<body>
	<h2>Product Form</h2>
	<form:form action="addproduct.do" modelAttribute="product"> <!-- modelAttribute is the name given by ProductController to the that object -->
		Name <form:input path="name"/><br> <!-- path is to link the field to the Product class attribute -->
		Category <form:input path="category"/><br>
		Price <form:input path="price"/><br>
		Count <form:input path="count"/><br>
		<button type="submit">Add Product</button>
	</form:form>
</body>
</html>