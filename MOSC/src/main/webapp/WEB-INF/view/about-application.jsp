<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
    <head>
        <title> MOSC </title>
    </head>
    <body>
        <div class="jumbotron" align="center">
            <div>
                <h1 class="display-2">Hello world!</h1>
                <small class="text-muted">Aplikacja została przygotowana w celach rekrutacyjno-rozwojowych.</small>
                <br>
                <div class="h5">
                    <p></p>
                    <p> Witam cię w mojej aplikacji, Miło cię tutaj widzieć :) </p>
                    <p> W celu przymieszczania się w aplikacji korzystaj z górnych przycisków. </p>
                    <a href="https://github.com/PrzemyslawBeskosty/ProjectMOSC">Dokładny opis aplikacji znajduje się TU.</a>
                    <p></p>
                </div>
            </div>
            <div id="accordion" class="small">
                <div id="headingTwo">
                    <h5 class="mb-0">
                        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            Różnica między JUNIORem a SENIORem... Kliknij i sprawdź.
                        </button>
                    </h5>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
                    <div class="card-body">
                        <img class="preloader-gif" src="${pageContext.request.contextPath}/resources/images/meme-01.jpg">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>