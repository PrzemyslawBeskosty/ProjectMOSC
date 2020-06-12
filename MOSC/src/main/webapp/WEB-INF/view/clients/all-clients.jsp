<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" >
            //Initialize dataTable
            $(document).ready(function () {
                $('#allClients').DataTable();
            });
        </script>
    </head>
    <body>
        <table id="allClients" class="display">
            <!-- Header for table -->
            <thead>
                <tr>
                    <th>Nazwa klienta</th>
                    <th>Status</th>
                    <th>Akcje</th>
                </tr>
            </thead>
            <!-- Data for table -->
            <tbody>
                <c:forEach var="tempClient" items="${allClients}">
                    <c:url var="updateLink" value="showUpdateClientForm">
                        <c:param name="clientId" value="${tempClient.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="deleteClientAction">
                        <c:param name="clientId" value="${tempClient.id}"/>
                    </c:url>
                    <tr>
                        <td>${tempClient.name}</td>
                        <td>${tempClient.statusBundled}</td>
                        <td>
                            <a href="${updateLink}">Edytuj</a>
                            |
                            <a onclick="if (!(confirm('Czy chcesz usunąć wybranego klienta?')))
                                        return false"
                               href="${deleteLink}">Usuń</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
