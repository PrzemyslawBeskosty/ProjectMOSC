<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj system - MOSC</title>
    </head>
    <body>
        <div class="container">
            <!-- Logo -->
            <jsp:include page="../templates/header.jsp" />
            <!-- Buttons for ... -->
            <jsp:include page="../templates/buttons-softwares-back.jsp" />
            <div class="col-md-6">
                <h4 class="mb-3">Dodaj system</h4>
                <form:form action="createSoftwareAction" modelAttribute="software" method="POST">
                    <form:hidden path="id" />
                    <div class="mb-3">
                        <label for="systemNameId">Nazwa systemu</label>
                        <form:input id="systemNameId" path="name" type="text" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="descId">Opis systemu</label>
                        <form:input id="descId" path="description" type="text" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="techDescId">Opis technologii</label>
                        <form:input id="techDescId" path="technicalDescription" type="text" class="form-control" />
                    </div>
                    <div class="mb-3">
                        <label for="clientId">Klient</label>
                        <form:select id="clientId" path="softwareClient" class="form-control" >
                            <form:option disabled="true" value="${null}" label="---" />
                            <form:options items="${listOfClients}" itemValue="id" itemLabel="name" />
                        </form:select>
                    </div>
                    <hr class="mb-4">
                    <input type="submit" value="Zapisz" class="btn btn-primary btn-block" />
                </form:form>
            </div>
        </div>
    </body>
</html>
