<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Umowy - MOSC</title>
    </head>
    <body>
        <div class="container">
            <!-- Logo -->
            <jsp:include page="../templates/header.jsp" />
            <!-- Buttons for ... -->
            <jsp:include page="../templates/buttons-contracts.jsp" />
            <!-- Tables -->
            <div id="activeContractsInclude">
                <jsp:include page="../contracts/active-contracts.jsp" />
            </div>
            <div id="allContractsInclude">
                <jsp:include page="../contracts/all-contracts.jsp" />
            </div>
        </div>
    </body>
</html>
