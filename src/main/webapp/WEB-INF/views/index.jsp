<%-- 
    Document   : index
    Created on : Jul 18, 2017, 8:44:13 PM
    Author     : pradeep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body border="1">
        <h1>Customers</h1>
        <div>
            <p>
                <a href="${pageContext.request.contextPath}/add">Add Customer</a>
            </p>
        </div>
           
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact No</th>
            </tr>
            
            <c:forEach var="c" items="${customer}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.firstName}</td>
                    <td>${c.email}</td>
                    <td>${c.contactNo}</td>
                </tr>
               
                
            </c:forEach>
        </table>    
    </body>
</html>
