<%-- 
    Document   : index
    Created on : Jul 18, 2017, 8:44:13 PM
    Author     : pradeep
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body border="1">
        <h1>Order Manager</h1>
        <div
            <select name="customers">
                <option value="">Select Customers </option>
                <c:forEach var ="c" items="${customers}">
                    <option value="${c.id}" ${c.firstName} ${c.lastName}</option>
                </c:forEach>
           
        </div>
        <table>
           
            
        </table>    
    </body>
</html>
