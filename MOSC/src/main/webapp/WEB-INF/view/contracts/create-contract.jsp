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
            <jsp:include page="../templates/buttons-contracts-back.jsp" />
            <div class="row">
                <div class="col-md-6 order-md-1">
                    <h4 class="mb-3">Dodaj umowę</h4>
                    <form:form action="createContractAction" modelAttribute="contract" method="POST">
                        <form:hidden path="id" />
                        <div class="mb-3">
                            <label for="contractId">Numer kontraktu: </label>
                            <form:input id="contractId" path="contractNumber" type="text" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <label for="systemId">System: </label>
                            <form:select id="systemId" path="clientSystem" class="form-control" >
                                <form:option disabled="true" value="${null}" label="---" />
                                <form:options items="${listOfSoftwares}" itemValue="id" itemLabel="name" />
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <label for="dateFromId">Data od: </label>
                            <form:input id="dateFromId" path="dateFrom" type="date" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <label for="dateToId" >Data do: </label>
                            <form:input id="dateToId" path="dateTo" type="date" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <label for="amountId" >Kwota: </label>
                            <form:input id="amountId" path="amount" type="number" step="0.25" value="0.00" class="form-control" />
                        </div>
                        <div class="mb-3">
                            <label for="currencyId">Waluta: </label>
                            <form:select id="currencyId" path="currency" class="form-control" >
                                <form:option disabled="true" value="${null}" label="---" />
                                <form:options items="${currencyMap}" />
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <label for="amountTypeId">Rodzaj rozliczenia: </label>
                            <form:select id="amountTypeId" path="amountType" class="form-control" >
                                <form:option disabled="true" value="${null}" label="---" />
                                <form:options items="${amountTypeMap}" />
                            </form:select>
                        </div>
                        <div class="mb-3">
                            <label for="amountPeriodId">Okres rozliczenia: </label>
                            <form:select id="amountPeriodId" path="amountPeriod" class="form-control" >
                                <form:option disabled="true" value="${null}" label="---" />
                                <form:options items="${amountPeriodMap}" />
                            </form:select>
                        </div>
                        <hr class="mb-4">
                        <input type="submit" value="Zapisz" class="btn btn-primary btn-block" />              
                    </form:form>
                </div>
                <div class="col-md-6 order-md-2">
                    <h4 class="mb-3">Wczytaj umowy z pliku</h4>
                    <form:form action="uploadContractAction" enctype="multipart/form-data" method="POST">
                        <div class="mb-3">
                            <label for="chooseFileId">Wybierz plik we formacie '*.xlsx'</label>
                            <input id="chooseFileId" type="file" name="file" class="form-control" />  
                        </div>
                        <hr class="mb-4">
                        <input type="submit" value="Załaduj plik" class="btn btn-primary btn-block" />   
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
