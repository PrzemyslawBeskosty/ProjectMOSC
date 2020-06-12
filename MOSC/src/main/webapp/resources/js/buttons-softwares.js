function disactivateAllButtons() {
    $("#activeSoftwaresButton").removeClass("btn-primary").addClass("btn-secondary");
    $("#allSoftwaresButton").removeClass("btn-primary").addClass("btn-secondary");
}

function hideAllContent() {
    $("#activeSoftwaresInclude").hide();
    $("#allSoftwaresInclude").hide();
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
    buttonClick("#activeSoftwares");

    //Change active button to... and change the view...
    $("#activeSoftwaresButton").click(function () {
        buttonClick("#activeSoftwares");
    });
    $("#allSoftwaresButton").click(function () {
        buttonClick("#allSoftwares");
    });
});