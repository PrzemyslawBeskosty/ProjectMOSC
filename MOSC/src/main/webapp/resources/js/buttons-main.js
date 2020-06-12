function disactivateAllButtons() {
    $("#activeContractsButton").removeClass("btn-primary").addClass("btn-secondary");
    $("#allContractsButton").removeClass("btn-primary").addClass("btn-secondary");
    $("#allSystemsButton").removeClass("btn-primary").addClass("btn-secondary");
    $("#aboutApplicationButton").removeClass("btn-primary").addClass("btn-secondary");
}

function hideAllContent() {
    $("#activeContractsInclude").hide();
    $("#allContractsInclude").hide();
    $("#allSystemsInclude").hide();
    $("#aboutApplicationInclude").hide();
}

function buttonClick(buttonId) {
    //Start up click
    hideAllContent();
    disactivateAllButtons();
    //Specific button action
    $(buttonId + "Button").removeClass("btn-secondary").addClass("btn-primary");
    $(buttonId + "Include").show();
}


$(document).ready(function () {
    //Prepare view by 'clicking' for user.
    buttonClick("#aboutApplication");

    //Change active button to... and change the view...
    $("#activeContractsButton").click(function () {
        buttonClick("#activeContracts");
    });
    $("#allContractsButton").click(function () {
        buttonClick("#allContracts");
    });
    $("#allSystemsButton").click(function () {
        buttonClick("#allSystems");
    });
    $("#aboutApplicationButton").click(function () {
        buttonClick("#aboutApplication");
    });
});