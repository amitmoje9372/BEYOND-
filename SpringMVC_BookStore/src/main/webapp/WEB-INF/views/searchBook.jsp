<p align="center"><%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advanced Book Search</title>
</head>
<body>

	<h3>Advanced Book Search</h3>
	
	<a href="bookinsert">+ Add Book</a>

	<form:form action="booksAdvSearch" method="POST" modelAttribute="b">
		<table>
			<tr>
				<td>Book Name:</td>
				<td><form:input path="bookName" /></td>
			</tr>
			<tr>
				<td>Book Price:</td>
				<td><form:input path="bookPrice" /></td>
			</tr>
			<tr>
				<td>Author Name:</td>
				<td><form:input path="authorName" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form:form>
	<hr>
	<table cellpadding="1" border="1">
		<thead>
			<tr>
				<th>Book ISBN</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Author Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.bookIsbn}" /></td>
					<td><c:out value="${book.bookName}" /></td>
					<td><c:out value="${book.bookPrice}" /></td>
					<td><c:out value="${book.authorName}" /></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html></p>