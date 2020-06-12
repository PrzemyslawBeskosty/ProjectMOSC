<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
    <head>
        <title> MOSC </title>
        <!-- Jquery -->
        <script type="text/javascript" src="webjars/jquery/3.5.1/dist/jquery.js" ></script>
        <!-- Popper -->
        <script src="webjars/popper.js/1.16.1/dist/umd/popper.min.js" ></script>
        <!-- Jquery dataTables -->
        <link rel="stylesheet" type="text/css" href="webjars/datatables/1.10.21/css/jquery.dataTables.css">
        <script src="webjars/datatables/1.10.21/js/jquery.dataTables.js" ></script>
        <!-- Boostrap 4 -->
        <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.5.0/css/bootstrap.css" >
        <script src="webjars/bootstrap/4.5.0/js/bootstrap.js" ></script>
        <!-- add class for header -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css" />
        <script src="${pageContext.request.contextPath}/resources/js/header.js"></script>

    </head>
    <body> 
        <div class="preloader">
            <img class="preloader-gif" src="${pageContext.request.contextPath}/resources/images/loading.gif">
        </div
        <!-- 'Logo' -->
        <div class="page-header" style="text-align: center;" >
            <h1>MOSC - Manager of Software Contracts</h1>
        </div>
    </body>
</html>