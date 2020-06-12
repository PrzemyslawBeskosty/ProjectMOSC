<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/resources/js/buttons-clients.js"></script>
    </head>
    <body>
        <!--Buttons panel -->
        <div id="moscButtons" style="margin-top: 15px; margin-bottom: 15px">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="activeClientsButton" type="sumbit" class="btn btn-block">Aktywny klienci</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="allClientsButton" type="sumbit" class="btn btn-block">Wszyscy klienci</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="addClientButton" type="sumbit" class="btn btn-block btn-secondary"
                            onclick="window.location.href = 'showCreateClientForm'; return false;">Dodaj klienta</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="backButton" type="sumbit" class="btn btn-block btn-secondary" 
                            onclick="location.href = '/MOSC/'">Powrót</button>
                </div>
            </div>
        </div>
    </body>
</html>