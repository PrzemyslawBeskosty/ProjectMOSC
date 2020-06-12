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
                <div class="col-sm-6 col-12 my-1">
                    <button id="backButton" type="sumbit" class="btn btn-block btn-secondary" 
                            onclick="window.location.href = 'showSoftwaresForm'; return false;">Powrót</button>
                </div>
                <div class="col-sm-6 col-12 my-1">
                    <button id="backButton" type="sumbit" class="btn btn-block btn-secondary" 
                            onclick="location.href = '/MOSC/'">Strona Główna</button>
                </div>
            </div>
        </div>
    </body>
</html>