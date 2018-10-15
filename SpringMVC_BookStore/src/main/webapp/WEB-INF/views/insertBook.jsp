<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertBook</title>
</head>
<body>
 
 <h2><p align="center"><b><u>Add Book </u></b></p></h2>
 <p align="center"><font color="blue">${successmsg}</font>
 <font color="red">${errormsg}</font></p>
   
   <form:form action="insertbookreturn" method="POST" modelAttribute="book">
   <p align="center"><p align="center"><i><table>
              <tr>
              <td>BOOK ID=</td>
              <td><form:input path="bookId" /></td>
              </tr>
              
              <tr>
              <td>Book Name=</td>
              <td><form:input path="bookName" /></td>
              </tr>
              
              <tr>
              <td>Book Price=</td>
              <td><form:input path="bookPrice" /></td>
              </tr>
              
              <tr>
              <td>Author Name=</td>
              <td><form:input path="authorName" /></td>
              </tr>
              
              <tr>
              <td>Book Isbn=</td>
              <td><form:input path="bookIsbn" /></td>
              </tr>
              
              <tr>
              <td><input type="reset" value="RESET"></td>
              <td><input type="submit" value="STORE"></td>
              </tr>
              
              <tr>
              <td></td>
              
              </tr>
              
               
   </table></i></p><td><p align="center"><a href="search"><i>VIEW ALL BOOKS</i></a></p></td><i>   
   </i></p></form:form><i>
 

</i></body><i>
</i></html>