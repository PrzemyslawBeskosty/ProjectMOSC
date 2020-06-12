function disactivateAllButtons() {
    $("#activeContractsButton").removeClass("btn-primary").addClass("btn-secondary");
    $("#allContractsButton").removeClass("btn-primary").addClass("btn-secondary");
}

function hideAllContent() {
    $("#activeContractsInclude").hide();
    $("#allContractsInclude").hide();
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
    buttonClick("#activeContracts");

    //Change active button to... and change the view...
    $("#activeContractsButton").click(function () {
        buttonClick("#activeContracts");
    });
    $("#allContractsButton").click(function () {
        buttonClick("#allContracts");
    });
});