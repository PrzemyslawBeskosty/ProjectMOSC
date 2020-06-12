<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
    <head>
        <script src="${pageContext.request.contextPath}/resources/js/buttons-softwares.js"></script>
    </head>
    <body>
        <!--Buttons panel -->
        <div id="moscButtons" style="margin-top: 15px; margin-bottom: 15px">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="activeSoftwaresButton" type="sumbit" class="btn btn-block">Aktywne systemy</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="allSoftwaresButton" type="sumbit" class="btn btn-block">Wszystkie systemy</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="addSoftwareButton" type="sumbit" class="btn btn-block btn-secondary"
                            onclick="window.location.href = 'showCreateSoftwareForm'; return false;">Dodaj system</button>
                </div>
                <div class="col-md-3 col-sm-6 col-12 my-1">
                    <button id="backButton" type="sumbit" class="btn btn-block btn-secondary" 
                            onclick="location.href = '/MOSC/'">Powrót</button>
                </div>
            </div>
        </div>
    </body>
</html>