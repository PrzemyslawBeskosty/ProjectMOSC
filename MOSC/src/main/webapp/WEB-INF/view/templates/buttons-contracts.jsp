<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/resources/js/buttons-contracts.js"></script>
    </head>
    <body>
        <!--Buttons panel -->
        <div id="moscButtons" style="margin-top: 15px; margin-bottom: 15px">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="activeContractsButton" type="sumbit" class="btn btn-block">Aktywne umowy</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="allContractsButton" type="sumbit" class="btn btn-block">Wszystkie umowy</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="addClientButton" type="sumbit" class="btn btn-block btn-secondary"
                            onclick="window.location.href = 'showCreateContractForm'; return false;">Dodaj umowę</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="backButton" type="sumbit" class="btn btn-block btn-secondary" 
                            onclick="location.href = '/MOSC/'">Powrót</button>
                </div>
            </div>
        </div>
    </body>
</html>