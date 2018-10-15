<p align="center"><%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View BookS</title>
</head>
<body>
<p align="center"></p><h2><u><a href="advancesearch" color="purple">Advance Search</a></u></h2><p></p>
<a href="bookinsert">+ Add Book</a>
 <p align="center"></p><h2>Search book</h2>
 
 

<form action="booksearch">
<input type="text" name="isbn">
<input type="submit" value="SEARCH">
</form>

     
     
    
     <p></p>
     <br><br><br><br><table border="10">
     <thead color="red">
     <tr>
          <th>Book Name</th>
          <th>Book Author</th>
          <th>Book Price</th>
          <th>ISBN</th>
     </tr>
     </thead>
     
     <tbody>
                            
              <c:forEach items="${booklist}" var="B">
              <tr>
              <td><c:out value="${B.bookName}"></c:out></td>
              
               <td><c:out value="${B.authorName}"></c:out></td>
               
                <td><c:out value="${B.bookPrice}"></c:out></td>
                
                 <td><c:out value="${B.bookIsbn}"></c:out></td>
              </tr>
              </c:forEach>
              
     </tbody>
     </table>

</body>
</html></p>