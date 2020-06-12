<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Klienci - MOSC </title>
    </head>
    <body>
        <div class="container">
            <!-- Logo -->
            <jsp:include page="../templates/header.jsp" />
            <!-- Buttons for ... -->
            <jsp:include page="../templates/buttons-clients.jsp" />
            <!-- Tables -->
            <div id="activeClientsInclude">
                <jsp:include page="../clients/active-clients.jsp" />
            </div>
            <div id="allClientsInclude">
                <jsp:include page="../clients/all-clients.jsp" />
            </div>
        </div>
    </body>
</html>
