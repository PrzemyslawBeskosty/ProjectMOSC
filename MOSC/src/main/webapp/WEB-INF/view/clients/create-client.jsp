<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj klienta - MOSC</title>
    </head>
    <body>
        <div class="container">
            <!-- Logo -->
            <jsp:include page="../templates/header.jsp" />
            <!-- Buttons for ... -->
            <jsp:include page="../templates/buttons-clients-back.jsp" />
            <div class="col-md-6">
                <h4 class="mb-3">Dodaj klienta</h4>
                <form:form  action="createClientAction" modelAttribute="client" method="POST">
                    <form:hidden path="id" />
                    <div class="mb-3">
                        <label for="clientName">Nazwa klienta</label>
                        <form:input id="clientName" path="name" type="text" class="form-control" />
                    </div>
                    <hr class="mb-4">
                    <input type="submit" value="Zapisz" class="btn btn-primary btn-block" />
                </form:form>
            </div>
        </div>
    </body>
</html>
