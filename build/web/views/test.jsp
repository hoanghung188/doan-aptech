<%-- 
    Document   : test
    Created on : Jun 27, 2020, 5:39:06 AM
    Author     : hoanghung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listProductById}" var="p">
            ${p.tenSanPham}
        </c:forEach>
        
      
            
       
    
</body>
</html>
