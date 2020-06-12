<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Systemy - MOSC</title>
    </head>
    <body>
        <div class="container">
            <!-- Logo -->
            <jsp:include page="../templates/header.jsp" />
            <!-- Buttons for ... -->
            <jsp:include page="../templates/buttons-softwares.jsp" />
            <!-- Tables -->
            <div id="activeSoftwaresInclude">
                <jsp:include page="../softwares/active-softwares.jsp" />
            </div>
            <div id="allSoftwaresInclude">
                <jsp:include page="../softwares/all-softwares.jsp" />
            </div>
        </div>
    </body>
</html>
