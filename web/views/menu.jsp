<%-- 
    Document   : menu
    Created on : Jun 19, 2020, 4:53:54 PM
    Author     : hoanghung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- NAVIGATION -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="index.htm">Trang Chủ</a></li>
                        <c:forEach items="${listTypeProducts}" var="p">
                        <li><a>${p.nameTypeProduct}</a></li>
                        </c:forEach>
                        
                        
                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>
        <!-- /NAVIGATION -->
</html>
