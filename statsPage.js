var buffer = "";
var data = "";

var wins = 0;
var losses = 0;

function readTextFile(file)
{
    buffer = "";
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
                buffer = rawFile.responseText;
               
            }
        }
    }
    rawFile.send(null);

    return buffer;
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

    // READ DATA ==========
    readTextFile("./statspipe1.json");
    let data = JSON.parse(buffer);
    console.log(data);

    let numGamesPlayedText = document.createTextNode("You've played a total of " + (wins + losses) + " games.");
    mainColumn.appendChild(numGamesPlayedText);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);


    let winsLossesText = document.createTextNode("(" + wins + " wins and " + losses + " losses).");
    mainColumn.appendChild(winsLossesText);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let winRateText = document.createTextNode("Your win rate is " + ((wins/losses)*100) + "%.");
    mainColumn.appendChild(winRateText);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let winLossRatioText = document.createTextNode("Your win/loss ratio is " + (wins/losses) + ".");
    mainColumn.appendChild(winLossRatioText);

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
        wins ++;
        numGamesPlayedText.nodeValue = "You've played a total of " + (wins + losses) + " games.";
        winsLossesText.nodeValue = "(" + wins + " wins and " + losses + " losses)."; 
        winRateText.nodeValue = "Your win rate is " + ((wins/losses)*100) + "%.";
        winLossRatioText.nodeValue = "Your win/loss ratio is " + (wins/losses) + ".";
    }


    function onLossButtonClick(){
        losses ++;
        numGamesPlayedText.nodeValue = "You've played a total of " + (wins + losses) + " games.";
        winsLossesText.nodeValue = "(" + wins + " wins and " + losses + " losses)."; 
        winRateText.nodeValue = "Your win rate is " + ((wins/losses)*100) + "%.";
        winLossRatioText.nodeValue = "Your win/loss ratio is " + (wins/losses) + ".";
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
    //logo.setAttribute("width", "300");
    mainColumn.appendChild(ball);





    mainRow.appendChild(mainColumn);

    mainContainer.appendChild(buttonRow);
    mainContainer.appendChild(mainRow);


    return mainContainer;

}


export { generateStatsPage };