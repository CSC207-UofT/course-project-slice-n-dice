import { loadJSONFromFile, saveJSONToFile } from "./filemanager.js";


var data = "";

var wins = 0;
var losses = 0;
var gamesPlayed = 0;


function waitAndUpdateCurrentJSON(){
    let resultJSON= {}
    while (true) {
        let result = loadJSONFromFile("./statspipe1.json");
        if (result !== null){
            resultJSON = JSON.parse(result);
            break;
        }
        else {
            return;
        }
    }
    if (resultJSON.hasOwnProperty("gamesPlayed") && resultJSON.hasOwnProperty("winRate") && resultJSON.hasOwnProperty("winLossRatio")) {
        updateMainColumn(resultJSON);
    } else {
        console.log("Warning: statspipe1 doesn't have all the required field. Not updating the page.");
    }
}



function updateMainColumn(result) {

    document.getElementById("num_games_played").innerText = "You've played a total of " + result["gamesPlayed"] + " games.";
    document.getElementById("wins_losses").innerText = "(" + result["wins"] + " wins and " + result["losses"] + " losses).";
    document.getElementById("win_rate").innerText = "Your win rate is " + result["winRate"] + "%.";
    document.getElementById("win_loss_ratio").innerText = "Your win/loss ratio is " + result["winLossRatio"]+ ".";

}   

function generateStatsPage(changePage) {

    // Create main container
    let mainContainer = document.createElement("div");
    mainContainer.className = "stats-container-fluid";

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
    let title = document.createTextNode("Statistics");
    hea.appendChild(title);
    mainColumn.appendChild(hea);


    let numGamesPlayedDiv = document.createElement("div");
    numGamesPlayedDiv.id = "num_games_played";
    numGamesPlayedDiv.innerText = "You've played a total of 0 games.";
    mainColumn.appendChild(numGamesPlayedDiv);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);


    let winsLossesDiv = document.createElement("div");
    winsLossesDiv.id = "wins_losses";
    winsLossesDiv.textContent = "(0 wins and 0 losses).";
    mainColumn.appendChild(winsLossesDiv);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let winRateDiv = document.createElement("div");
    winRateDiv.id = "win_rate";
    winRateDiv.innerText = "Your win rate is 0%.";
    mainColumn.appendChild(winRateDiv);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let winLossRatioDiv = document.createElement("div");
    winLossRatioDiv.id = "win_loss_ratio";
    winLossRatioDiv.innerText = "Your win/loss ratio is 0.";
    mainColumn.appendChild(winLossRatioDiv);

    let spacer2 = document.createElement("img");
    spacer2.setAttribute("src", "./spacer.png");
    spacer2.setAttribute("height", "35");
    mainColumn.appendChild(spacer2);
    

    let winButton = document.createElement("button");
    winButton.type = "button";
    winButton.className = "btn btn-light";
    winButton.textContent = "Log a Win";
    winButton.onclick = onWinButtonClick;
    mainColumn.appendChild(winButton);

    let spacetext = document.createTextNode("   ");
    mainColumn.appendChild(spacetext);

    let lossButton = document.createElement("button");
    lossButton.type = "button";
    lossButton.className = "btn btn-light";
    lossButton.textContent = "Log a Loss";
    lossButton.onclick = onLossButtonClick;
    mainColumn.appendChild(lossButton);

    function onWinButtonClick(){
        saveJSONToFile("win");

        waitAndUpdateCurrentJSON();
    }


    function onLossButtonClick(){
        saveJSONToFile("loss");
        waitAndUpdateCurrentJSON();
    }

    

    let spacer3 = document.createElement("img");
    spacer3.setAttribute("src", "./spacer.png");
    spacer3.setAttribute("height", "35");
    mainColumn.appendChild(spacer3);

    let backButton = document.createElement("button");
    backButton.type = "button";
    backButton.className = "btn btn-primary";
    backButton.textContent = "Back";
    backButton.onclick = onBackButtonClick;
    mainColumn.appendChild(backButton);

    function onBackButtonClick(){
        changePage("match");
    }

    let ball = document.createElement("img");
    ball.setAttribute("src", "./ball.gif");
    mainColumn.appendChild(ball);

    mainRow.appendChild(mainColumn);

    mainContainer.appendChild(buttonRow);
    mainContainer.appendChild(mainRow);


    return mainContainer;

}


export { generateStatsPage };