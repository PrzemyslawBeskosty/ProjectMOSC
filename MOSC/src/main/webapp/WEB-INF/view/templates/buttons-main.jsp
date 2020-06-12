<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
    <head>
        <title> MOSC </title>
        <script src="${pageContext.request.contextPath}/resources/js/buttons-main.js"></script>
    </head>
    <body>
        <!--Buttons panel -->
        <div id="moscButtons" style="margin-top: 15px; margin-bottom: 15px">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="activeContractsButton" type="sumbit" class="btn btn-block btn-secondary"
                            onclick="window.location.href = 'showContractsForm'; return false;">Umowy</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="allContractsButton" type="sumbit" class="btn btn-block btn-secondary"
                            onclick="window.location.href = 'showSoftwaresForm'; return false;">Systemy</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="allSystemsButton"  type="sumbit" class="btn btn-block btn-secondary"
                            onclick="window.location.href = 'showClientsForm'; return false;">Klienci</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="aboutApplicationButton" type="sumbit" class="btn btn-block btn-secondary">O aplikacji</button>
                </div>
            </div>
        </div>
    </body>
</html>