<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" >
            //Initialize dataTable
            $(document).ready(function () {
                $('#activeContractsDataTable').DataTable();
            });
        </script>
    </head>
    <body>
        <div class="container">
            <table id="activeContractsDataTable" class="display">
                <!-- Header for table -->
                <thead>
                    <tr style="background-color: lightgray;">
                        <th>Numer Umowy</th>
                        <th>System</th>
                        <th>Od</th>
                        <th>Do</th>
                        <th>Wpływy</th>
                        <th>W skali</th>
                        <th>Status</th>
                        <th>Akcje</th>
                    </tr>
                </thead>
                <!-- Data for table -->
                <tbody>
                    <c:forEach var="tempContract" items="${activeContracts}">
                        <c:url var="updateLink" value="showUpdateContractForm">
                            <c:param name="contractId" value="${tempContract.id}"/>
                        </c:url>
                        <c:url var="deleteLink" value="deleteContractAction">
                            <c:param name="contractId" value="${tempContract.id}"/>
                        </c:url>
                        <tr>
                            <td>${tempContract.contractNumber}</td>
                            <td>${tempContract.clientSystem.name}</td>
                            <td>${tempContract.dateFrom}</td>
                            <td>${tempContract.dateTo}</td>
                            <td>${tempContract.cashInflows}</td>
                            <td>${tempContract.amountPeriodBundled}</td>
                            <td>${tempContract.statusBundled}</td>
                            <td>
                                <a href="${updateLink}">Edytuj</a>
                                |
                                <a onclick="if (!(confirm('Czy chcesz usunąć wybraną umowę?')))
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
