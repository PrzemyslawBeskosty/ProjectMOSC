<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" >
            //Initialize dataTable
            $(document).ready(function () {
                $('#activeSoftwaresDataTable').DataTable();
            });
        </script>
    </head>
    <body>
        <div class="container">
            <table id="activeSoftwaresDataTable" class="display">
                <!-- Header for table -->
                <thead>
                    <tr style="background-color: lightgray;">
                        <th>Nazwa systemu</th>
                        <th>Opis systemu</th>
                        <th>Opis technologii</th>
                        <th>Klient</th>
                        <th>Status</th>
                        <th>Akcje</th>
                    </tr>
                </thead>
                <!-- Data for table -->
                <tbody>
                    <c:forEach var="tempSoftware" items="${activeSoftwares}">
                        <c:url var="updateLink" value="showUpdateSoftwareForm">
                            <c:param name="softwareId" value="${tempSoftware.id}"/>
                        </c:url>
                        <c:url var="deleteLink" value="deleteSoftwareAction">
                            <c:param name="softwareId" value="${tempSoftware.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempSoftware.name}</td>
                            <td>${tempSoftware.description}</td>
                            <td>${tempSoftware.technicalDescription}</td>
                            <td>${tempSoftware.softwareClient.name}</td>
                            <td>${tempSoftware.statusBundled}</td>
                            <td>
                                <a href="${updateLink}">Edytuj</a>
                                |
                                <a onclick="if (!(confirm('Czy chcesz usunąć wybrany system?')))
                                            return false"
                                   href="${deleteLink}">Usuń</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>