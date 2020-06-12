function disactivateAllButtons() {
    $("#activeClientsButton").removeClass("btn-primary").addClass("btn-secondary");
    $("#allClientsButton").removeClass("btn-primary").addClass("btn-secondary");
}

function hideAllContent() {
    $("#activeClientsInclude").hide();
    $("#allClientsInclude").hide();
}

function buttonClick(buttonId) {
    //Start up click
    disactivateAllButtons();
    hideAllContent();
    //Specific button action
    $(buttonId + "Button").removeClass("btn-secondary").addClass("btn-primary");
    $(buttonId + "Include").show();
}


$(document).ready(function () {
    //Prepare view by 'clicking' for user.
    buttonClick("#activeClients");

    //Change active button to... and change the view...
    $("#activeClientsButton").click(function () {
        buttonClick("#activeClients");
    });
    $("#allClientsButton").click(function () {
        buttonClick("#allClients");
    });
});