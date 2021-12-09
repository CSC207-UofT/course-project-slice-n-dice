function generateWelcomePage(changePage) {

    // Create main container
    let mainContainer = document.createElement("div");
    mainContainer.className = "welcome-container-fluid";

    let mainRow = document.createElement("div");
    mainRow.className = "row";

    let buttonRow = document.createElement("div");
    buttonRow.className = "row";

    let mainColumn = document.createElement("div");
    mainColumn.className = "col-12";

    let spacer = document.createElement("img");
    spacer.setAttribute("src", "./spacer.png");
    spacer.setAttribute("height", "200");
    mainColumn.appendChild(spacer);

    let hea = document.createElement("H1");
    let title = document.createTextNode("Welcome to MatchPoint.");
    hea.appendChild(title);
    mainColumn.appendChild(hea);

    let welcome1 = document.createTextNode("We're excited you're here.");
    mainColumn.appendChild(welcome1);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let welcome2 = document.createTextNode("You're only seconds away from meeting tennis matches in your area.");
    mainColumn.appendChild(welcome2);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let welcome3 = document.createTextNode("Use the match and pass buttons on the next page to navigate through the profiles of your potential matches.");
    mainColumn.appendChild(welcome3);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let welcome4 = document.createTextNode("Matches are displayed in order of most compatible to least compatible.");
    mainColumn.appendChild(welcome4);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let welcome5 = document.createTextNode("Use the Edit Profile and My Stats buttons to view and edit your data.");
    mainColumn.appendChild(welcome5);

    let spacer3 = document.createElement("img");
    spacer3.setAttribute("src", "./spacer.png");
    spacer3.setAttribute("height", "50");
    mainColumn.appendChild(spacer3);

    let subhead = document.createElement("H3");
    let welcome6 = document.createTextNode("Game. Set.");
    subhead.appendChild(welcome6);
    mainColumn.appendChild(subhead);

    let spacer2 = document.createElement("img");
    spacer2.setAttribute("src", "./spacer.png");
    spacer2.setAttribute("height", "50");
    mainColumn.appendChild(spacer2);

    let goButton = document.createElement("button");
    goButton.type = "button";
    goButton.className = "btn btn-primary";
    goButton.textContent = "Match!";
    goButton.onclick = onGoButtonClick;
    mainColumn.appendChild(goButton);


    function onGoButtonClick(){
        changePage("match");
    }


    mainRow.appendChild(mainColumn);

    mainContainer.appendChild(buttonRow);
    mainContainer.appendChild(mainRow);


    return mainContainer;

}


export { generateWelcomePage };