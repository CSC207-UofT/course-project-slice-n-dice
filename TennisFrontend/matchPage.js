import {loadJSONFromFile} from './filemanager.js';

var buffer = "";
var data = "";
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


function generateMatchPage(changePage) {

    // Have a loading sequence, waiting for the file to change 
    // Call waiting function here
    // Then, call the read function and display 


    
    let mainContainer = document.createElement("div");
    mainContainer.className = "match-container-fluid";

    let mainRow = document.createElement("div");
    mainRow.className = "row";

    let buttonRow = document.createElement("div");
    buttonRow.className = "row";

    let mainColumn = document.createElement("div");
    mainColumn.className = "col-12";

    // READING DATA ==========================
    readTextFile("./pipe1.json");
    let matches = JSON.parse(buffer)["profiles"];

    // =======================================

    let logo = document.createElement("img");
    logo.setAttribute("src", "./giphy.gif");
    logo.setAttribute("width", "300");
    mainColumn.appendChild(logo);

    let spacer = document.createElement("img");
    spacer.setAttribute("src", "./spacer.png");
    spacer.setAttribute("height", "50");
    mainColumn.appendChild(spacer);

    // DISPLAY MATCH BEGINS ===============

    var currindex = 0;

    let pic = document.createElement("img");
    pic.setAttribute("src", matches[0]["photo"]);
    pic.setAttribute("width", "300");
    mainColumn.appendChild(pic);

    let spacer2 = document.createElement("img");
    spacer2.setAttribute("src", "./spacer.png");
    spacer2.setAttribute("height", "30");
    mainColumn.appendChild(spacer2);

    var user = document.createTextNode(matches[0]["username"]);
    mainColumn.appendChild(user);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    var bio = document.createTextNode(matches[0]["bio"]);
    mainColumn.appendChild(bio);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    var age = document.createTextNode("Age: " + matches[0]["age"]);
    mainColumn.appendChild(age);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    var skilllevel = document.createTextNode("Skill Level: " + matches[0]["skilllevel"]);
    mainColumn.appendChild(skilllevel);

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    var loc = document.createTextNode("Location: " + matches[0]["region"]);
    mainColumn.appendChild(loc);
    
    function onMatchButtonClick(){
        alert("It's a match! Send them a message.");
        currindex ++;
        if (currindex < matches.length) {
            repopulateMatch(currindex, matches);
        }
        else {
            alert("You've seen all the potential matches for today. Check back soon!")
        }
        

    }

    function onPassButtonClick(){
        currindex ++;
        if (currindex < matches.length) {
            repopulateMatch(currindex, matches);
        }
        else {
            alert("You've seen all the potential matches for today. Check back soon!")
        }
    }

    function repopulateMatch(currindex, matches){
        pic.setAttribute("src", matches[currindex]["photo"]);
        user.nodeValue = matches[currindex]["username"];
        bio.nodeValue = matches[currindex]["bio"];
        age.nodeValue = "Age: " + matches[currindex]["age"];
        skilllevel.nodeValue = "Skill Level: " + matches[0]["skilllevel"];
        loc.nodeValue = "Location: " + matches[currindex]["region"];
    }



    
    // DISPLAY MATCH ENDS

    var linebreak = document.createElement("BR");
    mainColumn.appendChild(linebreak);

    let spacer3 = document.createElement("img");
    spacer3.setAttribute("src", "./spacer.png");
    spacer3.setAttribute("height", "30");
    mainColumn.appendChild(spacer3);

    let matchButton = document.createElement("button");
    matchButton.type = "button";
    matchButton.className = "btn btn-primary";
    matchButton.textContent = "Match!";
    matchButton.onclick = onMatchButtonClick;

    let textspace = document.createTextNode("   ");


    let passButton = document.createElement("button");
    passButton.type = "button";
    passButton.className = "btn btn-primary";
    passButton.textContent = "Pass";
    passButton.onclick = onPassButtonClick;

    mainColumn.appendChild(matchButton);
    mainColumn.appendChild(textspace);
    mainColumn.appendChild(passButton);

    let spacer4 = document.createElement("img");
    spacer4.setAttribute("src", "./spacer.png");
    spacer4.setAttribute("height", "30");
    mainColumn.appendChild(spacer4);

    function onEditProfileButtonClick(){
        changePage("edit");
    }

    let profileButton = document.createElement("button");
    profileButton.type = "button";
    profileButton.className = "btn btn-light";
    profileButton.textContent = "Edit Profile";
    profileButton.onclick = onEditProfileButtonClick;
    mainColumn.appendChild(profileButton);

    function onStatsButtonClick() {
        changePage("stats");
    }

    let statsButton = document.createElement("button");
    statsButton.type = "button";
    statsButton.className = "btn btn-light";
    statsButton.textContent = "My Stats";
    statsButton.onclick = onStatsButtonClick;
    mainColumn.appendChild(statsButton);

    


    mainRow.appendChild(mainColumn);

    mainContainer.appendChild(buttonRow);
    mainContainer.appendChild(mainRow);

    return mainContainer;


}


export { generateMatchPage };




